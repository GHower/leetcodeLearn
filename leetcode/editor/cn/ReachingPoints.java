//[780]到达终点

//给定四个整数 sx , sy ，tx 和 ty，如果通过一系列的转换可以从起点 (sx, sy) 到达终点 (tx, ty)，则返回 true，否则返回 f
//alse。 
//
// 从点 (x, y) 可以转换到 (x, x+y) 或者 (x+y, y)。 
//
// 
//
// 示例 1: 
//
// 
//输入: sx = 1, sy = 1, tx = 3, ty = 5
//输出: true
//解释:
//可以通过以下一系列转换从起点转换到终点：
//(1, 1) -> (1, 2)
//(1, 2) -> (3, 2)
//(3, 2) -> (3, 5)
// 
//
// 示例 2: 
//
// 
//输入: sx = 1, sy = 1, tx = 2, ty = 2 
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: sx = 1, sy = 1, tx = 1, ty = 1 
//输出: true
// 
//
// 
//
// 提示: 
//
// 
// 1 <= sx, sy, tx, ty <= 109 
// 
// Related Topics 数学 
// 👍 128 👎 0

package editor.cn;

public class ReachingPoints {
    public static void main(String[] args) {
//        Solution solution = new ReachingPoints().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 反向计算
        // tx > ty 则 上一个状态只能是 (tx-ty,ty)
        // tx < ty 则 上个状态只能是 (tx,ty - tx)
        public boolean reachingPoints(int sx, int sy, int tx, int ty) {
            while (tx > sx && ty > sy  && tx != ty){
                if (tx > ty){
                    tx %= ty;
                }else{
                    ty %= tx;
                }
            }
            // 1. 可回起点
            if (sx == tx && ty == sy) return true;
            // 2. x 部分不能再减
            else if (tx == sx){
                return ty > sy && (ty - sy) %tx ==0;
            }
            // 3. y 部分不能再减
            else if(ty == sy){
                return tx > sx && (tx - sx) %ty ==0;
            }
            // 其他情况
            else{
                return false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
