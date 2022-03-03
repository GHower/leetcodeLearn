//[6]Z 字形变换

//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
// Related Topics 字符串 
// 👍 1561 👎 0

package editor.cn;

import java.security.Principal;
import java.util.Arrays;
import java.util.stream.Stream;

public class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
        solution.convert("PAYPALISHIRING",3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 1. 模拟
//        public String convert(String s, int numRows) {
//            if(numRows == 1) return s;
//
//            StringBuilder[] sb = new StringBuilder[numRows];
//            for (int i = 0; i < numRows; i++) {
//                sb[i] = new StringBuilder();
//            }
//
//            int idx = 0;
//            int row = 0;
//            int len = s.length();
//            while(idx<len){
//                while(idx < len && row < numRows){
//                    char ch = s.charAt(idx++);
//                    sb[row].append(ch);
//                    row++;
//                }
//                if(idx == len){
//                    break;
//                }
//                // 走回上一行
//                row = numRows - 2;
//
//                // 一个周期的向上返回部分
//                while(idx < len && row >= 0 ){
//                    char ch = s.charAt(idx++);
//                    sb[row].append(ch);
//                    row--;
//                }
//                // 走回下一行
//                row +=2;
//            }
//            StringBuffer res = new StringBuffer();
//            Arrays.stream(sb).forEach(e->res.append(e.toString()));
//            return res.toString();
//        }
        // 2. 数学直接构造
        public String convert(String s, int numRows) {
            if(numRows == 1) return s;

            int len = s.length();
            // 一个周期的满字符数
            int cnt = numRows*2 - 2;
            // 周期T
            int t = len / cnt;
            t = len % cnt == 0 ? t: t+1;

            StringBuffer res = new StringBuffer();
            // 第一行
            for (int i = 0; i < t; i++) {
                char c = s.charAt(i*cnt);
                res.append(c);
            }
            // 中间部分
            for (int r = 1; r < numRows-1; r++) {
                // 一行
                for (int i = 0; i < t; i++) {
                    int rc1 = i*cnt + r;
                    if(rc1 < len){
                        res.append(s.charAt(rc1));
                    }

                    int rc2 = (i + 1) * cnt - r;
                    if(rc2 < len){
                        char c2 = s.charAt(rc2);
                        res.append(c2);
                    }
                }
            }
            // 最后一行
            for (int i = 0; i < t; i++) {
                int tail = i*cnt + numRows - 1;
                if(tail < len){
                    char c = s.charAt(tail);
                    res.append(c);
                }
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
