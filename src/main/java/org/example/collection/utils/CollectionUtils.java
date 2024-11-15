package org.example.collection.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/****
 * 随机选取集合元素
 * @author Swei
 * @description
 * @date 2024/10/23 19:19
 **/
public class CollectionUtils<E> {
    private List<E> list = new ArrayList<>();

    public void add(E element) {
        list.add(element);
    }

    /***
     * 随机获取集合元素
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/10/23 19:22
     * @return E
     */
    public E randomSelect() {
        int index = new Random().nextInt(list.size());
        return list.get(index);
    }

    public static void main(String[] args) {
        CollectionUtils<Integer> collectionUtils = new CollectionUtils<>();
        collectionUtils.add(1);
        collectionUtils.add(3);
        collectionUtils.add(5);
        collectionUtils.add(7);
        collectionUtils.add(9);
        System.out.println(collectionUtils.randomSelect());
        System.out.println(collectionUtils.randomSelect());
        System.out.println(collectionUtils.randomSelect());
        System.out.println(collectionUtils.randomSelect());
    }
}
