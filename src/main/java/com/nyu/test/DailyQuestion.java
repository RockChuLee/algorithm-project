package com.nyu.test;

class DailyQuestion {
    private static int extracted() {
        int n = 1;
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 0x3f;
    }

    public  static int reverseBits(int n) {
        int res = 1;
        while(n!=0){
            res |=  n & 1 ;
            n  = n >> 1;
            res = res<< 1;
        }
        return res >> 1;
    }

    public boolean checkValidString(String s) {
        int valid = 0;
        int star = 0;
        for(int i = 0;i<s.length();i++){
            switch (s.charAt(i)) {
                case '(':
                    valid++;
                    break;
                case '*':
                    star++;
                    break;
                case ')':
                    if (valid > 0) {
                        valid--;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return valid <= star;
    }

    static int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int result = 0;
    static int n = 0;
    static int m = 0;
    static char[][] target;

    public static int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        target = grid;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (target[i][j] == '1') {
                    result++;
                }
                dfs(i, j);
            }
        }
        return result;
    }

    public static void dfs(int i, int j) {
        if (i >= n || j >= m || i < 0 || j < 0 || target[i][j] == '0') {
            return;
        }
        target[i][j] = '0';
        for (int[] dir : dirs) {
            dfs(i + dir[0], j + dir[1]);
        }
    }

    public static void main(String[] args) {
        numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}});
    }

    private static void extracted1() {
        String s = Integer.toBinaryString(54);
        String s1 = new StringBuilder(s).reverse().toString();
        char[] chars = s1.toCharArray();
        int start = -1;
        int end = -1;
        int res = 0;
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1' && !flag) {
                start = i;
                flag = true;
            } else if (chars[i] == '1' && flag) {
                continue;
            }

            if (chars[i] == '0' && flag) {
                end = i;
                flag = false;
            } else if (chars[i] == '0' && !flag) {
                continue;
            }

            if (end != -1 && start != -1 ) {
                if( end - start >= 2){
                    for (int j = start; j < end; j++) {
                        chars[j] = '0';
                    }
                    chars[end] = '1';
                    i = end -1;
                    end = -1;
                    start = -1;
                    res +=1;
                } else {
                    end = -1;
                    start = -1;
                }

            }
        }
        if (start != -1) {
            for (int j = start; j < chars.length; j++) {
                chars[j] = '0';
            }
            res ++;
        }
        System.out.println(res);
    }
}

