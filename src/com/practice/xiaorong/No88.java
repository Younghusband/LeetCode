package com.practice.xiaorong;

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
//说明:
//初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
//你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//其实该题目意思是nums1 空间等于两者 m+n

public class No88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int px = m + n  - 1;
        // p1 , p2 分别指向两个数组有值前提下的最后一个位置
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[px] = nums1[p1];
                p1 --;
            } else {
                nums1[px] = nums2[p2];
                p2 --;
            }
            px --;
        }
        while (p1 >= 0) {
            nums1[px] = nums1[p1];
            p1 --;
            px --;
        }
        while (p2 >= 0) {
            nums1[px] = nums2[p2];
            p2 --;
            px --;
        }
    }
}
