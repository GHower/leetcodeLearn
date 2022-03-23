//[440]字典序的第K小数字

//给定整数 n 和 k，返回 [1, n] 中字典序第 k 小的数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 13, k = 2
//输出: 10
//解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
// 
//
// 示例 2: 
//
// 
//输入: n = 1, k = 1
//输出: 1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= k <= n <= 109 
// 
// Related Topics 字典树 
// 👍 363 👎 0

package directory.Imitate;

public class KThSmallestInLexicographicalOrder {
    public static void main(String[] args) {
//        Solution solution = new KThSmallestInLexicographicalOrder().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 字典树思想的计数模拟
        public int findKthNumber(int n, int k) {

            long p = 1; // 当前计数
            long prefix = 1; // 以prefix为前缀

            while (p < k) {
                long count = getCount(prefix, n);
                if (p + count > k) {
                    // 说明现在这个前缀的数中，有符合条件的，则进入下一个字典序
                    // 1 -> 10 ,11 -> 110
                    prefix *= 10;
                    // 计一次，越过当前数
                    p++;
                } else if (p + count <= k) {
                    // 直接进入下一阶字典序的前缀
                    // 1 -> 2 , 10 -> 11
                    prefix++;
                    // 计count次,越过prefix为前缀的所有数
                    p += count;
                }
            }
            // 以prefix为最小前缀的数就是答案
            return (int) prefix;
        }

        // 获取[prefix,n]范围的个数,由于是字典序的排列，不能简单的n-prefix
        private long getCount(long prefix, int n) {
            long count = 0;
            for (long cur = prefix, next = prefix + 1; cur <= n;  cur *= 10,next *= 10) {
                count += Math.min(next, n + 1) - cur;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
