package org.example.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/***
 * Stream流常用的几种方法
 *
 * @author Swei
 * @description
 * @date 2024/11/18 11:28
 **/
public class StreamMethod {

    /***
     * 提取集合中所有是偶数的元素
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/18 15:10
     * @return void
     */
    private static void case1() {
        System.out.println("case1:");
        List<String> list = Arrays.asList("1", "2", "3", "4", "5");
        list.forEach(System.out::println);
        //获取stream流
        int sum = list.stream()
                //mapToInt将流中每一个数据转化成整数
                .mapToInt(Integer::parseInt)
                //filter对流数据做出过滤
                .filter(l -> l % 2 == 0)
                //对流的结果进行求和
                .sum();
        System.out.println("列表偶数总和：" + sum);
    }

    /***
     * 提取出所有元素并将首字母大写生成新的集合
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/18 15:11
     * @return void
     */
    private static void case2() {
        System.out.println("case2:");
        List<String> list = Arrays.asList("zeus", "oner", "faker", "gumayusi", "keria");
        //获取stream流
        List<String> collect = list.stream()
//                按规则对每一个流数据进行转换
                .map(l -> l.substring(0, 1).toUpperCase() + l.substring(1)) //
//                collection对数据流进行收集，生成新的List或者Set
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    /***
     * 将所有的奇数按从小到大排序，并且不重复生成新的集合
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/18 15:12
     * @return void
     */
    private static void case3() {
        System.out.println("case3:");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1);
//        获取stream流
        List<Integer> collect = list.stream()
//                去除重复的数据流
                .distinct()
//                按照规则过滤数据
                .filter(s -> s % 2 == 1)
//                对流数据进行排序
                .sorted((a, b) -> a - b)
//                收集流数据，生成新的List/Set
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    public static void main(String[] args) {
        case1();
        case2();
        case3();
    }
}
