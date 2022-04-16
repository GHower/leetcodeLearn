//[479]最大回文数乘积

//给定一个整数 n ，返回 可表示为两个 n 位整数乘积的 最大回文整数 。因为答案可能非常大，所以返回它对 1337 取余 。 
//
// 
//
// 示例 1: 
//
// 
//输入：n = 2
//输出：987
//解释：99 x 91 = 9009, 9009 % 1337 = 987
// 
//
// 示例 2: 
//
// 
//输入： n = 1
//输出： 9
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 数学 
// 👍 59 👎 0

package editor.cn;
public class LargestPalindromeProduct{
    public static void main(String[] args){
        Solution solution = new LargestPalindromeProduct().new Solution();
        int i = solution.largestPalindrome(2);
        System.out.println(i);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int upper = (int) Math.pow(10, n) - 1;
        int ans = 0;
        for (int left = upper; ans == 0; --left) { // 枚举回文数的左半部分
            long p = left;
            for (int x = left; x > 0; x /= 10) {
                p = p * 10 + x % 10; // 翻转左半部分到其自身末尾，构造回文数 p
            }
            for (long x = upper; x * x >= p; --x) {
                if (p % x == 0) { // x 是 p 的因子
                    ans = (int) (p % 1337);
                    break;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
