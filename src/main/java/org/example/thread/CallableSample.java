package org.example.thread;

import java.util.Random;
import java.util.concurrent.*;

/***
 * 实现Callable接口完成多线程
 *
 * @author Swei
 * @description 涉及到了线程池的使用
 * @date 2024/10/25 15:39
 **/
public class CallableSample {

    private class MyCallable implements Callable<Integer> {

        private String name;

        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public Integer call() throws Exception {
            int speed = new Random().nextInt(10);
            Integer result = 0;
            for (int i = 1; i < 11; i++) {
                Thread.sleep(1000);
                result = speed * i;
                System.out.println(this.name + "在第" + i + " 秒 run 了" + i * speed + "米，speed是" + speed + " km/h");
                System.out.println("Thread name: " + Thread.currentThread().getName() + "在第" + i + " 秒 run 了" + i * speed + "米，speed是" + speed + " km/h");
            }
            return result;
        }

    }

    private void run() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        MyCallable myCallable1 = new MyCallable();
        myCallable1.name = "运动员A";

        MyCallable myCallable2 = new MyCallable();
        myCallable2.name = "运动员B";

        MyCallable myCallable3 = new MyCallable();
        myCallable3.name = "运动员C";
        Future<Integer> f1 = service.submit(myCallable1);
        Future<Integer> f2 = service.submit(myCallable2);
        Future<Integer> f3 = service.submit(myCallable3);
        service.shutdown();
        System.out.println(myCallable1.name + "累计跑了" + f1.get() + "米");
        System.out.println(myCallable2.name + "累计跑了" + f2.get() + "米");
        System.out.println(myCallable3.name + "累计跑了" + f3.get() + "米");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new CallableSample().run();
    }
}
