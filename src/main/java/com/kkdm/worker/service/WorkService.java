package com.kkdm.worker.service;

import com.kkdm.worker.dao.GenreDao;
import com.kkdm.worker.dao.TopicTagsDao;
import com.kkdm.worker.dao.WorkDao;
import com.kkdm.worker.model.Work;
import com.kkdm.worker.service.workers.AnalysisWoker;
import com.kkdm.worker.service.workers.GetInfoWorker;
import com.kkdm.worker.service.workers.GetTopicWorker;
import com.quya.core.utils.DateTimeUtils;

public class WorkService {
	//
	public static int WORK_STATE_CREATE = 0;
	public static int WORK_STATE_UPDATE_TOPICS = 1;
	public static int WORK_STATE_UPDATE_INFOS = 2;
	public static int WORK_STATE_ANALYSIS= 3;
	public static int WORK_STATE_END=4;
	//
	private Work currentWork;
	// 
	public WorkService(){
	}
	
	public int checkWork(){
		currentWork = WorkDao.getInstance().getTodayWork();
		System.out.println("" + currentWork.toString());
		int currentState = currentWork.getWstate();
		int realCount =  0;
		if(currentState == WORK_STATE_CREATE){
			// 改变状态为更新topic
			System.out.println("今日任务开始啦 --- " + DateTimeUtils.getYYYYMMDD());
			WorkDao.getInstance().setState(WORK_STATE_UPDATE_TOPICS, currentWork.getWid());
			WorkDao.getInstance().setTemp(GenreDao.getInstance().getAllGid(), currentWork.getWid());
			
			TopicTagsDao.getInstance().clear();//清楚标签数据
			// 调用获取获取topic任务
			System.out.println("调用获取获取topic任务");
			realCount = GetTopicWorker.getInstance().getTopics(currentWork);
			System.out.println("realCount => " + realCount);
		}else if(currentState == WORK_STATE_UPDATE_TOPICS){
			// 调用获取获取topic任务
			System.out.println("调用获取获取topic任务");
			realCount = GetTopicWorker.getInstance().getTopics(currentWork);
			System.out.println("realCount => " + realCount);
		}else if(currentState == WORK_STATE_UPDATE_INFOS){
			System.out.println("获取详细信息任务");
			realCount = GetInfoWorker.getInstance().getInfo(currentWork);
			System.out.println("realCount => " + realCount);
		}else if(currentState == WORK_STATE_ANALYSIS){
			System.out.println("统计今日数据");
			realCount = AnalysisWoker.getInstance().dojob(currentWork);
			System.out.println("realCount => " + realCount);
		}else if(currentState == WORK_STATE_END){
			System.out.println("今日任务结束啦 --- " + DateTimeUtils.getYYYYMMDD());
		}
		return currentState;
	}
}
