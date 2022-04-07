//[796]旋转字符串

//给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。 
//
// s 的 旋转操作 就是将 s 最左边的字符移动到最右边。 
//
// 
// 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcde", goal = "cdeab"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abcde", goal = "abced"
//输出: false
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, goal.length <= 100 
// s 和 goal 由小写英文字母组成 
// 
// Related Topics 字符串 字符串匹配 
// 👍 237 👎 0

package editor.cn;

import java.util.Arrays;

public class RotateString {
    public static void main(String[] args) {
        Solution solution = new RotateString().new Solution();
        boolean b = solution.rotateString("abcde", "cdeab");
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean rotateString(String s, String goal) {
            int sLen = s.length();
            int gLen = goal.length();
            if (sLen != gLen) {
                return false;
            }
            // 加倍长度
            s += s;
            // 获取goal 的next数组
            int[] nextArray = getNextArray(goal);
            System.out.println(Arrays.toString(nextArray));
            // 基于next数组做KMP匹配
            return kmpMatch(s,goal,nextArray);
        }
        public int[] getNextArray(String goal){
            int n = goal.length();
            int[] next = new int[n];
            for (int i = 1,j=0; i < n; i++) {
                while (j>0 && goal.charAt(i) != goal.charAt(j)){
                    j = next[j-1];
                }
                if(goal.charAt(j) == goal.charAt(i)){
                    j++;
                }
                next[i] = j;
            }
            return next;
        }
        public boolean kmpMatch(String origin,String nextStr,int[] nextArr){
            for (int i = 0,j=0; i < origin.length(); i++) {
                while (j>0 && origin.charAt(i) != nextStr.charAt(j)){
                    j = nextArr[j-1];
                }
                if(nextStr.charAt(j) == origin.charAt(i)){
                    j++;
                }
                // j只有在完全走完的情况下会走这里
                if (j==nextStr.length()){
                    return true;
                }
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
