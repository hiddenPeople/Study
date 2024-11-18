package org.example.lambda;

import lombok.SneakyThrows;

import java.util.*;
import java.util.stream.Collectors;

/***
 * Lambda表达式9种常见的用法
 *
 * @author Swei
 * @description
 * @date 2024/11/18 15:21
 **/
public class LambdaSample {

    /***
     * 使用Lambda表达式遍历集合
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/18 16:43
     * @return void
     */
    private static void case1() {
        System.out.println();
        System.out.println("使用Lambda表达式遍历集合");
        System.out.println("**************************************");

        List<String> list = Arrays.asList("apple", "orange", "banana");

        System.out.println("非lambda写法:");
//        非lambda写法
        for (String item : list) {
            System.out.println(item);
        }

        System.out.println("lambda写法:");
//        lambda 写法
        list.forEach(System.out::println);
    }

    /***
     * 使用Lambda表达式进行排序
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/18 16:27
     * @return void
     */
    private static void case2() {
        System.out.println();
        System.out.println("使用Lambda表达式进行排序");
        System.out.println("**************************************");
        List<String> list1 = Arrays.asList("apple", "orange", "banana");
        List<String> list2 = Arrays.asList("apple", "orange", "banana");
        List<String> list3 = Arrays.asList("apple", "orange", "banana");

//        非lambda写法
        Collections.sort(list1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("非lambda写法:");
        list1.forEach(System.out::println);

//        lambda 写法
        System.out.println("lambda写法1:");
        Collections.sort(list2, (o1, o2) -> o1.compareTo(o2));
        list2.forEach(System.out::println);

        System.out.println("lambda写法2:");
        list3.sort(Comparator.naturalOrder());
        list3.forEach(System.out::println);
    }

    /***
     * 使用Lambda表达式进行过滤
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/18 16:27
     * @return void
     */
    private static void case3() {
        System.out.println();
        System.out.println("使用Lambda表达式进行过滤");
        System.out.println("**************************************");
        List<String> list = Arrays.asList("apple", "orange", "banana");
        List<String> finalList = new ArrayList<>();
//        非lambda写法
        for (String s : list) {
            if (s.startsWith("a")) {
                finalList.add(s);
            }
        }
        System.out.println("非Lambda写法：");
        finalList.forEach(System.out::println);

        System.out.println("Lambda写法：");
        List<String> collect = list.stream().filter(s -> s.startsWith("a")).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    /***
     * 使用Lambda表达式进行映射
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/18 16:28
     * @return void
     */
    private static void case4() {
        System.out.println();
        System.out.println("使用Lambda表达式进行映射");
        System.out.println("**************************************");
        List<String> list = Arrays.asList("apple", "orange", "banana");
        List<Integer> finalList = new ArrayList<>();
        for (String s : list) {
            finalList.add(s.length());
        }
        System.out.println("非Lambda写法：");
        finalList.forEach(System.out::println);

        System.out.println("Lambda写法1：");
        List<Integer> collect = list.stream().map(String::length).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("Lambda写法2：");
        List<Integer> collect2 = list.stream().map(s -> s.length()).collect(Collectors.toList());
        collect2.forEach(System.out::println);
    }

    /***
     * 使用Lambda表达式进行规约
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/18 16:29
     * @return void
     */
    private static void case5() {
        System.out.println();
        System.out.println("使用Lambda表达式进行规约");
        System.out.println("**************************************");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        System.out.println("非Lambda写法：");
        System.out.println(sum);

        int sum1 = list.stream().reduce(0, Integer::sum);
        System.out.println("Lambda写法1：");
        System.out.println(sum1);

        int sum2 = list.stream().mapToInt(Integer::valueOf).sum();
        System.out.println("Lambda写法2：");
        System.out.println(sum2);
    }

    /***
     * 使用Lambda表达式进行分组
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/18 16:29
     * @return void
     */
    private static void case6() {
        System.out.println();
        System.out.println("使用Lambda表达式进行分组");
        System.out.println("**************************************");
        List<String> list = Arrays.asList("apple", "orange", "banana");
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : list) {
            Integer length = s.length();
            if (!map.containsKey(length)) {
                map.put(s.length(), new ArrayList<>());
            }
            map.get(length).add(s);
        }
        System.out.println("非Lambda写法：");
        map.forEach((k, v) -> System.out.println(k + ":" + v));

        System.out.println("Lambda写法：");
        list.stream().collect(Collectors.groupingBy(String::length)).forEach((k, v) -> System.out.println(k + ":" + v));
    }

    /***
     * 使用Lambda表达式进行线程创建
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/18 16:30
     * @return void
     */
    @SneakyThrows
    private static void case7() {
        System.out.println();
        System.out.println("使用Lambda表达式进行线程创建");
        System.out.println("**************************************");
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("非Lambda写法");
                System.out.println("Thread is running.");
            }
        });
        thread.start();
        Thread thread1 = new Thread(() -> {
            System.out.println("Lambda写法");
            System.out.println("Thread is running.");
        });
        thread1.start();
        Thread.sleep(1000);
    }

    /***
     * 使用Lambda表达式进行Optional操作
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/18 16:31
     * @return void
     */
    private static void case8() {
        System.out.println();
        System.out.println("使用Lambda表达式进行Optional操作");
        System.out.println("**************************************");
        String str = "hello world!";
        if (str != null) {
            System.out.println("非lambda写法：");
            System.out.println(str.toUpperCase());
        }

        System.out.println("lambda写法：");
        Optional.of(str).map(String::toUpperCase).ifPresent(System.out::println);
    }

    /***
     * 使用Lambda表达式进行Stream流水线操作
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/18 16:31
     * @return void
     */
    private static void case9() {
        System.out.println();
        System.out.println("使用Lambda表达式进行Stream流水线操作");
        System.out.println("**************************************");
        List<String> list = Arrays.asList("apple", "orange", "banana");
        List<String> filterList = new ArrayList<>();
        for (String fruit : list) {
            if (fruit.startsWith("a")) {
                filterList.add(fruit.toUpperCase());
            }
        }
        Collections.sort(filterList, (a, b) -> b.compareTo(a));
        System.out.println("非lambda写法：");
        filterList.forEach(System.out::println);

        System.out.println("lambda写法：");
        List<String> collect = list.stream().filter(s -> s.startsWith("a")).map(String::toUpperCase).sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    private static void case10() {
        System.out.println();
        System.out.println("测试");
        System.out.println("使用Lambda表达式进行排序");
        System.out.println("**************************************");
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//        非lambda写法
        Collections.sort(list1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println("非lambda写法:");
        list1.forEach(System.out::println);

//        lambda 写法
        System.out.println("lambda写法1:");
        Collections.sort(list2, (o1, o2) -> o2.compareTo(o1));
        list2.forEach(System.out::println);

        System.out.println("lambda写法2:");
//        正序
        list3.sort(Comparator.naturalOrder());
//        倒序
        list3.sort(Comparator.reverseOrder());
        list3.forEach(System.out::println);
    }

    public static void main(String[] args) {
        case1();
        case2();
        case3();
        case4();
        case5();
        case6();
        case7();
        case8();
        case9();
        case10();
    }
}
