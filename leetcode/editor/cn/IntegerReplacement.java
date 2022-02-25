//[397]整数替换

//给定一个正整数 n ，你可以做如下操作： 
//
// 
// 如果 n 是偶数，则用 n / 2替换 n 。 
// 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。 
// 
//
// n 变为 1 所需的最小替换次数是多少？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 8
//输出：3
//解释：8 -> 4 -> 2 -> 1
// 
//
// 示例 2： 
//
// 
//输入：n = 7
//输出：4
//解释：7 -> 8 -> 4 -> 2 -> 1
//或 7 -> 6 -> 3 -> 2 -> 1
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 贪心 位运算 记忆化搜索 动态规划 
// 👍 120 👎 0

package editor.cn;

import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement {
    public static void main(String[] args) {
        Solution solution = new IntegerReplacement().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //        Map<Integer, Integer> memo = new HashMap<>();
        // 贪心
        public int integerReplacement(int n) {
            int ans = 0;
            while (n != 1) {
                if (n % 2 == 0) {
                    ++ans;
                    n >>= 1;
                    continue;
                } else if (n % 4 == 1) {
                    n >>= 1;
                } else {
                    if (n == 3) {
                        n = 1;
                    } else {
                        n = (n >> 1) + 1;
                    }
                }
                ans += 2;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
//    private int memoDG(int n){
//        if (n == 1) {
//            return 0;
//        }
//        if (!memo.containsKey(n)) {
//            if (n % 2 == 0) {
//                memo.put(n, 1 + integerReplacement(n >> 1));
//            } else {
//                memo.put(n, 2 + Math.min(integerReplacement(n >> 1), integerReplacement((n >> 1) + 1)));
//            }
//        }
//        return memo.get(n);
//    }
}
