package com.yt.yya;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        CompletableFuture.runAsync(() -> {
            System.out.println("hello world");
        }, executorService);
    }
}
