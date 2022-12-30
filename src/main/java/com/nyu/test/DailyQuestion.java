package com.nyu.test;


public class DailyQuestion {

    public static int trap(int[] height) {
        int[] topOrBottom = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            if ((height[i] >= height[i - 1] && height[i] > height[i + 1]) || (height[i] > height[i - 1] && height[i] >= height[i + 1])) {
                topOrBottom[i] = 1;
            }
            if ((height[i] <= height[i - 1] && height[i] < height[i + 1]) || (height[i] < height[i - 1] && height[i] <= height[i + 1])) {
                topOrBottom[i] = -1;
            }
        }

        int index = 0;
        int ans = 0;
        boolean flag = false;
        while (index < height.length) {
            int firstTop = 0;
            int bottom = 0;
            int secondTop = 0;
            if (topOrBottom[index] == 1) {
                firstTop = index;
                index++;
                while (index < height.length) {
                    if (topOrBottom[index] == -1) {
                        bottom = index;
                        index++;
                        while (index < height.length) {
                            if (topOrBottom[index] == 1) {
                                secondTop = index;
                                flag = true;
                                int top = Math.min(height[firstTop], height[secondTop]);
                                for (int j = firstTop; j <= secondTop; j++) {
                                    if (height[j] < top) {
                                        ans += top - height[j];
                                    }
                                }
                            }
                            if (flag) {
                                break;
                            }
                            index++;
                        }
                    }
                    if (flag) {
                        break;
                    }
                    index++;
                }
            }
            if (flag) {
                flag = false;
                index--;
            }
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        trap(new int[]{4,2,0,3,2,5});
    }
}
