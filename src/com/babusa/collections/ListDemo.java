package com.babusa.collections;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
//        Collection<Integer> list1 = new ArrayList<Integer>();
//        list1.add(1);
//        list1.add(2);
//        list1.add(3);
//        list1.add(3);
//        list1.add(null);
//
//        System.out.println(list1);
//        list1.remove(3);
//        list1.remove(3);
//        System.out.println(list1);

        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(3);
        list1.add(null);

        System.out.println(list1);
        list1.remove(3);
        list1.remove(3);
        System.out.println(list1);
        list1.add(0, 10);
        System.out.println(list1);
        list1.set(0, 9);
        System.out.println(list1);
        list1.add(1);
        System.out.println(list1);

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(1);
        list2.add(9);

        // Bulk op

//        list1.removeAll(list2);
//        System.out.println(list1);

//        list1.retainAll(list2);
//        System.out.println(list1);

//        list1.addAll(list2);
//        System.out.println(list1);

        // Search
        System.out.println("list1.contains(1): " + list1.contains(1));
        System.out.println("list1.indexOf(1): " + list1.indexOf(1));
        System.out.println("list1.lastIndexOf(1): " + list1.lastIndexOf(1));




    }
}
