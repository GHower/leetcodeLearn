//[剑指 Offer 29]顺时针打印矩阵

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 
// 👍 373 👎 0

package offer;

public class ShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
//        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new int[0];
            }
            int rows = matrix.length, columns = matrix[0].length;

            int idx = 0;
            int[] res = new int[rows * columns];

            // 层级
            int left = 0, right = columns - 1, top = 0, bottom = rows - 1;

            while (left <= right && top <= bottom) {
                for (int column = left; column <= right;column++){
                    res[idx++] = matrix[top][column];
                }
                for (int row = top+1; row <= bottom;row++){
                    res[idx++] = matrix[row][right];
                }
                if(left < right && top < bottom){
                    for (int column = right-1; column > left;column--){
                        res[idx++] = matrix[bottom][column];
                    }
                    for (int row = bottom; row > top;row--){
                        res[idx++] = matrix[row][left];
                    }
                }
                left++;
                right--;
                top++;
                bottom--;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
