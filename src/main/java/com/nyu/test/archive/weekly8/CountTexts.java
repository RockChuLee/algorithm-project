package com.nyu.test.archive.weekly8;


public class CountTexts {
    static int mod = (int) (Math.pow(10, 9) + 7);

    public static int countTexts(String pressedKeys) {
        int result = 1;
        int length = pressedKeys.length();
        for (int i = 0; i < length; ) {
            char c = pressedKeys.charAt(i);
            int j = i + 1;
            int count = 1;
            while (j < length && c == pressedKeys.charAt(j)) {
                count++;
                j++;
            }
            i = j;
            result = (result * (dp(c, count) % mod)) % mod;
        }
        return result;
    }

    public static int dp(char c, int num) {
        int[] dp = new int[num + 1];
        dp[0] = 1;
        for (int i = 0; i < num; i++) {
            int temp = 0;
            int index = i + 1;
            temp += dp[index - 1] % mod;
            if (index - 2 >= 0) {
                temp += dp[index - 2] % mod;
            }
            if (index - 3 >= 0) {
                temp += dp[index - 3] % mod;
            }
            if (c == '7' || c == '9') {
                if (index - 4 >= 0) {
                    temp += dp[index - 4] % mod;
                }
            }
            dp[index] = temp % mod;
        }
        return dp[num];
    }

    public static void main(String[] args) {
        System.out.println(countTexts("22222222222222222222222222222222222233333"));
    }
}
