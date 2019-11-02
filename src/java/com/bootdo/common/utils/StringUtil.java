package com.bootdo.common.utils;

import org.apache.commons.lang3.time.FastDateFormat;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.time.Instant;
import java.util.UUID;


public class StringUtil {









//
//    @SuppressWarnings("unchecked")
//    public static void main(String[] args) {
//
//          System.out.println(makeOrderCode(UUID.randomUUID().toString()));
//
//    }







    /**
     * 订单号生成计数器
     */
    private static long numberCount = 1000L;
    /**
     * 每毫秒生成订单号数量最大峰值
     */
    private static final int maxPerMSECSize = 1000;

    private static final FastDateFormat pattern = FastDateFormat.getInstance("yyyyMMdd");

    /**
     * 并发下面容易产生重复的订单号,给传入的PKID枷锁,保证资源安全的同时,性能也有所下降 订单生成策略为: 时间20180511
     * +机器编码(我这里临时填写的是00100),在本台机器上生成订单编号的标识,如果分开部署,则此处的机器码需要变更,防止出现意外重复 +二位随机数
     * +lock的hash-code编码,这里有个并发下的性能问题 +时间时分秒 +递增参数值
     *
     * @param lock 生成的UUID32位参数
     * @return
     */
    public static String makeOrderCode(String lock) {
        ReferenceQueue<StringBuilder> queue = new ReferenceQueue<>();
        WeakReference<StringBuilder> weakRef = new WeakReference<>(new StringBuilder(25), queue);
        synchronized (lock) {// 锁住传入的lock
            if (null == weakRef.get()) {
                weakRef = new WeakReference<>(new StringBuilder(25), queue);
            }
            if (numberCount >= maxPerMSECSize) { // 计数器到最大值归零,目前1毫秒处理峰值1个
                numberCount = 1L;
            }
            weakRef.get().append(pattern.format(Instant.now().toEpochMilli()));// 取系统当前时间作为订单号变量前半部分
//            weakRef.get().append(Math.abs(lock.hashCode()));// HASH-CODE
//            String strNum = String.valueOf(numberCount++);
            weakRef.get().append(String.format("%02d", numberCount++));// 计数器的值
            return weakRef.get().toString();
        }
    }








}
