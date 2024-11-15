package org.example.thread;

/***
 * 多线程中的同步
 *
 * @author Swei
 * @description 使用synchronized关键字实现同步
 * @date 2024/10/26 09:50
 **/
public class SyncSample {

    private class Printer {

        public synchronized void print(String name) throws InterruptedException {
            Thread.sleep(500);
            System.out.println("线程" + name + "开始打印");
            Thread.sleep(500);
            System.out.println("线程" + name + "哒哒哒哒");
            Thread.sleep(500);
            System.out.println("线程" + name + "嘟嘟嘟嘟");
            Thread.sleep(500);
            System.out.println("线程" + name + "滴滴滴滴");
            Thread.sleep(500);
            System.out.println("线程" + name + "结束打印");
        }
    }

    private class MyRunnable implements Runnable {

        private Printer printer;

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            try {
                printer.print(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void startPrinter() {
        Printer printer = new Printer();

        MyRunnable myRunnable = new MyRunnable();
        myRunnable.printer = printer;
        Thread myThread = new Thread(myRunnable);
        myThread.setName("线程1");


        MyRunnable myRunnable2 = new MyRunnable();
        myRunnable2.printer = printer;
        Thread myThread2 = new Thread(myRunnable2);
        myThread2.setName("线程2");

        MyRunnable myRunnable3 = new MyRunnable();
        myRunnable3.printer = printer;
        Thread myThread3 = new Thread(myRunnable3);
        myThread3.setName("线程3");

        myThread.start();
        myThread2.start();
        myThread3.start();
    }

    public static void main(String[] args) {
        SyncSample sample = new SyncSample();
        sample.startPrinter();
    }
}
