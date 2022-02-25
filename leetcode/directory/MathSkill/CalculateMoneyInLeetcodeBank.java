//[1716]计算力扣银行的钱

//Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。 
//
// 最开始，他在周一的时候存入 1 块钱。从周二到周日，他每天都比前一天多存入 1 块钱。在接下来每一个周一，他都会比 前一个周一 多存入 1 块钱。 
//
// 给你 n ，请你返回在第 n 天结束的时候他在力扣银行总共存了多少块钱。 
//
// 
//
// 示例 1： 
//
// 输入：n = 4
//输出：10
//解释：第 4 天后，总额为 1 + 2 + 3 + 4 = 10 。
// 
//
// 示例 2： 
//
// 输入：n = 10
//输出：37
//解释：第 10 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37 。注意到第二个星期一，Hercy
// 存入 2 块钱。
// 
//
// 示例 3： 
//
// 输入：n = 20
//输出：96
//解释：第 20 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 
//+ 4 + 5 + 6 + 7 + 8) = 96 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 
// Related Topics 数学 
// 👍 48 👎 0

package directory.MathSkill;
public class CalculateMoneyInLeetcodeBank{
    public static void main(String[] args){
        Solution solution = new CalculateMoneyInLeetcodeBank().new Solution();
        System.out.println(solution.totalMoney(20));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalMoney(int n) {
        int y = n % 7;
        int weekNum = n/7;
        int res = countNum(28,7,weekNum);
        res += countNum(y == 0 ? 0 :weekNum+1,1,y);
        return  res;
    }
    public int countNum(int a1,int d,int n){ 
        return (n * a1 + n * ((n-1)*d)/2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
