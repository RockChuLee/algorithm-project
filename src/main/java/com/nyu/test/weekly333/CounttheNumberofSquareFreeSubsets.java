package com.nyu.test.weekly333;

public class CounttheNumberofSquareFreeSubsets {

    private static final int[] PRIMES = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    private static final int MOD = (int) 1e9 + 7, MX = 30, N_PRIMES = PRIMES.length, M = 1 << N_PRIMES;
    private static final int[] NSQ_TO_MASK = new int[MX + 1]; // NSQ_TO_MASK[i] 为 i 对应的质数集合（用二进制表示）

    static {
        for (int i = 2; i <= MX; ++i)
            for (int j = 0; j < N_PRIMES; ++j) {
                int p = PRIMES[j];
                if (i % p == 0) {
                    if (i % (p * p) == 0) { // 有平方因子
                        NSQ_TO_MASK[i] = -1;
                        break;
                    }
                    NSQ_TO_MASK[i] |= 1 << j; // 把 j 加到集合中
                }
            }
    }

    public int squareFreeSubsets(int[] nums) {
        int[] f = new int[M]; // f[j] 表示恰好组成集合 j 的方案数
        f[0] = 1; // 空集的方案数为 1
        for (int x : nums) {
            int mask = NSQ_TO_MASK[x];
            if (mask >= 0) // x 是 NSQ
                for (int j = M - 1; j >= mask; --j)
                    if ((j | mask) == j)  // mask 是 j 的子集
                        f[j] = (f[j] + f[j ^ mask]) % MOD; // 不选 mask + 选 mask
        }
        long ans = 0L;
        for (int v : f) ans += v;
        return (int) ((ans - 1) % MOD); // -1 去掉空集
    }
}

