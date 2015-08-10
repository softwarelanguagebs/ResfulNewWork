package com.example.activity.manager2;

import java.util.HashMap;
import java.util.Map;

public class Task {

	private int taskID;// ����ID
	@SuppressWarnings("rawtypes")
	private Map<String, String> taskParam;// ���ݲ���
	public static final int TASK_LOGIN = 0;//�����û���Ϣ
	public static final int TASK_GETCARGOS = 1;// �û���¼����
	public static final int TASK_GET_CAR_STATUS = 2;// ��ȡ�û���ҳ��Ϣ
	public static final int TASK_SET_CAR_STATUS = 3;// ����΢��

	

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
