package com.wb.wbs.utils;

import sun.net.www.protocol.http.HttpURLConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class HttpUtil {

    //访问网络获取数据
    public static void HttpPost(final String con_url, final Map<String, String> params, final String encode
//                                ,final HttpCallBackListener httpCallBackListener
    ) {
        //con_url是拼接好的访问地址,params里面存放发送的数据信息
        //encode是数据的编码格式,listener是返回连接完成，线程中可以这样返回
        new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuilder result = new StringBuilder();
                String line;
                //getRequestData是解析数据的一个 函数,用来拼接发送的数据
                byte[] data = getRequestData(params, encode).toString().getBytes();
                HttpURLConnection connection = null;
                InputStreamReader in = null;
                try {
                    URL url = new URL(con_url);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(3000);//设置连接超时时间
                    connection.setDoInput(true);//设置开启输入
                    connection.setDoOutput(true);//设置开启输出
                    connection.setRequestMethod("POST");
                    connection.setUseCaches(false); //使用post不能使用缓存
                    connection.setRequestProperty("Content-Type", "application/json");//api要求
                    //数据长度
                    connection.setRequestProperty("Content-Length", String.valueOf(data.length));
                    OutputStream outputStream = connection.getOutputStream();
                    outputStream.write(data);//输出流发送到服务器

                    InputStreamReader inputStream = new InputStreamReader(connection.getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(inputStream);
                    while ((line = bufferedReader.readLine()) != null) {
                        result.append(line);//返回数据拼接
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    //关闭链接
                    if (connection != null)
                        connection.disconnect();
                }
            }
        }).start();
    }


    private static StringBuffer getRequestData(Map<String, String> params, String encode)//数据解析
    {
        //按照格式要求进行分解
        StringBuffer stringBuffer = new StringBuffer("{");
        try {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                stringBuffer.append("\"")
                        .append(entry.getKey())
                        .append("\"")
                        .append(" : ")
                        .append("\"")
                        .append(URLEncoder.encode(entry.getValue(), encode))
                        .append("\"");
            }
            stringBuffer.append("}");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer;
    }
//
//    //实际编写中需要先获取access_token，这个是有有效期的。本地保存一下
////    public static String getAccess_Token(final Handler handler) {
////        if (access_token == null) {
////            HttpGetAccessToken(new HttpCallBackListener() {//如果没有就网络获取
////                @Override
////                public void onFinish(String result) {
////                    access_token = result;
////                    Message message = new Message();
////                    message.what = 999;
////                    message.obj = access_token;
////                    handler.sendMessage(message);//handler发送信息处理返回数据
////                }
////                @Override
////                public void onError(Exception e) {
////                }
////            });
////        }
////        return access_token;
////    }
//    //网络获取
//    private static final String clientId = "你的id",
//            clientSecert = "你的secert",
//            grant_type = "client_credentials";
//    private static void HttpGetAccessToken(final HttpCallBackListener httpCallBackListener) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                if (access_token != null) {
//                    httpCallBackListener.onFinish(access_token);
//                    return;
//                }
//
//                StringBuilder builder = new StringBuilder();
//                String line;
//                String con_url = "https://aip.baidubce.com/oauth/2.0/token?" +
//                        "grant_type=" + grant_type + "&" +
//                        "client_id=" + clientId + "&" +
//                        "client_secret=" + clientSecert;//拼接地址
//                HttpURLConnection connection = null;
//                InputStreamReader inputStreamReader = null;
//                try {
//                    URL url = new URL(con_url);
//                    connection = (HttpURLConnection) url.openConnection();
//                    connection.setRequestMethod("POST");
//                    connection.setConnectTimeout(3000);//设置连接超时时间
//                    connection.setDoInput(true);//设置开启输入
//                    connection.setDoOutput(true);//设置开启输出
//                    inputStreamReader = new InputStreamReader(connection.getInputStream());
//                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//                    while ((line = bufferedReader.readLine()) != null) {
//                        builder.append(line);
//                    }
//                    JSONObject jsonObject = new JSONObject(builder.toString());
//                    access_token = jsonObject.getString("access_token");
//                    httpCallBackListener.onFinish(jsonObject.getString("access_token"));
//                } catch (Exception e) {
//                    httpCallBackListener.onError(e);
//                    e.printStackTrace();
//                } finally {
//                    try {
//                        if (connection != null)
//                            connection.disconnect();
//                        if (inputStreamReader != null)
//                            inputStreamReader.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//    }
//
///*
//服务器返回的信息可以创建一个实体类，返回的是一个大的json,
//里面有jsonarry,arry里面是一个json这里需要的最里面的json
//例如
//{
//    "text":"苹果是一家伟大的公司",
//    "items":[
//        {//需要的是这个json
//            "sentiment":2,    //表示情感极性分类结果
//            "confidence":0.40, //表示分类的置信度
//            "positive_prob":0.73, //表示属于积极类别的概率
//            "negative_prob":0.27  //表示属于消极类别的概率
//        }
//    ]
//}*/
//
//    //json解析也有很多三方开源，可以尝试着调用
//    public Bean(JSONObject jsonObject) throws JSONException {
//        //数据解析，抛出异常
//        pos = jsonObject.getDouble("positive_prob");
//        neg = jsonObject.getDouble("negative_prob");
//        con = jsonObject.getDouble("confidence");
//    }
//坚持看到这里，去实现调用api就没多大问题
}
