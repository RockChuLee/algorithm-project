package com.nyu.algorithm.search;

public class BinarySearch {
    //Time Complexity: O(log n)
    //Auxiliary Space: O(log n)
    int recursion(int[] arr, int l, int r, int x) {
        if (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return recursion(arr, l, mid - 1, x);
            return recursion(arr, mid + 1, r, x);
        }

        return -1;
    }

    //Time Complexity: O(log n)
    //Auxiliary Space: O(1)
    int iterator(int arr[], int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x)
                return mid;
            if (arr[mid] < x)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    public static void main(String args[]) {
        BinarySearch ob = new BinarySearch();
        int arr[] = {2, 3, 4, 10, 40};
        int n = arr.length;
        int x = 10;
        int result = ob.recursion(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }
}
