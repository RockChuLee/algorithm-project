package com.nyu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class CountVowelsPermutation {

    /*
    brute force 超时
     */
    public static int countVowelPermutation1(int n) {

        ArrayList<StringBuilder> elements = new ArrayList<>();

        elements.add(new StringBuilder("a"));
        elements.add(new StringBuilder("e"));
        elements.add(new StringBuilder("i"));
        elements.add(new StringBuilder("o"));
        elements.add(new StringBuilder("u"));


        if (n < 1 && n > 2 * Math.pow(10, 4)) {
            return 0;
        } else if (n == 1) {
            return 5;
        } else {
            for (int i = 1; i < n; i++) {
                int size = elements.size();
                for (int j = 0; j < size; j++) {
                    StringBuilder stringBuilder = elements.get(j);
                    String a = stringBuilder.toString();
                    char key = a.charAt(a.length() - 1);
                    if (key == 'a') {
                        stringBuilder.append("e");
                    }
                    if (key == 'e') {
                        String str = stringBuilder.toString();
                        stringBuilder.append("a");
                        elements.add(new StringBuilder(str + "i"));

                    }
                    if (key == 'i') {
                        String str = stringBuilder.toString();
                        stringBuilder.append("a");
                        elements.add(new StringBuilder(str + "e"));
                        elements.add(new StringBuilder(str + "o"));
                        elements.add(new StringBuilder(str + "u"));
                    }
                    if (key == 'o') {
                        String str = stringBuilder.toString();
                        stringBuilder.append("i");
                        elements.add(new StringBuilder(str + "u"));
                    }
                    if (key == 'u') {
                        stringBuilder.append("a");
                    }
                }
            }
            System.out.println(elements);
            return elements.size();
        }


    }

    /*
    dp 方程
     */
    public static int countVowelPermutation2(int n) {

        Long mod = 1000000007L;

        HashMap<Character, Long> map = new HashMap<>();
        map.put('a', 1L);
        map.put('e', 1L);
        map.put('i', 1L);
        map.put('o', 1L);
        map.put('u', 1L);

        if (n < 1 && n > 2 * Math.pow(10, 4)) {
            return 0;
        } else if (n == 1) {
            return 5;
        } else {
            for (int i = 1; i < n; i++) {
                Long aNum = map.get('a');
                Long eNum = map.get('e');
                Long iNum = map.get('i');
                Long oNum = map.get('o');
                Long uNum = map.get('u');
                map.put('a', (eNum + iNum + uNum) % mod);
                map.put('e', (aNum + iNum)% mod);
                map.put('i', (eNum + oNum)% mod);
                map.put('o', (iNum)% mod);
                map.put('u', (oNum + iNum)% mod);
            }

            Set<Character> s = map.keySet();
            Long sum = 0L;
            for (Character key : s) {
                Long value = map.get(key);
//                System.out.println("丈夫:" + key + "---媳妇:" + value);
                sum = (sum + value)% mod;
            }

            return (int)(sum % mod);
        }
    }

    public static int countVowelPermutation(int n) {
        long mod = 1000000007;
        long[] dp = new long[5];
        long[] ndp = new long[5];
        for (int i = 0; i < 5; ++i) {
            dp[i] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            /* a前面可以为e,u,i */
            ndp[0] = (dp[1] + dp[2] + dp[4]) % mod;
            /* e前面可以为a,i */
            ndp[1] = (dp[0] + dp[2]) % mod;
            /* i前面可以为e,o */
            ndp[2] = (dp[1] + dp[3]) % mod;
            /* o前面可以为i */
            ndp[3] = dp[2];
            /* u前面可以为i,o */
            ndp[4] = (dp[2] + dp[3]) % mod;
            System.arraycopy(ndp, 0, dp, 0, 5);
        }
        long ans = 0;
        for (int i = 0; i < 5; ++i) {
            ans = (ans + dp[i]) % mod;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(countVowelPermutation(158));
    }

}
