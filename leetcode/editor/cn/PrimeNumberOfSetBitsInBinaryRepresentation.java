//[762]二进制表示中质数个计算置位

//给你两个整数 left 和 right ，在闭区间 [left, right] 范围内，统计并返回 计算置位位数为质数 的整数个数。 
//
// 计算置位位数 就是二进制表示中 1 的个数。 
//
// 
// 例如， 21 的二进制表示 10101 有 3 个计算置位。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：left = 6, right = 10
//输出：4
//解释：
//6 -> 110 (2 个计算置位，2 是质数)
//7 -> 111 (3 个计算置位，3 是质数)
//9 -> 1001 (2 个计算置位，2 是质数)
//10-> 1010 (2 个计算置位，2 是质数)
//共计 4 个计算置位为质数的数字。
// 
//
// 示例 2： 
//
// 
//输入：left = 10, right = 15
//输出：5
//解释：
//10 -> 1010 (2 个计算置位, 2 是质数)
//11 -> 1011 (3 个计算置位, 3 是质数)
//12 -> 1100 (2 个计算置位, 2 是质数)
//13 -> 1101 (3 个计算置位, 3 是质数)
//14 -> 1110 (3 个计算置位, 3 是质数)
//15 -> 1111 (4 个计算置位, 4 不是质数)
//共计 5 个计算置位为质数的数字。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= left <= right <= 106 
// 0 <= right - left <= 104 
// 
// Related Topics 位运算 数学 
// 👍 98 👎 0

package editor.cn;

import java.util.Arrays;

public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public static void main(String[] args) {
        Solution solution = new PrimeNumberOfSetBitsInBinaryRepresentation().new Solution();
        solution.countPrimeSetBits(6, 10);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 预处理
//        public int countPrimeSetBits(int left, int right) {
//            boolean[] primeNum = new boolean[33];
//            Arrays.fill(primeNum, true);
//            primeNum[1] = false;
//
//            int res = 0;
//            for (int i = 2; i < primeNum.length; i++) {
//                if (primeNum[i]) {
//                    // 倍数
//                    int j = 2;
//                    while (j * i < primeNum.length) {
//                        primeNum[j * i] = false;
//                        j++;
//                    }
//                }
//            }
//            for (int i = left; i <= right; i++) {
//                int num = i;
//                int count = 0;
//                while (num != 0) {
//                    if ((num & 1) == 1) count++;
//                    num = num >> 1;
//                }
//                if (primeNum[count]) {
//                    res++;
//                }
//            }
//            return res;
//    }
        public int countPrimeSetBits(int left, int right) {
            int ans = 0;
            for (int x = left; x <= right; ++x) {
                if (((1 << Integer.bitCount(x)) & 665772) != 0) {
                    ++ans;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
