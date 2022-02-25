//[539]最小时间差

//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints <= 2 * 104 
// timePoints[i] 格式为 "HH:MM" 
// 
// Related Topics 数组 数学 字符串 排序 
// 👍 145 👎 0

package directory.SortSkill;

import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference{
    public static void main(String[] args){
//        Solution solution = new MinimumTimeDifference().new Solution();
        
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinDifference(List<String> timePoints) {
        return sortSolution(timePoints);
    }
    public int sortSolution(List<String> timePoints){
        int size = timePoints.size();
        if(size > 1440){
            return 0;
        }
        Collections.sort(timePoints);

        int ans = Integer.MAX_VALUE;
        int t0 = getMinutes(timePoints.get(0));
        int pre = t0;
        for (int i = 1; i < size; i++) {
            int minutes = getMinutes(timePoints.get(i));
            ans = Math.min(ans,minutes - pre);
            pre = minutes;
        }
        ans = Math.min(ans, t0 + 1440 - pre);
        return ans;
    }
    // 返回分钟
    public int getMinutes(String t){
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) -'0') * 10 + (t.charAt(4) - '0');
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
