package com.company;

import java.util.*;

public class ShipWithinDays {

    public static void main(String[] args) {
        // int[] arr = {5,2,3};
        // int target = 10;

        System.out.println("Hello Worlds");
    }

    public int shipWithinDays(int[] weights, int D) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        for (int num : weights) {
            if (num > left) {
                left = num;
            }
            right += num;
        }
        // 左边界是单盒子最大值 右边界是所有的和

        // 查找一下用哪个
        while (left < right) {
            int mid = (left + right) / 2;
            int need = 1;
            int size = 0;
            // 贪心算法按顺序放入盒子,当大于 拿出来放第二天
            for (int num : weights) {
                if (size + num > mid) {
                    need++;
                    size = 0;
                }
                size += num;
            }
            if(need <= D){
                //比较原计划省时间 可以缩小
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}
