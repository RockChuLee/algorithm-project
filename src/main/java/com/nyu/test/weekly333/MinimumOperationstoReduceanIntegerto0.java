package com.nyu.test.weekly333;

public class MinimumOperationstoReduceanIntegerto0 {

    // 贪心
    public int minOperations(int n) {
        if (n == 0) return 0;
        int res = 0;
        int i = 1;
        while (n > 0) {
            while ((n & i) == 0) {
                i <<= 1;
            }
            i <<= 1;
            if ((n & i) != 0) {  // 遇到一群相连的1，进位消除。
                res += 1;
                n += (i >> 1);
            } else {  // 遇到单独一个1，直接减掉。
                n -= (i >> 1);
                res += 1;
            }
        }
        return res;
    }

    // dfs + 记忆搜索
    public int minOperations1(int n) {
        return dfs(n);
    }
    int dfs(int x) {
        if ((x & (x-1)) == 0) return 1; // x 是 2 的次幂
        int lb = x & -x;
        return 1 + Math.min(dfs(x + lb), dfs(x - lb));
    }
}
