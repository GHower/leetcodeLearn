//[954]二倍数对数组

//给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i 
//+ 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,3,6]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：arr = [2,1,2,6]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：arr = [4,-2,2,-4]
//输出：true
//解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= arr.length <= 3 * 104 
// arr.length 是偶数 
// -105 <= arr[i] <= 105 
// 
// Related Topics 贪心 数组 哈希表 排序 
// 👍 118 👎 0

package editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ArrayOfDoubledPairs{
    public static void main(String[] args){
//        Solution solution = new ArrayOfDoubledPairs().new Solution();
        
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    static int N = 100010, M = N * 2;
//    static int[] cnts = new int[M * 2];
//    public boolean canReorderDoubled(int[] arr) {
//        Arrays.fill(cnts, 0);
//        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->Math.abs(a)-Math.abs(b));
//        for (int i : arr) q.add(i);
//        while (!q.isEmpty()) {
//            int x = q.poll(), t = x * 2;
//            if (cnts[x + M] != 0 && --cnts[x + M] >= 0) continue;
//            cnts[t + M]++;
//        }
//        for (int i = 0; i < M * 2; i++) {
//            if (cnts[i] != 0) return false;
//        }
//        return true;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
