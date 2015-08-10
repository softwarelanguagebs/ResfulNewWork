package com.example.net;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;










import com.example.common.L;

import android.util.Log;
import android.webkit.CookieManager;

/*
 * ������������HTTP����
 * */
public class HttpRequestUtil
{
    /**
     * ����GET����
     * 
     * @param url
     * @param params
     * @param headers
     * @return
     * @throws Exception
     */
    
    private static final int TIMEOUT_IN_MILLIONS = 10*1000;
    
    private static String TAG = "HttpRequestUtil";
    
    public static URLConnection sendGetRequest(String url,
            Map<String, String> params, Map<String, String> headers)
            throws Exception
    {
        StringBuilder buf = new StringBuilder(url);
        Set<Entry<String, String>> entrys = null;
        // �����GET���������������URL��
        if (params != null && !params.isEmpty())
        {
            buf.append("?");
            entrys = params.entrySet();
            for (Map.Entry<String, String> entry : entrys)
            {
                buf.append(entry.getKey())
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue(), "UTF-8"))
                        .append("&");
            }
            buf.deleteCharAt(buf.length() - 1);
        }
        URL url1 = new URL(buf.toString());
        
        L.i(TAG,url1+"");
        HttpURLConnection conn = (HttpURLConnection)url1.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(TIMEOUT_IN_MILLIONS);
        // ��������ͷ
        if (headers != null && !headers.isEmpty())
        {
            entrys = headers.entrySet();
            for (Map.Entry<String, String> entry : entrys)
            {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        
        if (conn.getResponseCode() == 200)
        {
            return conn;
        }
        else
        {
            
            return null;
        }
    }
    
    /**
     * ����POST����
     * 
     * @param url
     * @param params
     * @param headers
     * @return
     * @throws Exception
     */
    public static URLConnection sendPostRequest(String url,
            Map<String, String> params, Map<String, String> headers)
            throws Exception
    {
        StringBuilder buf = new StringBuilder();
        Set<Entry<String, String>> entrys = null;
        // ������ڲ����������HTTP�����壬����name=aaa&age=10
        if (params != null && !params.isEmpty())
        {
            entrys = params.entrySet();
            for (Map.Entry<String, String> entry : entrys)
            {
                buf.append(entry.getKey())
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue(), "UTF-8"))
                        .append("&");
            }
            buf.deleteCharAt(buf.length() - 1);
        }
        URL url1 = new URL(url);
        
        L.i(TAG, url1+"");
        
       byte[] entitydata =  buf.toString().getBytes();//�õ�ʵ��Ķ���������  
        
        HttpURLConnection conn = (HttpURLConnection)url1.openConnection();
        conn.setRequestMethod("POST");
        conn.setConnectTimeout(TIMEOUT_IN_MILLIONS);
        conn.setDoOutput(true);
     
      //   conn.setDoInput(true);
        
   conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");  
   L.i(TAG," String.valueOf(entitydata.length)==="+String.valueOf(buf.toString().getBytes("UTF-8").length));
       
        
    //    conn.setRequestProperty("Content-Length", String.valueOf(buf.toString().getBytes("UTF-8").length));
