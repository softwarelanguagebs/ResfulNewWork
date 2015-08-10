package com.example.activity.manager2;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.example.activity.HomeActivity1;
import com.example.manager1.CreateHttpURLConnectionBean;
import com.example.manager1.RequeParam;
import com.wlfz.bean.UserBean;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

public class MainService extends Service implements Runnable {

	static Context cxt = null;

	public boolean isrun = true;// �߳̿���

	// ����ǰ��activity�ӵ�Service�з������͵���
	public static ArrayList<Activity> allActivity = new ArrayList<Activity>();
	// ����������ŵ����񼯺���
	public static ArrayList<Task> allTask = new ArrayList<Task>();

	// ��������activity ���������� allActivity ���ҵ���Ҫ��activity
	public static Activity getActivityByName(String name) {
		for (Activity ac : allActivity) {
			if (ac.getClass().getName().indexOf(name) >= 0) {
				Log.i("status", ACTIVITY_SERVICE.getClass().getName()
						.toString());
				return ac;
			}
		}
		return null;
	}

	// ����ǰ������ӵ����񼯺���
	public static void newTask(Task task, Context xt) {

		allTask.add(task);

		cxt = xt;
	}

	// �첽 ���� ���ݡ���
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case Task.TASK_LOGIN:// ֪ͨLoginҳ�� ��½�ɹ�
				ITTBActivity login = (ITTBActivity) MainService// ������������Activity
						.getActivityByName("HomeActivity1");// ����Login//
															// Activityˢ��ҳ��ķ���
				// ���� �������� ���õ�activity
				login.refresh(HomeActivity1.REFRESH_LOGIN, msg.obj);

				break;

			case Task.TASK_GETCARGOS:// ֪ͨע��ҳ��ɹ�

				break;

			case Task.TASK_GET_CAR_STATUS:// ֪ͨ�����Ʒ�ɹ�

				break;

			case Task.TASK_SET_CAR_STATUS:// �༭��Ʒ

				break;

			}

		}
	};

	private void doTask(Task task) {
		Message mess = handler.obtainMessage();

		mess.what = task.getTaskID();// ����ǰ�����ID �ŵ�Message��
		switch (task.getTaskID()) {

		case Task.TASK_LOGIN:// �õ���½����
			// �ӵ���¼���� ִ�е�¼
			Map<String, String> loginParaMap = RequeParam.setLoginParam(task
					.getTaskParam().get("login_name"),
					task.getTaskParam().get("password"), task.getTaskParam()
							.get("client"));
			UserBean user = null;
			try {
				user = MainLogic.doInBackground(CreateHttpURLConnectionBean
						.getLoginCB(loginParaMap));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// ���� ��½�ɹ����û� ʵ�� ����, �����activity����� ��ȡ u �ģ�����������
			mess.obj = user;

			break;

		case Task.TASK_GETCARGOS:// �õ�ע������
			/*
			 * // �ӵ���¼���� ִ�е�¼ UserInfo r = DoRegister(task);// ����ע��ɹ����ص�id //
			 * MainService.nowuser = r; mess.obj = r;
			 */

			break;

		case Task.TASK_GET_CAR_STATUS:// �����Ʒ
			/*
			 * // �ӵ���¼���� ִ�е�¼ String prod = AddProduct(task);// ����ע��ɹ����ص�id
			 * 
			 * mess.obj = prod;
			 */

			break;

		case Task.TASK_SET_CAR_STATUS:// �༭��Ʒ
			/*
			 * // �ӵ���¼���� ִ�е�¼ String editprod = EditProduct(task);// ����ע��ɹ����ص�id
			 * 
			 * mess.obj = editprod;
			 */

			break;

		}

		// ���͵�ǰ��Ϣ//////////////
		handler.sendMessage(mess);

		// ��ǰ����ִ����� ����������񼯺���remove ��Ȼ���ظ�ִ�� /////////////////
		allTask.remove(task);
	}/*
	 * 
	 * // ��˽�� private SiXin DoMessage(Task task) {
	 * 
	 * // ���񴫵ݹ����Ĳ��� //////// String senderid = ((String)
	 * task.getTaskParam().get("userid")); String revevierid = ((String)
	 * task.getTaskParam().get("revevier"));// �ռ���id String content = ((String)
	 * task.getTaskParam().get("content"));
	 * 
	 * // Log.i("message111111111111",senderid+" "+revevierid+" "+content);
	 * 
	 * // Log.i("yanzheng", toke + "token <----->" + "������Կ" + secret); //
	 * ����ģʽ��ʼ������////////////// weibo = UserInfo.getInstance().getUserinfo(cxt);
	 * 
	 * SiXin u = null; try { // ��֤��ǰ�û�����Ƿ�Ϸ� ��֤�ɹ� ����һ��user����//////// u =
	 * weibo.SendMessage(senderid, revevierid, content);
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace(); } return u; }
	 */

	@Override
	public void onCreate() {

		super.onCreate();

		// ��������֮ǰ�� �����ϵͳ�ڴ� ,ɱ��ĳЩû�õĽ���////////////////// �����ͷ��ڴ���static
		// �ͷŵ������Ե�½ҳ�� �Ͳ�����
		// MemoryUtil.KillProcess(MainService.this);

		// /////////////////////////////////////
		isrun = true;// �����߳�

		Thread t = new Thread(this);
		t.start();

	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		this.stopSelf();// ֹͣ����

		isrun = false;// �ر��߳�
	}

	// ����� activity ͨ�� ���� ///////////////////////////////////
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void run() {
		while (isrun) {
			Task lastTask = null;

			synchronized (allTask) {

				// �����activity��������� alltask���� ������ login,search�ȵ�
				// �����ȥ ����ִ������
				if (allTask.size() > 0) {

					lastTask = allTask.get(0);

					// Log.i("yanzheng", "����ID" + lastTask.getTaskID());

					// /// ������ //////////////////////////
					doTask(lastTask);
				}
			}
			// ÿ��һ���Ӽ���Ƿ������� /////////////////////
			try {
				Thread.sleep(1000);

			} catch (Exception e) {
			}
		}
	}

	// �Լ���� ����������
	// ///////////////////service��activityһ�� ���� ͨ��intent���� ����
	public static void StartAPPServices(Context context) {
		Intent it = new Intent("com.example.activity.manager2.MainService");
		context.startService(it);// �������� �����onCreate����

	}

	public static void StopAPPServices(Context context) {
		Intent it = new Intent("com.example.activity.manager2.MainService");
		context.stopService(it);// �������� �����onCreate����

	}

}
