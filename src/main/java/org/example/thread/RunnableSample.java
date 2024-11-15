package org.example.thread;

import java.util.Random;

/***
 * 继承Runnable类实现多线程
 *
 * @author Swei
 * @description
 * @date 2024/10/24 14:17
 **/
public class RunnableSample {

    private class MyRunnable implements Runnable {

        @Override
        public void run() {
            int speed = new Random().nextInt(10);
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread name: " + Thread.currentThread().getName() + "在第" + i + " 秒 run 了" + i * speed + "米，speed是" + speed + " km/h");
            }
        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new RunnableSample().new MyRunnable();
        Thread threadA = new Thread(myRunnable);
        threadA.setName("运动员A");

        Thread threadB = new Thread(myRunnable);
        threadB.setName("运动员A");

        Thread threadC = new Thread(myRunnable);
        threadC.setName("运动员A");

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
