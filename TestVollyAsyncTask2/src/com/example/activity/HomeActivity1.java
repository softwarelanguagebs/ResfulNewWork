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

	public static final int REFRESH_LOGIN = 0;// ��½��ʶ

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

		// ��ʼ�����������
		init();

		// ����ǰ��activity��ӵ�Servicre��activity������
		MainService.allActivity.add(this);
	}

	private void setupView() {
		// imv_back = (ImageView) this.findViewById(R.id.imv_back);
		// tv_title =(TextView) this.findViewById(R.id.tv_title);

	}

	private void initValue() throws Exception {
		// /**
		// * ��¼����
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

	// ҳ���ʼ��
	@Override
	public void init() {

		// ��map�ŵ�Task������ ���ݵ�Service��
		// ///////////////////////////////����////////////////////////////
		Task loginTask = new Task(Task.TASK_LOGIN, RequeParam.setLoginParam(
				"13967178385", "654321", "car"));

		MainService.newTask(loginTask, HomeActivity1.this);// ����ǰ�����͵�Service�����������

	}

	// ���ܷ������ݣ�Ȼ��ˢ�½��� UI
	@Override
	public void refresh(Object... param) {
		int flag = ((Integer) param[0]).intValue();// ��ȡ��һ������
		switch (flag) {
		case REFRESH_LOGIN:
			// Toast.makeText(LoginActivity.this, "��¼�ɹ�", 3000).show();

			// Log.i("yanzheng", ((Integer)param[0]).intValue()+"loginrafush");
			if (param[1] != null) {

				// ��½�ɹ� �����û���Ϣ����ѡ�� ͬʱ�������ݿ� ������ҳ���ȡ ��
				// ��ȡ�첽�������� �����صĽ�� �� 0,1,2
				UserBean nowusers = (UserBean) param[1];

				System.out.println(nowusers);
				//Log.e("test1234", String.valueOf(nowusers.getUser_id()));

				// /��ʹ��֤ʧ�ܣ�Ҳ�����Ƴ����򣬻��ظ�ִ�У����ԣ���÷ŵ������档 �� ����oncreate�м��� //////
				// ������ �Ƴ� �����ظ�ִ������
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
