package com.newcoder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ghower
 * @date 2022/4/8 19:31
 */
public class YueWen1 {
    public static void main(String[] args) {
        YueWen1 yueWen1 = new YueWen1();
//        [4, 3, 2, 3, 2, 3, 2, 1],4
        // 1  2  3  2  3  2  3  4
        // map 0 1 2 3 4
        //
        // 1 2 3 2 0 3 4
        // map 0 1 2 3 4
        //     1 1 2 2 1
        boolean b = yueWen1.canPartitionKSubsets(new int[]{2,2, 3, 2, 3, 2,4, 2, 1}, 4);
        System.out.println(b);
    }
    public boolean canPartitionKSubsets (int[] nums, int k) {
        // write code here
        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        System.out.println("sum="+sum);
        // 不可能均匀分配
        if (sum % k != 0) {
            return false;
        }
        int avg = sum / k;
        System.out.println("avg="+avg);
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            // 有当前值直接超过平均值
            if (num > avg) return false;
            // 自己的+1
            map.put(num,map.getOrDefault(num,0)+1);
            // 需要的-1
            map.put(avg-num,map.getOrDefault(avg-num,0)-1);
        }
        int sum1 = map.values().stream().mapToInt(e -> e).sum();
        System.out.println(map.values());
        return sum1==0;
    }
}
