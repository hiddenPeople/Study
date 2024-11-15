package org.example.lambda;

import java.util.function.Consumer;

/***
 * 函数式编程
 *
 * @author Swei
 * @description Consumer函数式接口
 * @date 2024/11/15 09:51
 **/
public class ConsumerSample {
    public static void main(String[] args) {
        output("hello world", s -> {
//            字符串大写输出
            String sUp = s.toUpperCase();
            System.out.println("1===>" + sUp);
//            字符串反转输出
            String result = new StringBuilder(sUp).reverse().toString();
            System.out.println("2===>" + result);
        });
    }

    /***
     * 调用Consumer接口accept方法
     *
     * @description Consumer 接口中包含抽象方法 void accept(T t) ，意为消费一个指定泛型的数据
     * @param
     * @author Swei
     * @date 2024/11/15 10:37
     * @return void
     */
    public static void output(String text, Consumer<String> consumer) {
        consumer.accept(text);
    }
}
