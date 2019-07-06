package com.example.demo.MyUtils;

import com.alibaba.fastjson.JSONObject;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liukangwei
 * @date 2019/5/31   15:28
 */
public class MyUtils {
    //md5加密
    public static String md5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("NoMD5AlgorithmError!");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }
    //获取四位随机数
    public static String getFourRandom() {
        Random random = new Random();
        String four = random.nextInt(10000)+"";
        int randLength = four.length();
        if(randLength < 4){
            for (int i = 0; i < 4-randLength; i++) {
                four = "0"+four;
            }
        }
        return four;
    }

    //获取json串
    public static String getJSONStirng(Map<String,Object> map){
        JSONObject json=new JSONObject();
        json.put("msg",map.get("msg"));
        json.put("code",map.get("code"));
        return json.toString();
    }

    public static void main(String[] args){
        for(int i=0;i<10;i++){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            for (int i = 0; i < 10; i++) {
                                System.out.println(i);
                                Thread.sleep(1000);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "正在执行");
                    }
                }).start();

        }









        /*ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        Runnable task1=new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                System.out.println(Thread.currentThread().getName()+"正在被执行");
            }
        };
        Runnable task2=new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
                System.out.println(Thread.currentThread().getName()+"正在被执行");
            }
        };
        for(int i=0;i<10;i++){
            try {
                cachedThreadPool.execute(task1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }*/
    }

}
