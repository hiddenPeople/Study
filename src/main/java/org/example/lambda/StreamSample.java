package org.example.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/***
 * Stream流对象的五种创建方式
 *
 * @author Swei
 * @description
 * @date 2024/11/15 16:15
 **/
public class StreamSample {

    /***
     * 基于数组的创建
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/18 10:22
     * @return void
     */
    public static void generator1() {
        System.out.println("<===generator1===>");
        String[] array = {"a", "b", "c"};
        Stream.of(array).forEach(System.out::println);

        Stream<String> stream = Stream.of(array);
        stream.forEach(System.out::println);
    }

    /***
     * 基于集合的创建
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/18 10:36
     * @return void
     */
    public static void generator2() {
        System.out.println("<===generator2===>");
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.forEach(System.out::println);

        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }

    /***
     * 利用stream中generate方法创建无限长度流
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/18 10:54
     * @return void
     */
    private static void generator3() {
        System.out.println("<===generator3===>");
        Stream<Integer> stream = Stream.generate(() -> new Random().nextInt(100000));
        stream.limit(10).forEach(System.out::println);
    }

    /***
     * 基于stream的迭代器的创建
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/18 11:18
     * @return void
     */
    private static void generator4() {
        System.out.println("<===generator4===>");
        Stream<Integer> stream = Stream.iterate(1, item -> item + 1);
        stream.limit(10).forEach(System.out::println);
    }

    /***
     * 基于字符序列创建流
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/18 11:22
     * @return void
     */
    private static void generator5() {
        System.out.println("<===generator5===>");
        String str = "hello world";
        str.chars().forEach(s -> System.out.println((char) s));
    }

    public static void main(String[] args) {
        generator1();
        generator2();
        generator3();
        generator4();
        generator5();
    }

}
