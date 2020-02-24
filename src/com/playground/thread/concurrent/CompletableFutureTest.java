package com.playground.thread.concurrent;


import java.util.concurrent.CompletableFuture;
import com.alibaba.fastjson.JSONObject;
import java.util.concurrent.TimeUnit;

/**
 *  实验CompletableFuture用法
 *
 */

public class CompletableFutureTest {


    public CompletableFuture<String> getOrderCountFuture() {
        return CompletableFuture.supplyAsync(() -> this.getOrderCount());
    }

    public CompletableFuture<String> getTodayBillAmountFuture() {
        return CompletableFuture.supplyAsync(() -> this.getTodayBillAmount());
    }

    public String getOrderCount() {
        System.out.println("--------------开始获取订单总数------------" + Thread.currentThread().getName());
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch(InterruptedException e) {
            // do nothing
        }
        return "200";
    }

    public String getTodayBillAmount() {
        System.out.println("--------------开始获取今日订单金额------------" + Thread.currentThread().getName());
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch(InterruptedException e) {
            // do nothing
        }
        return "2000000";
    }

    public static void main(String[] args) {
        JSONObject jsonObj = new JSONObject();
        CompletableFutureTest service = new CompletableFutureTest();

        CompletableFuture<String> orderNumFuture = service.getOrderCountFuture();
        CompletableFuture<String> billAmountFuture = service.getTodayBillAmountFuture();

        orderNumFuture.whenComplete((v, t) -> {
          jsonObj.put("orderNum", v);
        });

        billAmountFuture.whenComplete((v, t) -> {
            jsonObj.put("billAmount", v);
        });

        // 不执行allOf这句，json值为空
        CompletableFuture.allOf(
                orderNumFuture, billAmountFuture
        ).thenRun(() -> System.out.println("完成")).join();

        System.out.println(jsonObj);
    }

}
