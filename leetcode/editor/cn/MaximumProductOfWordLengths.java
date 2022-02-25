//给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，
// 并且这两个单词不含有公共字母。你可以认为
//每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
//输出: 16 
//解释: 这两个单词为 "abcw", "xtfn"。 
//
// 示例 2: 
//
// 
//输入: ["a","ab","abc","d","cd","bcd","abcd"]
//输出: 4 
//解释: 这两个单词为 "ab", "cd"。 
//
// 示例 3: 
//
// 
//输入: ["a","aa","aaa","aaaa"]
//输出: 0 
//解释: 不存在这样的两个单词。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= words.length <= 1000 
// 1 <= words[i].length <= 1000 
// words[i] 仅包含小写字母 
// 
// Related Topics 位运算 数组 字符串 
// 👍 248 👎 0

//[318]最大单词长度乘积
package editor.cn;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class MaximumProductOfWordLengths{
    public static void main(String[] args){
        Solution solution = new MaximumProductOfWordLengths().new Solution();
        
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 建立掩码数组，[z...a]分别对应一个二进制位,给每一个字符串建立掩码
    public int maxProduct(String[] words) {
        // 使用map优化, 掩码 - 字符串最大长度
        Map<Integer,Integer> map = new HashMap<>();

        int length = words.length;
        // 优化后可以不用masks
        int[] masks = new int[length];
        // 初始化掩码数组
        for (int i = 0; i < length; i++) {
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                masks[i] |= 1<<(word.charAt(j) - 'a');
            }
            if(wordLength > map.getOrDefault(masks[i],0)){
                map.put(masks[i],wordLength);
            }
        }
        // 若掩码mask[i] 和 mask[j] 的与结果为0，说明没有公共字母
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if((masks[i] & masks[j]) == 0){
                    max = Math.max(max,map.get(masks[i]) * map.get(masks[j]));
                }
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
