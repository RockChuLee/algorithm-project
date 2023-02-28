# 题目总结
https://leetcode.cn/contest/weekly-contest-334/

[1.](LeftandRightSumDifferences.java) 
前缀和

[2.](FindtheDivisibilityArrayofaString.java)
模运算的性质

[3.](FindtheMaximumNumberofMarkedIndices.java) 
贪心(双指针)/二分

[4.](MinimumTimetoVisitaCellInaGrid.java) 
dijkstra / 二分 + BFS

# 反思
1. 模运算的性质

设 a=k1*m+r1,b=k2*m+r2

那么 (a+b) mod m= (r1+r2) mod m = (a mod + b mod m) mod m。
2. 如果结果具有单调性，那么就可以使用二分
3. 向上取整

n%2==0?n/2:n/2+1 <=> (n+1)/2 

向下取整

n>>>1 <=> n/2

5. 二分 找中间值 int mid = left + ( right - left)/2; = int mid = (left +  right ) >>> 1;

