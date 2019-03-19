package com.babusa.collections;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;
import java.util.function.Consumer;

public class ListDemo implements Iterable<Integer> {

    public Iterator<Integer> iterator() {
        return new ArrayList().iterator();
    }

    public static void main(String[] args) {
//        List<Integer> list1 = arrayListDemo();
//        iteratorDemo(list1);
        listIteratorDemo();
    }

    static void listIteratorDemo() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        for(ListIterator<String> iterator = list.listIterator(); iterator.hasNext();) {
            System.out.println("iterator.nextIndex(): " + iterator.nextIndex() + ", iterator.next(): " + iterator.next());
        }

        System.out.println("\n");
        ListIterator<String> iterator = list.listIterator();
        for(; iterator.hasNext();) {
            if (iterator.nextIndex() == 1) {
                iterator.add("test");
                iterator.add("sample");
                iterator.previous();
                iterator.previous();
                iterator.remove();
            }
            System.out.println("iterator.nextIndex(): " + iterator.nextIndex() + ", iterator.next(): " + iterator.next());

        }

        System.out.println("\n");
        for(; iterator.hasPrevious();) {
            System.out.println("iterator.previousIndex(): " + iterator.previousIndex() + ", iterator.previous(): " + iterator.previous());
        }

    }

    public static List<Integer> arrayListDemo() {
        System.out.println("\nInsider arrayListDemo ...");
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

        // Range
        System.out.println("Range: subList");
        List<Integer> list3 = list1.subList(2, 3);
        System.out.println("list1: " + list1);
        System.out.println("list3: " + list3);
//
//        System.out.println("Range: subList: set");
//        list3.set(0, 6);
//        System.out.println("list1: " + list1);
//        System.out.println("list3: " + list3);
//
//        System.out.println("Range: subList: add");
//        list3.add(0, 7);
//        System.out.println("list1: " + list1);
//        System.out.println("list3: " + list3);

//        System.out.println("Range: subList: removeAll");
//        list3.removeAll(list1);
//        System.out.println("list1: " + list1);
//        System.out.println("list3: " + list3);


        try {
            System.out.println("Range: subList: make changes in src list");
            list1.add(0, 8);
            System.out.println("list1: " + list1);
            System.out.println(list3);
        } catch (Exception e) {
            System.out.println("Exception: Structural changes (add/remove items) to src list would result in java.util.ConcurrentModificationException exception when accessing the sublist element");
//            e.printStackTrace();
        }

        System.out.println("modifying elements while looping");
        try {
            for(int element: list1) {
            // for(int element: new ListDemo()) {
                System.out.println("element: " + element + " >>");
                // Generates ConcurrentModificationException:
                if (element == 1) {
//                    list1.remove(Integer.valueOf(element));
                    list1.add(100);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception: To accomplish removing of elements during iteration > use iterators");
            // e.printStackTrace();
        }
        return list1;
    }

    public static void iteratorDemo(List list1) {
        System.out.println("\nInsider iteratorDemo ...");
        System.out.println("list1: " + list1);
        Iterator<Integer> iterator = list1.iterator();
        int item;
        System.out.println("Remove item while looping using iterator ");
        while(iterator.hasNext()) {
            item = iterator.next();
            System.out.println(" element: "+item);
            if(item == 9) {
                System.out.println("remove element 9");
                iterator.remove();
                System.out.println("forEachRemaining start");
                iterator.forEachRemaining(Filter::add);
                System.out.println("forEachRemaining end");
            }
        }
        System.out.println("list1: " + list1);

//        list1.forEach(System.out::println);
//        list1.forEach(Filter::filter);
//        list1.forEach(new Filter()); // requires implementing Consumer

        // forEachRemaining:
        // iterator.forEachRemaining(Filter::add);


    }
}

class Filter implements Consumer {
    static void filter(Integer i) {
        if(i == 1) {
            System.out.println(i);
        }
    }

    public void accept(Object i) {
        if((int)i == 1) {
            System.out.println(i);
        }
    }

    static void add(Integer i) {
        System.out.println("Filter:add");
        System.out.println(i + 100);
    }
}