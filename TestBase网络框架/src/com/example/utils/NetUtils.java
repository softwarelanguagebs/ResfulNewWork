package com.example.utils;



import com.example.testbase.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.widget.Toast;

public class NetUtils
{
    private NetUtils()
    {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }
    
    /**
     * �ж������Ƿ�����
     * 
     * @param context
     * @return
     */
    public static boolean isConnected(Context context)
    {
        
        ConnectivityManager connectivity = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        
        if (null != connectivity)
        {
            
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (null != info && info.isConnected())
            {
                if (info.getState() == NetworkInfo.State.CONNECTED)
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * �����Ѿ����ӣ�Ȼ��ȥ�ж���wifi���ӻ���GPRS���� ����һЩ�Լ����߼�����
     */
    public static void isNetworkAvailable(Context context)
    {
        ConnectivityManager manager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        
        State gprs = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
                .getState();
        State wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .getState();
        if (gprs == State.CONNECTED || gprs == State.CONNECTING)
        {
            
            Toast.makeText(context, "��ǰΪ 2G/3G/4G���磬��ע��ʹ������", Toast.LENGTH_LONG)
                    .show();
        }
        // �ж�Ϊwifi״̬�²ż��ع�棬�����GPRS�ֻ������򲻼��أ�
        if (wifi == State.CONNECTED || wifi == State.CONNECTING)
        {
            
            Toast.makeText(context, "��ǰΪ WIFI���� ", Toast.LENGTH_LONG).show();
        }
        
    }
    
    /**
     * ����δ����ʱ���������÷���
     */
    public static void setNetwork(final Activity activity)
    {
        Toast.makeText(activity, "��ǰ�����ѹرգ����", Toast.LENGTH_LONG).show();
        
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle("������ʾ��Ϣ");
        builder.setMessage("���粻���ã���������������������磡");
        builder.setPositiveButton("����", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Intent intent = null;
                /**
                 * �ж��ֻ�ϵͳ�İ汾�����API����10 ����3.0+ ��Ϊ3.0���ϵİ汾�����ú�3.0���µ����ò�һ�������õķ�����ͬ
                 */
                if (android.os.Build.VERSION.SDK_INT > 10)
                {
                    intent = new Intent(
                            android.provider.Settings.ACTION_WIFI_SETTINGS);
                }
                else
                {
                    intent = new Intent();
                    ComponentName component = new ComponentName(
                            "com.android.settings",
                            "com.android.settings.WirelessSettings");
                    intent.setComponent(component);
                    intent.setAction("android.intent.action.VIEW");
                }
                activity.startActivity(intent);
            }
        });
        builder.create();
        builder.show();
    }
    
}
