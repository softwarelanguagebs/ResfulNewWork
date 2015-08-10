package com.example.activity;

import java.util.HashMap;
import java.util.Map;

import com.example.activity.manager2.ITTBActivity;
import com.example.activity.manager2.MainService;
import com.example.activity.manager2.Task;
import com.example.common.L;
import com.example.iface.IPostExecuteCallBack;
import com.example.manager.MyAsyncTask1;
import com.example.manager1.CreateHttpURLConnectionBean;
import com.example.manager1.RequeParam;
import com.example.testbase.R;
import com.wlfz.bean.UserBean;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity1 extends Activity implements ITTBActivity,
		OnClickListener {
	private String TAG = "HomeActivity1";
	ImageView imv_back;
	TextView tv_title;

	public static final int REFRESH_LOGIN = 0;// 登陆标识

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		setupView();
		try {
			initValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLinstener();
		fillData();

		// 初始化界面和任务
		init();

		// 将当前的activity添加到Servicre的activity集合中
		MainService.allActivity.add(this);
	}

	private void setupView() {
		// imv_back = (ImageView) this.findViewById(R.id.imv_back);
		// tv_title =(TextView) this.findViewById(R.id.tv_title);

	}

	private void initValue() throws Exception {
		// /**
		// * 登录操作
		// */
		// try {
		// ClientLogic.Login(getApplicationContext(), "13967178385", "654321");
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//

		/*
		 * MyAsyncTask1 myAsyncTask1 = new MyAsyncTask1(); try {
		 * myAsyncTask1.getConnectiontParam
		 * (ClientLogic.LoginConnection(getApplicationContext(), "13967178385",
		 * "654321"),new IPostExecuteCallBack() {
		 * 
		 * @Override public void onPostExecuteReturn(String content) { L.i(TAG,
		 * content);
		 * 
		 * } }); } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * myAsyncTask1.StartTask();
		 */
		MyAsyncTask1 myAsyncTask2 = new MyAsyncTask1();
		Map<String, String> loginParaMap = RequeParam.setLoginParam(
				"13967178385", "654321", "car");
		myAsyncTask2.request(
				CreateHttpURLConnectionBean.getLoginCB(loginParaMap),
				new IPostExecuteCallBack() {

					@Override
					public void onPostExecuteReturn(String content) {
						L.i(TAG, content);

					}

				});
		myAsyncTask2.StartTask();
	}

	private void setLinstener() {

	}

	private void fillData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		// case R.id.imv_back:
		//
		// this.finish();
		// break;

		default:
			break;
		}

	}

	// 页面初始化
	@Override
	public void init() {

		// 将map放到Task参数中 传递到Service中
		// ///////////////////////////////核心////////////////////////////
		Task loginTask = new Task(Task.TASK_LOGIN, RequeParam.setLoginParam(
				"13967178385", "654321", "car"));

		MainService.newTask(loginTask, HomeActivity1.this);// 将当前任务发送到Service的任务队列中

	}

	// 接受返回数据，然后刷新界面 UI
	@Override
	public void refresh(Object... param) {
		int flag = ((Integer) param[0]).intValue();// 获取第一个参数
		switch (flag) {
		case REFRESH_LOGIN:
			// Toast.makeText(LoginActivity.this, "登录成功", 3000).show();

			// Log.i("yanzheng", ((Integer)param[0]).intValue()+"loginrafush");
			if (param[1] != null) {

				// 登陆成功 保存用户信息到首选项 同时插入数据库 供其它页面获取 。
				// 获取异步服务任务 处理返回的结果 ， 0,1,2
				UserBean nowusers = (UserBean) param[1];

				System.out.println(nowusers);
				//Log.e("test1234", String.valueOf(nowusers.getUser_id()));

				// /即使验证失败，也必须移除否则，会重复执行，所以，最好放到最外面。 而 放在oncreate中加入 //////
				// 集合中 移出 避免重复执行任务
				MainService.allActivity.remove(this);

			}

			break;
		}
	}

	@Override
	protected void onDestroy() {

		MainService.allActivity.remove(this);

		super.onDestroy();
	}

}
