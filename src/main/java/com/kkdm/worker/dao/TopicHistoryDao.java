package com.kkdm.worker.dao;

import java.util.Map;

import com.quya.core.utils.MysqlUtils;

public class TopicHistoryDao {
	private static TopicHistoryDao instance;
	private String tableName = "tbtopichistory";
	
	public static TopicHistoryDao getInstance(){
		if(instance == null){
			instance = new TopicHistoryDao();
		}
		return instance;
	}

	public Map<String,Object> getOldData(String hisid){
		Map<String, Object> data = MysqlUtils.someFieldsValues(this.tableName, new String[]{"likesCount","hotCount","commentCount"}, "hisid='"+hisid+"'");
		return data;
	}

}
