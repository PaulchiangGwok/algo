package com.company.old;

//https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/
public class Rotate {

    public static void main(String[] args) {
        // int[] arr = {5,2,3};
        // int target = 10;

        // System.out.println(findBestValue(arr,target));
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // 10 % 6 = 4 // 不需要转10次 4次就可以了

        int count = gcd(k, n);
        for (int start = 0; start < count; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length -1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start += 1;
            end -= 1;
        }
    }
}
