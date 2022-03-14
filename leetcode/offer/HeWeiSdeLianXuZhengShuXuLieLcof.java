//[剑指 Offer 57 - II]和为s的连续正数序列

//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// Related Topics 数学 双指针 枚举 
// 👍 392 👎 0

package offer;

import java.util.ArrayList;
import java.util.List;

public class HeWeiSdeLianXuZhengShuXuLieLcof {
    public static void main(String[] args) {
//        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {
            int left = 1, right = 2, s = 3;
            List<int[]> list = new ArrayList<>();
            while (left < right) {
                if (s == target) {
                    int[] ans = new int[right - left + 1];
                    for (int i = left; i <= right; i++)
                        ans[i - left] = i;
                    list.add(ans);
                }
                if (s >= target) {
                    s -= left;
                    left++;
                } else {
                    right++;
                    s += right;
                }
            }
            return list.toArray(new int[0][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
