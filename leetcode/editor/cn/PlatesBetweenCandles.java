//[2055]蜡烛之间的盘子

//给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|'
// 表示一支 蜡烛 。 
//
// 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[left
//i...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边
// 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。 
//
// 
// 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符
//串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。 
// 
//
// 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。 
//
// 
//
// 示例 1: 
//
// 
//
// 输入：s = "**|**|***|", queries = [[2,5],[5,9]]
//输出：[2,3]
//解释：
//- queries[0] 有两个盘子在蜡烛之间。
//- queries[1] 有三个盘子在蜡烛之间。
// 
//
// 示例 2: 
//
// 
//
// 输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16
//]]
//输出：[9,0,0,0,0]
//解释：
//- queries[0] 有 9 个盘子在蜡烛之间。
//- 另一个查询没有盘子在蜡烛之间。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= s.length <= 105 
// s 只包含字符 '*' 和 '|' 。 
// 1 <= queries.length <= 105 
// queries[i].length == 2 
// 0 <= lefti <= righti < s.length 
// 
// Related Topics 数组 字符串 二分查找 前缀和 
// 👍 23 👎 0

package editor.cn;

public class PlatesBetweenCandles {
    public static void main(String[] args) {
//        Solution solution = new PlatesBetweenCandles().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 1. 暴力，会超时
//        public int[] platesBetweenCandles(String s, int[][] queries) {
//            int[] res = new int[queries.length];
//            for (int n = 0; n< queries.length;n++) {
//                int start = queries[n][0];
//                int end = queries[n][1];
//                int sum = 0;
//                // 前后定位第一个蜡烛
//                while (start < end && s.charAt(start) != '|') {
//                    start++;
//                }
//                while (start < end && s.charAt(end) != '|') {
//                    end--;
//                }
//                while (start < end) {
//                    if(s.charAt(start++) == '*') ++sum;
//                }
//                res[n] = sum;
//            }
//            return res;
//        }
        // 2. 前缀和
        // 预处理数组，只需要用右侧蜡烛前盘子数量 - 左侧蜡烛前盘子数量
        public int[] platesBetweenCandles(String s, int[][] queries) {
            int n = s.length();
            int[] res = new int[queries.length];
            int[] preSum = new int[n];
            for (int i = 0, sum = 0; i < n; i++) {
                if (s.charAt(i) == '*') {
                    ++sum;
                }
                preSum[i] = sum;
            }
            // 对应左侧蜡烛
            int[] left = new int[n];
            for (int i = 0, idx = -1; i < n; i++) {
                if (s.charAt(i) == '|') {
                    idx = i;
                }
                left[i] = idx;
            }
            // 对应右侧蜡烛
            int[] right = new int[n];
            for (int i = n - 1, idx = -1; i >= 0; i--) {
                if (s.charAt(i) == '|') {
                    idx = i;
                }
                right[i] = idx;
            }
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                int l = right[query[0]], r = left[query[1]];
                res[i] = l == -1 || r == -1 || l >= r ? 0 : preSum[r] - preSum[l];
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
