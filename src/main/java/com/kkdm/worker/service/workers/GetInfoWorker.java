package com.kkdm.worker.service.workers;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.web.client.RestTemplate;

import com.kkdm.worker.dao.TopicHistoryDao;
import com.kkdm.worker.dao.TopicTagsDao;
import com.kkdm.worker.dao.TopicsDao;
import com.kkdm.worker.dao.WorkDao;
import com.kkdm.worker.model.TopicHistory;
import com.kkdm.worker.model.Work;
import com.kkdm.worker.service.WorkService;
import com.quya.core.utils.DateTimeUtils;
import com.quya.core.utils.JStringUtils;
import com.quya.core.utils.MysqlUtils;

public class GetInfoWorker {
	private static GetInfoWorker instance;
	//
	public static GetInfoWorker getInstance(){
		if(instance == null){
			instance = new GetInfoWorker();
		}
		return instance;
	}
	//
	public int getInfo(Work work){

		String url = "http://www.kkmh.com/web/topic/{id}";
		RestTemplate restTemplate = new RestTemplate();
		//
		Calendar calendar = Calendar.getInstance();  
		int today = calendar.get(calendar.DAY_OF_MONTH);
		//
		int topicId = 0;
		int gid = 0;
		int realCount = 0;
		int timetime = DateTimeUtils.getTime();
		String timeDate = DateTimeUtils.getYYYYMMDD();
		String yestoday = DateTimeUtils.getYestoday();
		String yestodayHisId = ""; 
		Map<String,Object> topicData;
//		System.out.println("today:"+today);
		for(realCount=0;realCount<5;realCount++){
			topicData  = TopicsDao.getInstance().getNeedInfoId(today);
//			System.out.println("topicData:"+topicData);
			if(topicData == null){
				//表示没有可获取的topic，获取完成 ， 改变任务状态
				WorkDao.getInstance().setState(WorkService.WORK_STATE_ANALYSIS, work.getWid());
				return realCount;
			}
			topicId = (Integer)topicData.get("id");
			gid = (Integer)topicData.get("gid");
			String html = (String) restTemplate.getForObject(url, String.class, new Object[] { topicId });
			
			// 分析 html 获取
			// 1, 评论 key2key
			String commentTagData = JStringUtils.key2key(html, "<em>评论:</em>", "</span>");
			String likesTagData = JStringUtils.key2key(html, "<em>赞:</em>", "</span>");
			String hotTagData = JStringUtils.key2key(html, "&#xe619;</i>", "</span>");
			
			System.out.println("hotTagData:"+hotTagData);
			
			long commentCount = this.toLong(commentTagData);
			long likesCount = this.toLong(likesTagData);
			long hotCount = this.toLong(hotTagData);

			System.out.println("hotCount:"+hotCount);
			// 添加历史记录
			TopicHistory topicHistory = new TopicHistory(topicId,gid, likesCount, hotCount, commentCount,timetime,timeDate, calendar);
			yestodayHisId = topicId + "-" + yestoday;
//			System.out.println("yestodayHisId:"+yestodayHisId);
			Map<String,Object> oldData = TopicHistoryDao.getInstance().getOldData(yestodayHisId);

//			System.out.println("oldData:"+oldData);
			
			topicHistory.setOldData(oldData); //计算今天增量
			

//			System.out.println("topicHistory.getMapData():"+topicHistory.getMapData());
			
			
			MysqlUtils.insert("tbtopichistory", topicHistory.getMapData());	
			
			// 添加标签数据
			TopicTagsDao.getInstance().addData(topicId, gid);
			
			// 更新topic . updateDay
			TopicsDao.getInstance().setUpdateDay(topicId, today);
		}
		
		return realCount;
		
	}
	//
	private long toLong(String data){
		long l = 0;
//		System.out.println("1|"+data);
		if(null==data || "".equals(data.trim())){
			return 0;
		}
		int danwei = 1;
		if(data.indexOf("亿")>0){
			danwei = 100000000;
			data = data.replaceFirst("亿", "");
		}else if(data.indexOf("万")>0){
			danwei = 10000;
			data = data.replaceFirst("万", "");
		}
		//
		data = data.replaceAll("[ ,]+", "");
		String tdata = data.replaceAll("[ .,]+", "");
		if(JStringUtils.isNumeric(tdata)==false){
			return 0;
		}
		double d = Double.valueOf(data);
		d = d * danwei;
		
//		System.out.println("2|"+d);
		l = Math.round(d);
		return l;
	}

}
