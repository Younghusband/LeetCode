package com.practice.xiaorong;

/**
 * 本题相当于二分查找的变种
 */
public class No35 {

    public static void main(String args[]){
        int[] nums = {1, 2, 3};
        System.out.println(searchInsert(nums, 1));
    }
    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int left = 0;
        int right = length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            // 找到的情况下，直接返回下标
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
                if (left >= length || target < nums[left]) {
                    return left;
                }
            } else {
                right = mid - 1;
                if (right < 0 || target > nums[right]) {
                    return right + 1;
                }
            }
        }
        return left;
    }
}
