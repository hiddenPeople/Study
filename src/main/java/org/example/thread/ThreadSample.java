package org.example.thread;

import java.util.Random;

/***
 * 继承Thread类实现多线程
 *
 * @author Swei
 * @description
 * @date 2024/10/24 10:26
 **/
public class ThreadSample {

    /***
     * 使用内部类继承Thread类实现多线程
     * @description
     * @param
     * @author Swei
     * @date 2024/10/24 10:31
     * @return
     */
    private class MyThread extends Thread {
        @Override
        public void run() {
            int speed = new Random().nextInt(10);
            for (int i = 1; i < 11; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(this.getName() + "在第" + i + " 秒 run 了" + i * speed + "米，speed是" + speed + " km/h");
            }
        }
    }


    public static void main(String[] args) {
        ThreadSample threadSample = new ThreadSample();
        MyThread myThreadA = threadSample.new MyThread();
        myThreadA.setName("运动员A");

        MyThread myThreadB = threadSample.new MyThread();
        myThreadB.setName("运动员B");

        MyThread myThreadC = threadSample.new MyThread();
        myThreadC.setName("运动员C");

        myThreadA.start();
        myThreadB.start();
        myThreadC.start();

    }
}
