package org.example.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 *
 *
 * @author Swei
 * @description
 * @date 2024/10/23 20:10
 **/
public class PtMethod {

    private <T> List<T> transferToList(T[] array) {
        List<T> list = new ArrayList<>();
        list.addAll(Arrays.asList(array));
        return list;
    }

    public static void main(String[] args) {
        PtMethod ptMethod = new PtMethod();
        String[] array = {"1", "2", "3"};
        List<String> list = ptMethod.transferToList(array);
        System.out.println(list);
    }
}
