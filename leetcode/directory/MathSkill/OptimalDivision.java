//[553]最优除法

//给定一组正整数，相邻的整数之间将会进行浮点除法操作。例如， [2,3,4] -> 2 / 3 / 4 。 
//
// 但是，你可以在任意位置添加任意数目的括号，来改变算数的优先级。你需要找出怎么添加括号，才能得到最大的结果，并且返回相应的字符串格式的表达式。你的表达式不应
//该含有冗余的括号。 
//
// 示例： 
//
// 
//输入: [1000,100,10,2]
//输出: "1000/(100/10/2)"
//解释:
//1000/(100/10/2) = 1000/((100/10)/2) = 200
//但是，以下加粗的括号 "1000/((100/10)/2)" 是冗余的，
//因为他们并不影响操作的优先级，所以你需要返回 "1000/(100/10/2)"。
//
//其他用例:
//1000/(100/10)/2 = 50
//1000/(100/(10/2)) = 50
//1000/100/10/2 = 0.5
//1000/100/(10/2) = 2
// 
//
// 说明: 
//
// 
// 输入数组的长度在 [1, 10] 之间。 
// 数组中每个元素的大小都在 [2, 1000] 之间。 
// 每个测试用例只有一个最优除法解。 
// 
// Related Topics 数组 数学 动态规划 
// 👍 166 👎 0

package directory.MathSkill;

public class OptimalDivision {
    public static void main(String[] args) {
//        Solution solution = new OptimalDivision().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String optimalDivision(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return String.valueOf(nums[0]);
            }
            if (n==2){
                return String.valueOf(nums[0] + "/" + nums[1]);
            }
            StringBuffer res = new StringBuffer();
            res.append(nums[0]);
            res.append("/(");
            res.append(nums[1]);
            for (int i = 2; i < nums.length; i++) {
                res.append("/");
                res.append(nums[i]);
            }
            res.append(")");
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
