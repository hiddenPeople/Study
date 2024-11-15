package org.example.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/***
 * 函数式编程
 *
 * @author Swei
 * @description Predicate 函数式接口
 * @date 2024/11/15 09:38
 **/
public class PredicateSample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        filter(list, i -> i % 2 == 0);
    }

    /***
     * 利用Predicate函数式接口过滤集合
     *
     * @description 并不清楚最开始需要干什么，而是在该方法运行中动态执行
     * @Description Predicate函数式接口boolean test(T t)用来指定数据类型进行判断方法
     * @param
     * @author Swei
     * @date 2024/11/15 09:45
     * @return void
     */
    private static void filter(List<Integer> list, Predicate<Integer> predicate) {
        if (list.isEmpty()) {
            return;
        }
        for (Integer i : list) {
            if (predicate.test(i)) {
                System.out.println(i);
                System.out.print("  ");
            }
        }
    }
}
