package com.nyu.algorithm.sort;

public class Test {
    public static void main(String[] args) {
//        Selection sort = new Selection();
//        Insertion sort = new Insertion();
        Bubble sort = new Bubble();

        Integer[] demo = new Integer[]{9, 6, 3, 5, 1, 7, 2, 8, 4};
        assert Selection.isSorted(demo);
        Selection.sort(demo);
        assert Selection.isSorted(demo);
        Selection.show(demo);
    }
}
