package com.nyu.leetcode.weekly3;

import java.util.List;

public class MaximumValueofKCoinsFromPiles {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        /*
        dp五部曲(转化为完全背包问题):
        这里的每一个栈都可以看成是一个分组,例如栈1:pile=[1,2,3],preSum=[1,3,6]
        也就是说组别1内有3件物品,其体积分别为:1,2,3;价值分别为1,3,6
        而每组中的物品只能取出一件,在背包容量有限的情况下最终目标要使得物品价值最大化!
        1.状态定义:dp[i][j]为考虑[0,i]组,背包容量为j时,能获取物品价值的最大值
        2.状态转移:
            参考分组背包的技巧,每次抉择范围为选第i组的哪个物品?其中包含一种特殊情况(m=0代表不选->dp[i-1][j])
            dp[i][j]=max(dp[i][j],dp[i-1][j-v[i][m]]+w[i][m]),m∈[0,pile.size()]
            这里的v[i][m]指第i组内的第k个物品的体积;w[i][m]指第i组内的第m个物品的价值
            通过3层for循环滚动求出dp[i][j]的正确转移值,就是第i组要选择的物品
        3.初始化:
            3.1 dp[i][0]=0->容量为0的情况
            3.2 dp[0][j]=preSum(piles[0][j])->只考虑第0组物品
        4.遍历顺序:显然是正序遍历
        5.返回形式:返回dp[pilesNum-1][k]
        时间复杂度:O(N*K*M),空间复杂度:O(N*K)
        */
        // 组数
        int pilesNum = piles.size();
        int[][] dp = new int[pilesNum][k + 1];
        // 初始化
        for(int j = 1; j <= piles.get(0).size() && j <= k; j++) {
            dp[0][j] = dp[0][j - 1] + piles.get(0).get(j - 1);
        }
        // 遍历每一组物品i∈[1,pilesNum-1]
        for(int i = 1; i <= pilesNum - 1; i++) {
            // 遍历每种背包容量j∈[1,k]
            for(int j = 1; j <= k; j++) {
                int sum = 0;
                // 遍历第i组的每件物品m∈[0,piles.get(i).size()]
                // 其中m=0代表不选第i组任何物品,此时sum=0,自动继承dp[i-1][j]
                // m=piles.get(i).size()表示这个组别的数字全拿了
                for(int m = 0; m <= piles.get(i).size(); m++) {
                    // 计算出第k组物品的第m个物品的价值
                    // 从m=1开始计算,因为m=0相当于不选第i组任何物品,sum=0,dp[i][j]继承自dp[i-1][j]
                    if(m >= 1) sum += piles.get(i).get(m - 1);
                    // 若当前背包容量还装得下第k组物品的第m个物品(体积为m)->滚动获取最大值
                    // 拿之前的or拿现在的->取大的值
                    if(j >= m) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - m] + sum);
                }
            }
        }
        // 最后返回的是:考虑[0,pilesNum-1]中,背包容量为k的价值最大值(和的最大值)
        return dp[pilesNum - 1][k];
    }
}
