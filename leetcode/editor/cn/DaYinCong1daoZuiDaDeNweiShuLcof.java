//[剑指 Offer 17]打印从1到最大的n位数

//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
// Related Topics 数组 数学 
// 👍 201 👎 0

package editor.cn;
public class DaYinCong1daoZuiDaDeNweiShuLcof{
    public static void main(String[] args){
//        Solution solution = new DaYinCong1daoZuiDaDeNweiShuLcof().new Solution();
        
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    StringBuilder res;
    int count =0,n;
    char[] num,loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public int[] printNumbers(int n) {
        // 非大数解法
        int end = (int) (Math.pow(10,n) - 1);
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = i+1;
        }
        return res;


        // 大数解法,全排列
//        this.n = n;
//        res = new StringBuilder(); // 数字字符串集
//        num = new char[n]; // 定义长度为 n 的字符列表
//        dfs(0); // 开启全排列递归
//        res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
//        return res.toString(); // 转化为字符串并返回
    }

    private void dfs(int i) {
        if(i == n){
            res.append(String.valueOf(num)+',');
            return;
        }
        for (char c : loop) {
            num[i] = c;
            dfs(i+1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
