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

	public boolean isrun = true;// 线程开关

	// 将当前的activity加到Service中方便管理和调用
	public static ArrayList<Activity> allActivity = new ArrayList<Activity>();
	// 将所有任务放到任务集合中
	public static ArrayList<Task> allTask = new ArrayList<Task>();

	// 遍历所有activity 根据名称在 allActivity 中找到需要的activity
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

	// 将当前的任务加到任务集合中
	public static void newTask(Task task, Context xt) {

		allTask.add(task);

		cxt = xt;
	}

	// 异步 加载 数据……
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case Task.TASK_LOGIN:// 通知Login页面 登陆成功
				ITTBActivity login = (ITTBActivity) MainService// 获得请求任务的Activity
						.getActivityByName("HomeActivity1");// 调用Login//
															// Activity刷新页面的方法
				// 返回 处理结果给 调用的activity
				login.refresh(HomeActivity1.REFRESH_LOGIN, msg.obj);

				break;

			case Task.TASK_GETCARGOS:// 通知注册页面成功

				break;

			case Task.TASK_GET_CAR_STATUS:// 通知添加商品成功

				break;

			case Task.TASK_SET_CAR_STATUS:// 编辑商品

				break;

			}

		}
	};

	private void doTask(Task task) {
		Message mess = handler.obtainMessage();

		mess.what = task.getTaskID();// 将当前任务的ID 放到Message中
		switch (task.getTaskID()) {

		case Task.TASK_LOGIN:// 得到登陆任务
			// 接到登录任务 执行登录
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

			// 返回 登陆成功的用户 实体 资料, 具体的activity是如何 获取 u 的？？？？？？
			mess.obj = user;

			break;

		case Task.TASK_GETCARGOS:// 得到注册任务
			/*
			 * // 接到登录任务 执行登录 UserInfo r = DoRegister(task);// 返回注册成功返回的id //
			 * MainService.nowuser = r; mess.obj = r;
			 */

			break;

		case Task.TASK_GET_CAR_STATUS:// 添加商品
			/*
			 * // 接到登录任务 执行登录 String prod = AddProduct(task);// 返回注册成功返回的id
			 * 
			 * mess.obj = prod;
			 */

			break;

		case Task.TASK_SET_CAR_STATUS:// 编辑商品
			/*
			 * // 接到登录任务 执行登录 String editprod = EditProduct(task);// 返回注册成功返回的id
			 * 
			 * mess.obj = editprod;
			 */

			break;

		}

		// 发送当前消息//////////////
		handler.sendMessage(mess);

		// 当前任务执行完毕 把任务从任务集合中remove 不然会重复执行 /////////////////
		allTask.remove(task);
	}/*
	 * 
	 * // 发私信 private SiXin DoMessage(Task task) {
	 * 
	 * // 任务传递过来的参数 //////// String senderid = ((String)
	 * task.getTaskParam().get("userid")); String revevierid = ((String)
	 * task.getTaskParam().get("revevier"));// 收件人id String content = ((String)
	 * task.getTaskParam().get("content"));
	 * 
	 * // Log.i("message111111111111",senderid+" "+revevierid+" "+content);
	 * 
	 * // Log.i("yanzheng", toke + "token <----->" + "两个密钥" + secret); //
	 * 单利模式初始化对象////////////// weibo = UserInfo.getInstance().getUserinfo(cxt);
	 * 
	 * SiXin u = null; try { // 验证当前用户身份是否合法 验证成功 返回一个user对象//////// u =
	 * weibo.SendMessage(senderid, revevierid, content);
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace(); } return u; }
	 */

	@Override
	public void onCreate() {

		super.onCreate();

		// 启动服务之前， 清理哈系统内存 ,杀掉某些没用的进程////////////////// 但是释放内存会把static
		// 释放掉，所以登陆页面 就不行了
		// MemoryUtil.KillProcess(MainService.this);

		// /////////////////////////////////////
		isrun = true;// 启动线程

		Thread t = new Thread(this);
		t.start();

	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		this.stopSelf();// 停止服务

		isrun = false;// 关闭线程
	}

	// 服务和 activity 通信 …… ///////////////////////////////////
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void run() {
		while (isrun) {
			Task lastTask = null;

			synchronized (allTask) {

				// 具体的activity中添加任务到 alltask集合 ，比如 login,search等等
				// 这里才去 遍历执行任务
				if (allTask.size() > 0) {

					lastTask = allTask.get(0);

					// Log.i("yanzheng", "任务ID" + lastTask.getTaskID());

					// /// 做任务 //////////////////////////
					doTask(lastTask);
				}
			}
			// 每隔一秒钟检查是否有任务 /////////////////////
			try {
				Thread.sleep(1000);

			} catch (Exception e) {
			}
		}
	}

	// 自己添加 ，启动服务
	// ///////////////////service和activity一样 都是 通过intent传递 ……
	public static void StartAPPServices(Context context) {
		Intent it = new Intent("com.example.activity.manager2.MainService");
		context.startService(it);// 启动服务 会调用onCreate方法

	}

	public static void StopAPPServices(Context context) {
		Intent it = new Intent("com.example.activity.manager2.MainService");
		context.stopService(it);// 启动服务 会调用onCreate方法

	}

}
