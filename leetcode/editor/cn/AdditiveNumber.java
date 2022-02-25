//[306]累加数

//累加数 是一个字符串，组成它的数字可以形成累加序列。 
//
// 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。 
//
// 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。 
//
// 说明：累加序列里的数 不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。 
//
// 
//
// 示例 1： 
//
// 
//输入："112358"
//输出：true 
//解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
// 
//
// 示例 2： 
//
// 
//输入："199100199"
//输出：true 
//解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199 
//
// 
//
// 提示： 
//
// 
// 1 <= num.length <= 35 
// num 仅由数字（0 - 9）组成 
// 
//
// 
//
// 进阶：你计划如何处理由过大的整数输入导致的溢出? 
// Related Topics 字符串 回溯 
// 👍 273 👎 0

package editor.cn;

import java.awt.font.NumericShaper;

public class AdditiveNumber {
    public static void main(String[] args) {
//        Solution solution = new AdditiveNumber().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAdditiveNumber(String num) {
            int len = num.length();
            for(int secondStart = 1;secondStart < len - 1;++secondStart){
                if (num.charAt(0) == '0' && secondStart != 1) {
                    break;
                }
                for(int secondEnd = secondStart;secondEnd < len - 1;++secondEnd){
                    if(num.charAt(secondStart) == '0' && secondStart != secondEnd){
                        break;
                    }
                    // 验证通过直接返回true
                    if (valid(secondStart,secondEnd,num)) {
                        return true;
                    }
                }
            }
            return false;
        }
        // 验证
        public boolean valid(int secondStart,int secondEnd,String num){
            int len = num.length();
            int firstStart = 0,firstEnd =  secondStart - 1;
            while (secondEnd <= len - 1) {
                // 两数和
                String third = stringAdd(num,firstStart,firstEnd,secondStart,secondEnd);
                int thirdStart = secondEnd +1;
                int thirdEnd = secondEnd + third.length();
                // 累加后溢出的原来的字符串，必然不合法
                if (thirdEnd >= len || !num.substring(thirdStart,thirdEnd + 1).equals(third)) {
                    break;
                }
                // 刚好等于字符串的末尾，说明是合法的累加
                if (thirdEnd == len -1) {
                    return true;
                }
                // 更新两数的位置
                firstStart = secondStart;
                firstEnd = secondEnd;
                secondStart = thirdStart;
                secondEnd = thirdEnd;
            }
            return false;
        }
        // 字符串累加,得到第三个值
        public String stringAdd(String s,int firstStart,int firstEnd,int secondStart,int secondEnd){
            StringBuilder third = new StringBuilder();
            int carry =0,cur = 0;
            while (firstEnd >= firstStart || secondEnd >= secondStart || carry != 0){
                cur = carry;
                if (firstEnd >= firstStart) {
                    cur += s.charAt(firstEnd) - '0';
                    --firstEnd;
                }
                if (secondEnd >= secondStart) {
                    cur += s.charAt(secondEnd) - '0';
                    -- secondEnd;
                }
                carry = cur/10;
                cur %= 10;
                third.append((char) (cur + '0'));
            }
            third.reverse();
            return third.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
