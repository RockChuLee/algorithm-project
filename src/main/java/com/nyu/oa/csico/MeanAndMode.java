package com.nyu.oa.csico;

import java.text.DecimalFormat;
import java.util.*;

/**
 * The arithmetic mean of N numbers is the sum of the numbers, divided by N.The mode of N numbers is the most frequently
 * occuring number. your program must output the mean and mode of a set of numbers.
 *
 * Input
 * The first line of the input consists of an integer - inputArr_size, an integer representing the count of numbers in the given list.
 * The second line of the input consists of N space-separated real numbers -  inputArr representing the numbers of the given list.
 *
 * Output
 * Print two space-separated real numbers up-to two digits representing the mean and mode of a set of numbers.
 *
 * Constraints
 * 0 < inputArr_size < 10^3
 * -10^5 ≤ inputArr[i] ≤ 10^5; where i is representing the index of the inputArr.0 ≤ i < inputArr_size
 *
 * Note
 * '0' and negative numbers are valid inputs.lf more than one number has the same
 * frequency,then choose the smallest nuinber
 */

public class MeanAndMode {
    public static float[]  meanAndMode(float[] inputArr)
    {
        // Write your code here
        HashMap<Float,Integer> map = new HashMap<>();
        Integer max = 0;
        float sum = 0;
        ArrayList<Float> mode = new ArrayList<>();
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        for (float v : inputArr) {
            map.put(v, map.getOrDefault(v, 0) + 1);
            sum += v;
        }
        Set<Map.Entry<Float, Integer>> entries = map.entrySet();
        for (Map.Entry<Float, Integer> entry : entries) {
            Float key = entry.getKey();
            Integer value = entry.getValue();
            if (value > max) {
                mode.clear();
                mode.add(key);
                max = value;
            } else if (value == max) {
                mode.add(key);
            }
        }
        int size = mode.size()+1;
        float[]  answer = new float[size];
        answer[0] = Float.parseFloat(df.format(sum / inputArr.length));
        for (int i = 0; i < mode.size() ; i++) {
            answer[i + 1] = Float.parseFloat(df.format(mode.get(i)));
        }
        return answer;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        //input for inputArr
        int inputArr_size = in.nextInt();
        float inputArr[] = new float[inputArr_size];
        for(int idx = 0; idx < inputArr_size; idx++)
        {
            inputArr[idx] = in.nextFloat();
        }

        float[] result = meanAndMode(inputArr);
        for(int idx = 0; idx < result.length - 1; idx++)
        {
            System.out.print(result[idx] + " ");
        }
        System.out.print(result[result.length - 1]);
    }
}
