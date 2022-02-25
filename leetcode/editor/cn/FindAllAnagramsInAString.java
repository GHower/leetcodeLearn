//[438]找到字符串中所有字母异位词

//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 104 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 679 👎 0

package editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString{
    public static void main(String[] args){
//        Solution solution = new FindAllAnagramsInAString().new Solution();
        
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 统计字符次数差的方式优化活动窗口
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(),pLen = p.length();
        if(sLen< pLen){
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int[] count = new int[26];
        for(int i=0;i<pLen;i++){
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }
        int differ = 0;
        for (int j = 0; j < 26; j++) {
            if(count[j] != 0){
                ++differ;
            }
        }
        if(differ==0) ans.add(0);
        // 重头戏。滑动窗口移动，并实时维护字符次数差
        for(int i=0;i<sLen-pLen;i++){
            // 因移出字符而相同或不同
            int i2 = count[s.charAt(i) - 'a'];
            if(i2 == 1){
                --differ;
            }else if(i2 == 0){
                ++differ;
            }
            --count[s.charAt(i) - 'a'];
            // 因新入字符而相同或不同
            int i1 = count[s.charAt(i + pLen) - 'a'];
            if(i1 == -1){
                --differ;
            }else if(i1 == 0){
                ++differ;
            }
            ++count[s.charAt(i+pLen) - 'a'];
            // 仍然可以是0
            if(differ==0){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