//        
//        OutputStream out = conn.getOutputStream();
//        out.write(buf.toString().getBytes("UTF-8"));
      
        if (headers != null && !headers.isEmpty())
        {
            entrys = headers.entrySet();
            for (Map.Entry<String, String> entry : entrys)
            {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        
        
        OutputStream out = conn.getOutputStream();
        out.write(buf.toString().getBytes("UTF-8"));
        
        //add
        out.flush();  
        out.close(); 
        //
        if (conn.getResponseCode() == 200)
        {
            return conn;
        }
        else
        {
            
            return null;
        }
    }
    
    
    

    
    


/**
 * ����һЩ�����Ĳ�������ȡ�̰߳�ȫ��HttpClient����
 * 
 * @return �����̰߳�ȫ��HttpClient����
 */
private static HttpClient getHttpClient() {
    /* 1. ����һЩ������������Http�汾�������ʽ�Ͳ������� */
    HttpParams httpParams = new BasicHttpParams();
    HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset(httpParams, "UTF-8");
    HttpProtocolParams.setUseExpectContinue(httpParams, true);

    /* 2. ��ʱ���� */
    /* �����ӳ���ȡ���ӵĳ�ʱʱ�� */
    ConnManagerParams.setTimeout(httpParams, 20000);
    /* ���ӳ�ʱ */
    HttpConnectionParams.setConnectionTimeout(httpParams, 20000);
    /* ����ʱ */
    HttpConnectionParams.setSoTimeout(httpParams, 20000);

    /* 3. �������ǵ�HttpClient֧��HTTP��HTTPS����ģʽ */
    SchemeRegistry registry = new SchemeRegistry();
    registry.register(new Scheme("http", PlainSocketFactory
            .getSocketFactory(), 80));
    registry.register(new Scheme("https", SSLSocketFactory
            .getSocketFactory(), 443));

    /* 4. ʹ���̰߳�ȫ�����ӹ���������HttpClient */
    ClientConnectionManager manager = new ThreadSafeClientConnManager(
            httpParams, registry);
    return new DefaultHttpClient(manager, httpParams);
}








    
    /**
     * ����POST����,������һ���߳�
     * 
     * @param url
     * @param params
     * @param headers
     * @return
     * @throws Exception
     */
    public static URLConnection sendPostRequestForUpLocates(String url,
            Map<String, String> params, Map<String, String> headers)
            throws Exception
    {
        StringBuilder buf = new StringBuilder();
        Set<Entry<String, String>> entrys = null;
        // ������ڲ����������HTTP�����壬����name=aaa&age=10
        if (params != null && !params.isEmpty())
        {
            entrys = params.entrySet();
            for (Map.Entry<String, String> entry : entrys)
            {
                buf.append(entry.getKey())
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue(), "UTF-8"))
                        .append("&");
            }
            buf.deleteCharAt(buf.length() - 1);
        }
        URL url1 = new URL(url);
        HttpURLConnection conn = (HttpURLConnection)url1.openConnection();
        conn.setRequestMethod("POST");
        conn.setConnectTimeout(TIMEOUT_IN_MILLIONS);
        conn.setDoOutput(true);
        OutputStream out = conn.getOutputStream();
        out.write(buf.toString().getBytes("UTF-8"));
        if (headers != null && !headers.isEmpty())
        {
            entrys = headers.entrySet();
            for (Map.Entry<String, String> entry : entrys)
            {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        if (conn.getResponseCode() == 200)
        {
            return conn;
        }
        else
        {
            
            return null;
        }
    }
    
    
    
    
    
    
    
    
    
    

    
  /*  public static String doPut(String urlStr,Map<String,Object> paramMap,String token) throws Exception{
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("PUT");
     //   String paramStr = prepareParam(paramMap);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("token",token);
        OutputStream os = conn.getOutputStream();     
    //    os.write(paramStr.toString().getBytes("utf-8"));     
        os.close();         
        
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        
      //  InputStream inStream =conn.getInputStream();
        String line ;
        String result ="";
        while( (line =br.readLine()) != null ){
          //  result += "/n"+line;
            result += line;
        }
        System.out.println(result);
        L.i(result);
        br.close();
        
        return result;
                
    }
    
    */
    public static InputStream doPut(String urlStr,Map<String,Object> paramMap,String token) throws Exception{
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("PUT");
     //   String paramStr = prepareParam(paramMap);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("token",token);
        OutputStream os = conn.getOutputStream();     
    //    os.write(paramStr.toString().getBytes("utf-8"));     
        os.close();         
        
     //   BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        
      InputStream inStream =conn.getInputStream();
//        String line ;
//        String result ="";
//        while( (line =br.readLine()) != null ){
//          //  result += "/n"+line;
//            result += line;
//        }
//        System.out.println(result);
//        L.i(result);
//        br.close();
        
        return inStream;
                
    }
    
    
    
    private static String prepareParam(Map<String,Object> paramMap){
        StringBuffer sb = new StringBuffer();
        if(paramMap.isEmpty()){
            return "" ;
        }else{
            for(String key: paramMap.keySet()){
                String value = (String)paramMap.get(key);
                if(sb.length()<1){
                    sb.append(key).append("=").append(value);
                }else{
                    sb.append("&").append(key).append("=").append(value);
                }
            }
            return sb.toString();
        }
    }
    
    
    
    
    
    
    
    
    
    /**
     * ֱ��ͨ��HTTPЭ���ύ���ݵ�������,ʵ����������ύ����: <FORM METHOD=POST
     * ACTION="http://192.168.0.200:8080/ssi/fileload/test.do"
     * enctype="multipart/form-data"> <INPUT TYPE="text" NAME="name"> <INPUT
     * TYPE="text" NAME="id"> <input type="file" name="imagefile"/> <input
     * type="file" name="zip"/> </FORM>
     * 
     * @param path
     *            �ϴ�·��(ע������ʹ��localhost��127.0.0.1������·�����ԣ���Ϊ����ָ���ֻ�ģ�����������ʹ��http://
     *            www.itcast.cn��http://192.168.1.10:8080������·������)
     * @param params
     *            ������� keyΪ������,valueΪ����ֵ
     * @param file
     *            �ϴ��ļ�
     */
    public static boolean uploadFiles(String path, Map<String, String> params,
            FormFile[] files) throws Exception
    {
        final String BOUNDARY = "---------------------------7da2137580612"; // ���ݷָ���
        final String endline = "--" + BOUNDARY + "--\r\n";// ���ݽ�����־
        
        int fileDataLength = 0;
        if (files != null && files.length != 0)
        {
            for (FormFile uploadFile : files)
            {// �õ��ļ��������ݵ��ܳ���
                StringBuilder fileExplain = new StringBuilder();
                fileExplain.append("--");
                fileExplain.append(BOUNDARY);
                fileExplain.append("\r\n");
                fileExplain.append("Content-Disposition: form-data;name=\""
                        + uploadFile.getParameterName() + "\";filename=\""
                        + uploadFile.getFilname() + "\"\r\n");
                fileExplain.append("Content-Type: "
                        + uploadFile.getContentType() + "\r\n\r\n");
                fileExplain.append("\r\n");
                fileDataLength += fileExplain.length();
                if (uploadFile.getInStream() != null)
                {
                    fileDataLength += uploadFile.getFile().length();
                }
                else
                {
                    fileDataLength += uploadFile.getData().length;
                }
            }
        }
        StringBuilder textEntity = new StringBuilder();
        if (params != null && !params.isEmpty())
        {
            for (Map.Entry<String, String> entry : params.entrySet())
            {// �����ı����Ͳ�����ʵ������
                textEntity.append("--");
                textEntity.append(BOUNDARY);
                textEntity.append("\r\n");
                textEntity.append("Content-Disposition: form-data; name=\""
                        + entry.getKey() + "\"\r\n\r\n");
                textEntity.append(entry.getValue());
                textEntity.append("\r\n");
            }
        }
        // ���㴫�����������ʵ�������ܳ���
        int dataLength = textEntity.toString().getBytes().length
                + fileDataLength + endline.getBytes().length;
        
        URL url = new URL(path);
        int port = url.getPort() == -1 ? 80 : url.getPort();
        Socket socket = new Socket(InetAddress.getByName(url.getHost()), port);
        OutputStream outStream = socket.getOutputStream();
        // �������HTTP����ͷ�ķ���
        String requestmethod = "POST " + url.getPath() + " HTTP/1.1\r\n";
        outStream.write(requestmethod.getBytes());
        String accept = "Accept: image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*\r\n";
        outStream.write(accept.getBytes());
        String language = "Accept-Language: zh-CN\r\n";
        outStream.write(language.getBytes());
        String contenttype = "Content-Type: multipart/form-data; boundary="
                + BOUNDARY + "\r\n";
        outStream.write(contenttype.getBytes());
        String contentlength = "Content-Length: " + dataLength + "\r\n";
        outStream.write(contentlength.getBytes());
        String alive = "Connection: Keep-Alive\r\n";
        outStream.write(alive.getBytes());
        String host = "Host: " + url.getHost() + ":" + port + "\r\n";
        outStream.write(host.getBytes());
        // д��HTTP����ͷ�����HTTPЭ����дһ���س�����
        outStream.write("\r\n".getBytes());
        // �������ı����͵�ʵ�����ݷ��ͳ���
        outStream.write(textEntity.toString().getBytes());
        // �������ļ����͵�ʵ�����ݷ��ͳ���
        if (files != null && files.length != 0)
        {
            for (FormFile uploadFile : files)
            {
                StringBuilder fileEntity = new StringBuilder();
                fileEntity.append("--");
                fileEntity.append(BOUNDARY);
                fileEntity.append("\r\n");
                fileEntity.append("Content-Disposition: form-data;name=\""
                        + uploadFile.getParameterName() + "\";filename=\""
                        + uploadFile.getFilname() + "\"\r\n");
                fileEntity.append("Content-Type: "
                        + uploadFile.getContentType() + "\r\n\r\n");
                outStream.write(fileEntity.toString().getBytes());
                if (uploadFile.getInStream() != null)
                {
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while ((len = uploadFile.getInStream()
                            .read(buffer, 0, 1024)) != -1)
                    {
                        outStream.write(buffer, 0, len);
                    }
                    uploadFile.getInStream().close();
                }
                else
                {
                    outStream.write(uploadFile.getData(),
                            0,
                            uploadFile.getData().length);
                }
                outStream.write("\r\n".getBytes());
            }
        }
        // ���淢�����ݽ�����־����ʾ�����Ѿ�����
        outStream.write(endline.getBytes());
      
        
      
        
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        if (reader.readLine().indexOf("200") == -1)
        {// ��ȡweb���������ص����ݣ��ж��������Ƿ�Ϊ200���������200����������ʧ��
            return false;
        }
        
        String temp = "";
        String s = "";
        while((temp = reader.readLine()) != null)
        {
          s = s + temp;
        }
        outStream.flush();
        outStream.close();
        reader.close();
        socket.close();
        
     //   return JsonParse.parseJSONUpPic(s);
        L.i(TAG, s);
        //�Ժ�Ľ�
        return s.contains("true");
       // return true;
    }
    
    /**
     * �ύ���ݵ�������
     * 
     * @param path
     *            �ϴ�·��(ע������ʹ��localhost��127.0.0.1������·�����ԣ���Ϊ����ָ���ֻ�ģ�����������ʹ��http://
     *            www.itcast.cn��http://192.168.1.10:8080������·������)
     * @param params
     *            ������� keyΪ������,valueΪ����ֵ
     * @param file
     *            �ϴ��ļ�
     */
    public static boolean uploadFile(String path, Map<String, String> params,
            FormFile file) throws Exception
    {
        return uploadFiles(path, params, new FormFile[] {file});
    }
    
    /**
     * ��������תΪ�ֽ�����
     * 
     * @param inStream
     * @return
     * @throws Exception
     */
    public static byte[] read2Byte(InputStream inStream) throws Exception
    {
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1)
        {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inStream.close();
        return outSteam.toByteArray();
    }
    
    /**
     * ��������תΪ�ַ���
     * 
     * @param inStream
     * @return
     * @throws Exception
     */
    public static String read2String(InputStream inStream) throws Exception
    {
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1)
        {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inStream.close();
        return new String(outSteam.toByteArray(), "UTF-8");
    }
    
    /**
     * ����xml����
     * 
     * @param path
     *            �����ַ
     * @param xml
     *            xml����
     * @param encoding
     *            ����
     * @return
     * @throws Exception
     */
    public static byte[] postXml(String path, String xml, String encoding)
            throws Exception
    {
        byte[] data = xml.getBytes(encoding);
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "text/xml; charset=" + encoding);
        conn.setRequestProperty("Content-Length", String.valueOf(data.length));
        conn.setConnectTimeout(5 * 1000);
        OutputStream outStream = conn.getOutputStream();
        outStream.write(data);
        outStream.flush();
        outStream.close();
        if (conn.getResponseCode() == 200)
        {
            return read2Byte(conn.getInputStream());
        }
        return null;
    }
    
    // ���Ժ���
    public static void main(String args[]) throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", "xiazdong");
        params.put("age", "10");
        HttpURLConnection conn = (HttpURLConnection)HttpRequestUtil.sendGetRequest("http://192.168.0.103:8080/Server/PrintServlet",
                params,
                null);
        int code = conn.getResponseCode();
        InputStream in = conn.getInputStream();
        byte[] data = read2Byte(in);
    }
    
    
    /**
     * �Լ���ӵ��ļ��ϴ�����
     */
    
    
    
    
    /**
     * ͨ��ƴ�ӵķ�ʽ�����������ݣ�ʵ�ֲ��������Լ��ļ�����
     * 
     * @param url Service net address
     * @param params text content
     * @param files pictures
     * @return String result of Service response
     * @throws IOException
     */
    public static String upPicture(String url, Map<String, String> params, Map<String, File> files)
            throws IOException {
        String BOUNDARY = java.util.UUID.randomUUID().toString();
        String PREFIX = "--", LINEND = "\r\n";
        String MULTIPART_FROM_DATA = "multipart/form-data";
        String CHARSET = "UTF-8";


        URL uri = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
        conn.setReadTimeout(10 * 1000); // ������ʱ��
        conn.setDoInput(true);// ��������
        conn.setDoOutput(true);// �������
        conn.setUseCaches(false); // ������ʹ�û���
        conn.setRequestMethod("POST");
        conn.setRequestProperty("connection", "keep-alive");
        conn.setRequestProperty("Charsert", "UTF-8");
        conn.setRequestProperty("Content-Type", MULTIPART_FROM_DATA + ";boundary=" + BOUNDARY);


     
        
        
        // ������ƴ�ı����͵Ĳ���
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(PREFIX);
            sb.append(BOUNDARY);
            sb.append(LINEND);
            sb.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"" + LINEND);
            sb.append("Content-Type: text/plain; charset=" + CHARSET + LINEND);
            sb.append("Content-Transfer-Encoding: 8bit" + LINEND);
            sb.append(LINEND);
            sb.append(entry.getValue());
            sb.append(LINEND);
        }


        DataOutputStream outStream = new DataOutputStream(conn.getOutputStream());
        outStream.write(sb.toString().getBytes());
        // �����ļ�����
        if (files != null)
            for (Map.Entry<String, File> file : files.entrySet()) {
                StringBuilder sb1 = new StringBuilder();
                sb1.append(PREFIX);
                sb1.append(BOUNDARY);
                sb1.append(LINEND);
                sb1.append("Content-Disposition: form-data; name=\""
                        + "file" + "\"; filename=\""
                        + file.getValue().getName() + "\"" + LINEND);
                sb1.append("Content-Type: application/octet-stream; charset=" + CHARSET + LINEND);
                sb1.append(LINEND);
                outStream.write(sb1.toString().getBytes());


                InputStream is = new FileInputStream(file.getValue());
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = is.read(buffer)) != -1) {
                    outStream.write(buffer, 0, len);
                }


                is.close();
                outStream.write(LINEND.getBytes());
            }


        // ���������־
        byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINEND).getBytes();
        outStream.write(end_data);
        outStream.flush();
        // �õ���Ӧ��
        int res = conn.getResponseCode();
        InputStream in = conn.getInputStream();
        
        /*    StringBuilder sb2 = new StringBuilder();
        
       
        if (res == 200) {
        	
        	
            int ch;
            while ((ch = in.read()) != -1) {
                sb2.append((char) ch);
            }
        }
        
        */
        String s = null;
        if (res == 200) {
        	try {
				s =read2String(in);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
        }
        
        outStream.close();
        conn.disconnect();
      //  return sb2.toString();
        return s;
    }



    
    
}
