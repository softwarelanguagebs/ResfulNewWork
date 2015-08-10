package com.example.activity.manager2;

public interface ITTBActivity {
	
	void init();//初始化数据
	
	//这个是  服务 任务，执行 返回结果 : 刷新  UI
	void refresh(Object ...param);//刷新 内容 不知道 可变参数  的可以再去学习下coreJva

}
