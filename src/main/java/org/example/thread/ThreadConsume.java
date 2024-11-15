package org.example.thread;

import java.util.ArrayList;
import java.util.List;

/***
 * 模拟多线程购物
 * @author Swei
 * @description
 * @date 2024/10/28 16:57
 **/
public class ThreadConsume {

    //票的总量
    private int TICKET_NUM = 10;

    //记录购买到票的人
    private List<String> list = new ArrayList<>();

    /***
     * 平台类
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/10/28 19:07
     * @return
     */
    private class Site {

        /***
         * 购票
         * @description 购买票
         * @param
         * @author Swei
         * @date 2024/10/28 19:03
         * @return void
         */
        private synchronized void buy() throws InterruptedException {
            Thread.sleep(500);
            if (TICKET_NUM < 1) {
                System.out.println("当前库存不足，请下次再来");
                return;
            }
            TICKET_NUM--;
            list.add(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + "购买了一张票");
        }
    }

    /***
     *
     * 消费者类
     * @description
     * @param
     * @author Swei
     * @date 2024/10/28 19:08
     * @return
     */
    private class Consumer implements Runnable {

        private Site site;

        @Override
        public void run() {
            try {
                site.buy();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadConsume threadConsume = new ThreadConsume();
        Site site = threadConsume.new Site();
        for (int i = 0; i < 20; i++) {
            Thread.sleep(500);
            System.out.println("用户" + i + "开始购买");
            Consumer consumer = threadConsume.new Consumer();
            consumer.site = site;
            Thread thread = new Thread(consumer, "用户" + i);
            thread.start();
            System.out.println("当前剩余票数" + threadConsume.TICKET_NUM);
        }
        System.out.println("仓库内剩余票数：" + threadConsume.TICKET_NUM);
        System.out.println("成功购买的人数" + threadConsume.list.size());
        for (String s : threadConsume.list) {
            System.out.println(s);
        }
    }

}
