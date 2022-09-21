package com.nyu.oa.jpmorgan;

public class SubarraySum {
    public static long SubArraySum( int arr[] , int n )
    {
        long result = 0;

        // computing sum of subarray using formula
        for (int i=0; i<n; i++)
            result += (arr[i] * (i+1) * (n-i));

        // return all subarray sum
        return result ;
    }

    /* Driver program to test above function */
    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3} ;
        int n = arr.length;
        System.out.println("Sum of SubArray " +
                SubArraySum(arr, n));
    }
}
