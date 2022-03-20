package com.nyu.leetcode.weekly2;

public class CountCollisions {
    public static int countCollisions(String directions) {
        char[] s = directions.toCharArray();
        int n = s.length, i = 0;
        int count = 0;
        while (i < n) {
            int start = i;
            while (i < n - 1 && s[i] == s[i + 1]) { // 找到一段连续的没有被推动的骨牌
                i++;
            }
            char left = i < n ? s[i] : 'L';
            int j = i + 1;
            while (j < n - 1 && s[j] == s[j + 1]) { // 找到一段连续的没有被推动的骨牌
                j++;
            }
            char right = j < n ? s[j] : 'R';
            if (left == 'R') {
                if (right == 'L') {
                    count = count + j - start + 1;
                } else if (right == 'S') {
                    count = count + i - start + 1;
                }
            } else if (left == 'S') {
                if (right == 'L') {
                    count = count + j - i;
                }
            }
            i++;
        }
        return count;
    }

//    public static int countCollisions(String directions) {
//        int n = directions.length();
//        char[] chs = directions.toCharArray();
//        int i = 0, j = n - 1;
//        while(i < n && chs[i] == 'L') {
//            ++i;
//        }
//        while(j >= 0 && chs[j] == 'R') {
//            --j;
//        }
//        int countS = 0;
//        for(int k = i; k <= j; k++) {
//            if(chs[k] == 'S') {
//                ++countS;
//            }
//        }
//        return j - i + 1 - countS;
//    }

    public static void main(String[] args) {
        System.out.println(countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"));
//        System.out.println("012345".substring(0,1));
    }
}
