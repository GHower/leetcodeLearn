//[5]最长回文子串
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 4338 👎 0

package editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2) return s;
            // 初始化DP，定义： dp[i][j]表示s[i][j]是否为回文串
            boolean[][] dp = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }

            int maxLen = 1;
            int begin = 0;
            char[] charArray = s.toCharArray();
            // 尝试不同长度回文串
            for (int L = 2; L <= len; L++) {
                // 左边界
                for (int left = 0; left < len; left++) {
                    // 右边界
                    int right = L + left - 1;
                    // 有边界越界
                    if (right >= len) {
                        break;
                    }

                    if (charArray[left] != charArray[right]) {
                        dp[left][right] = false;
                    } else if (right - left < 3) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }

                    if (dp[left][right] && L > maxLen) {
                        maxLen = L;
                        begin = left;
                    }
                }
            }
            return s.substring(begin, begin + maxLen);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
