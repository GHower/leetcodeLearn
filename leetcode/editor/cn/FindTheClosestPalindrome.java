//[564]寻找最近的回文数

//给定一个表示整数的字符串 n ，返回与它最近的回文整数（不包括自身）。如果不止一个，返回较小的那个。 
//
// “最近的”定义为两个整数差的绝对值最小。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = "123"
//输出: "121"
// 
//
// 示例 2: 
//
// 
//输入: n = "1"
//输出: "0"
//解释: 0 和 2是最近的回文，但我们返回最小的，也就是 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n.length <= 18 
// n 只由数字组成 
// n 不含前导 0 
// n 代表在 [1, 1018 - 1] 范围内的整数 
// 
// Related Topics 数学 字符串 
// 👍 233 👎 0

package editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FindTheClosestPalindrome{
    public static void main(String[] args){
//        Solution solution = new FindTheClosestPalindrome().new Solution();
        
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String nearestPalindromic(String n) {
        long selfNum = Long.parseLong(n),ans = -1;
        List<Long> candidate = getCandidates(n);
        // 筛选最小
        for (Long aLong : candidate) {
            if(aLong != selfNum){
                if(ans == -1 ||
                    Math.abs(aLong - selfNum) < Math.abs(ans - selfNum) ||
                    Math.abs(aLong - selfNum) == Math.abs(ans - selfNum) &&
                    aLong < ans){
                    ans = aLong;
                }
            }
        }
        return Long.toString(ans);
    }

    private List<Long> getCandidates(String n) {
        int len = n.length();
        List<Long> ans = new ArrayList<>();
        ans.add((long) (Math.pow(10,len-1)-1));
        ans.add((long) (Math.pow(10,len)+1));
        long selfPre = Long.parseLong(n.substring(0,(len+1)/2));
        for(long i = selfPre - 1;i<=selfPre+1;i++){
            StringBuffer stringBuffer = new StringBuffer();
            // 前部分
            String prefix = String.valueOf(i);
            stringBuffer.append(prefix);
            // 后部分
            StringBuffer suffix = new StringBuffer(prefix).reverse();
            // 长度为奇数位时，后部分的第一位会重复，去掉
            stringBuffer.append(suffix.substring(len & 1));
            String candidate = stringBuffer.toString();
            ans.add(Long.parseLong(candidate));
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
