//[504]七进制数

//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: num = -7
//输出: "-10"
// 
//
// 
//
// 提示： 
//
// 
// -107 <= num <= 107 
// 
// Related Topics 数学 
// 👍 123 👎 0

package editor.cn;
public class Base7{
    public static void main(String[] args){
        Solution solution = new Base7().new Solution();
        String s = solution.convertToBase7(-5);
        System.out.println(s);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToBase7(int num) {
        if(num==0){
            return "0";
        }
        boolean sign = num<0;
        num = Math.abs(num);
        StringBuffer res = new StringBuffer();
        while(num>0){
            res.append(num % 7);
            num /= 7;
        }
        if(sign){
            res.append("-");
        }
        return res.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
