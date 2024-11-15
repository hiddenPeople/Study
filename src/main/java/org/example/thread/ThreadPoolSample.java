package org.example.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/***
 * 线程池示例
 *
 * @author Swei
 * @description
 * @date 2024/10/29 09:14
 **/
public class ThreadPoolSample {


    /***
     * 定长线程池：线程数量固定，线程数量不会随着任务的增加而增加，线程数量也不会随着任务的减少而减少。
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/10/30 09:10
     * @return void
     */
    private void writeFixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });

            Future<Integer> featureTask = (Future<Integer>) executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    System.out.println(Thread.currentThread().getName() + "====>");
                    return 1;
                }
            });
            try {
                System.out.println(featureTask.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }


    /***
     * 缓存线程池：线程数量不固定，可以根据任务数量动态调整。
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/10/30 09:11
     * @return void
     */
    private void writeCachedThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        executorService.shutdownNow();
    }

    /***
     * 单线程池：线程数量固定，且只有一个线程。
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/10/30 09:11
     * @return void
     */
    private void writeSingleThreadPool() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        executorService.shutdown();
    }

    /***
     * 调度线程池：可以延迟执行任务，也可以周期性执行任务。
     *
     * @description scheduleAtFixedRate方法是执行完上一个任务如果还在线程等待期，则等待完再执行，如果线程执行时间过长，则等待上一个任务执行完，再直接执行下一个任务。
     * @description scheduleWithFixedDelay方法是执行完上一个任务如果还在线程等待期，则等待完再执行，如果线程执行时间过长，则等待上一个任务执行完之后，开始线程等待时间，等待时间结束之后执行下一个任务。
     * @description 调度线程池不需要立马写shutdown，因为调度线程池是定时执行的，不需要主动关闭。
     * @param
     * @author Swei
     * @date 2024/10/30 09:16
     * @return void
     */
    private void writeScheduledThreadPool() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         /*   scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run()
                {
                    System.out.println("开始任务时间1===>"+sdf.format(new Date()));
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("结束任务时间1===>"+sdf.format(new Date()));
                }
            }, 0, 3, TimeUnit.SECONDS);*/
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始任务时间2===>" + sdf.format(new Date()));
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("结束任务时间2===>" + sdf.format(new Date()));
            }
        }, 0, 3, TimeUnit.SECONDS);

    }

    public static void main(String[] args) {
        ThreadPoolSample threadPoolSample = new ThreadPoolSample();
//        threadPoolSample.writeFixedThreadPool();
//        threadPoolSample.writeCachedThreadPool();
//        threadPoolSample.writeSingleThreadPool();
        threadPoolSample.writeScheduledThreadPool();
    }
}
