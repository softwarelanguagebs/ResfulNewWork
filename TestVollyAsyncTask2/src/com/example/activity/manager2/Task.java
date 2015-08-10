package com.example.activity.manager2;

import java.util.HashMap;
import java.util.Map;

public class Task {

	private int taskID;// 任务ID
	@SuppressWarnings("rawtypes")
	private Map<String, String> taskParam;// 内容参数
	public static final int TASK_LOGIN = 0;//保存用户信息
	public static final int TASK_GETCARGOS = 1;// 用户登录任务
	public static final int TASK_GET_CAR_STATUS = 2;// 获取用户首页信息
	public static final int TASK_SET_CAR_STATUS = 3;// 收索微博

	

	@SuppressWarnings("rawtypes")
	public Task(int id, Map<String, String> param) {
		this.taskID = id;
		this.taskParam = param;
	}

	public int getTaskID() {
		return taskID;
	}

	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}

	@SuppressWarnings("rawtypes")
	public Map<String, String> getTaskParam() {
		return taskParam;
	}

	@SuppressWarnings("rawtypes")
	public void setTaskParam(Map<String, String> taskParam) {
		this.taskParam = taskParam;
	}
}
