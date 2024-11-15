package org.example.collection;

import org.example.collection.entity.TestSample;

import java.util.*;

/***
 * @author Swei
 * @description
 * @date 2024/10/23 18:13
 **/
public class SetSample {

    /***
     * 如果有相同的元素，则按照比较器中的规则进行排序
     *
     * @description 结果>0，则交换顺序，否则不交换
     * @param
     * @author Swei
     * @date 2024/10/23 18:53
     * @return
     */
    class TestSampleComparator implements Comparator<TestSample> {
        @Override
        public int compare(TestSample o1, TestSample o2) {
            return o2.getAge() - o1.getAge();
        }
    }

    private void sort() {
        Set<TestSample> treeSet = new TreeSet<>(new TestSampleComparator());
        treeSet.add(new TestSample("小明", 18));
        treeSet.add(new TestSample("小华", 8));
        treeSet.add(new TestSample("小红", 16));
        treeSet.add(new TestSample("小光", 20));
        System.out.println("TreeSet==>>>>>>" + treeSet);
    }

    public static void main(String[] args) {
        Set<TestSample> set = new HashSet<>();
        set.add(new TestSample("小明", 18));
        set.add(new TestSample("小华", 8));
        set.add(new TestSample("小红", 16));
        set.add(new TestSample("小红", 20));
        //System.out.println("HashSet==>>>>>>"+set);

        Set<TestSample> set1 = new LinkedHashSet<>();
        set1.add(new TestSample("小明", 18));
        set1.add(new TestSample("小华", 8));
        set1.add(new TestSample("小红", 16));
        set1.add(new TestSample("小红", 20));
        //System.out.println("LinkedHashSet==>>>>>>"+set1);

        SetSample sample = new SetSample();
        sample.sort();
    }
}
