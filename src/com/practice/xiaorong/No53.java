package com.practice.xiaorong;

public class No53 {

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maxSum = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSum = Math.max(currentMax, maxSum);
        }
        return maxSum;
    }
}
