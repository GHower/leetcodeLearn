//[剑指 Offer 38]字符串的排列

//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 
// 👍 519 👎 0

package offer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
        String[] abcs = solution.permutation("abc");
        System.out.println(Arrays.toString(abcs));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 1. 回溯
//        List<String> rec = new ArrayList<>();
//        boolean[] vis;
//        public String[] permutation(String s) {
//            int n = s.length();
//            rec = new ArrayList<String>();
//            vis = new boolean[n];
//            char[] arr = s.toCharArray();
//            Arrays.sort(arr);
//            StringBuffer perm = new StringBuffer();
//            backtrack(arr, 0, n, perm);
//            int size = rec.size();
//            String[] recArr = new String[size];
//            for (int i = 0; i < size; i++) {
//                recArr[i] = rec.get(i);
//            }
//            return recArr;
//        }
//
//        private void backtrack(char[] arr, int i, int n, StringBuffer perm) {
//            if (i == n) {
//                rec.add(perm.toString());
//                return;
//            }
//            for (int j = 0; j < n; j++) {
//                if (vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])) {
//                    continue;
//                }
//                vis[j] = true;
//                perm.append(arr[j]);
//                backtrack(arr, i + 1, n, perm);
//                perm.deleteCharAt(perm.length() - 1);
//                vis[j] = false;
//            }
//        }
        // 2. 寻找下一个序列
        public String[] permutation(String s) {
            List<String> ret = new ArrayList<String>();
            char[] arr = s.toCharArray();
            // 先排序，得到最小序列
            Arrays.sort(arr);
            do {
                ret.add(new String(arr));
                // 获取下一个序列
            } while (nextPermutation(arr));
            // 结果装载
            int size = ret.size();
            String[] retArr = new String[size];
            for (int i = 0; i < size; i++) {
                retArr[i] = ret.get(i);
            }
            return retArr;
        }

        private boolean nextPermutation(char[] arr) {
            // 从后向前的方向找第一个非递增的元素
            int i = arr.length - 2;
            while (i>=0 && arr[i] >= arr[i+1]){
                i--;
            }
            if(i < 0){
                return false;
            }
            // 从后向前的方向找第一个不小于i的元素
            int j = arr.length - 1;
            while(j >= 0 && arr[i] >= arr[j]){
                j--;
            }
            // 交换两个元素
            swap(arr,i,j);
            // 反转从 i+1到末尾的元素，得到新的序列。
            // i是被固定的，此时参与不反转，所以从i+1开始
            reverse(arr,i+1);
            return true;
        }

        private void reverse(char[] arr, int start) {
            int left = start,right = arr.length-1;
            while(left < right){
                swap(arr,left,right);
                left++;
                right--;
            }
        }

        private void swap(char[] arr, int i, int j) {
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
