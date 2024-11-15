package org.example.collection;

import org.example.collection.entity.TestSample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/***
 * @author Swei
 * @description list 集合的循环遍历
 * @date 2024/10/23 18:02
 **/
public class ListLoop {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");

        List<TestSample> list2 = new ArrayList<>();
        list2.add(new TestSample("hello", 1));
        list2.add(new TestSample("world", 2));
        list2.add(new TestSample("java", 3));
        Collections.sort(list2, new SetSample().new TestSampleComparator());
        System.out.println(list2);

        //方法一
        for (String str : list) {
            //  System.out.println(str);
        }

        //方法二
        //list.forEach(System.out::println);

        list.forEach(str -> {
            //  System.out.println(str);
        });

        //方法三
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            // System.out.println(it.next());
        }


    }
}
