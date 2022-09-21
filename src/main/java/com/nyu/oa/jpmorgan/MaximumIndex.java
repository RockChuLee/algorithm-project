package com.nyu.oa.jpmorgan;

public class MaximumIndex {


    // Function to find the maximum
    // index the pointer can reach
    static void maximumIndex(int N, int B) {
        int max_index = 0;

        // Calculate maximum possible
        // index that can be reached
        for (int i = 1; i <= N; i++) {
            max_index += i;
        }

        int current_index = max_index, step = N;

        while (true) {
            // Check if current index
            // and step both are greater
            // than 0 or not
            while (current_index > 0 && N > 0) {
                // Decrement current_index
                // by step
                current_index -= N;

                // Check if current index
                // is equal to B or not
                if (current_index == B) {
                    // Restore to previous
                    // index
                    current_index += N;
                }

                // Decrement step by one
                N--;
            }

            // If it reaches the 0th index
            if (current_index <= 0) {
                // Print result
                System.out.print(max_index + "\n");
                break;
            } else {
                // System.out.print(max_index-1 + "\n");

                // If max index fails to
                // reach the 0th index
                N = step;

                // Store max_index - 1 in
                // current index
                current_index = max_index - 1;

                // Decrement max index
                max_index--;

                // If current index is
                // equal to B
                if (current_index == B) {
                    current_index = max_index - 1;
                    // Decrement current index
                    max_index--;
                }
            }
        }
    }

    // Driver Code
    public static void main(String[] args) {
        int N = 4, B = 6;
        maximumIndex(N, B);
    }
}


