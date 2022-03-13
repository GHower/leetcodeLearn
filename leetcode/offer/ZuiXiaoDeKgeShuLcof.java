//[剑指 Offer 40]最小的k个数

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 395 👎 0

package offer;

import java.util.Arrays;

public class ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
//        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
//        int[] leastNumbers = solution.getLeastNumbers(new int[]{3,2,1}, 2);
//        System.out.println(Arrays.toString(leastNumbers));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            // 基于快排
            if (k >= arr.length) {
                return arr;
            }
            return quickSort(arr, k, 0, arr.length - 1);
        }

        private int[] quickSort(int[] arr, int k, int l, int r) {
            int left = l, right = r;
            while (left < right) {
                while (left < right && arr[right] >= arr[l]) right--;
                while (left < right && arr[left] <= arr[l]) left++;
                swap(arr, left, right);
            }
            swap(arr, left, l);
            if (left > k) {
                return quickSort(arr, k, l, left - 1);
            }
            if (left < k) {
                return quickSort(arr, k, left + 1, r);
            }
            return Arrays.copyOf(arr, k);
        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
//            arr[i] = arr[i] ^ arr[j];
//            arr[j] = arr[i] ^ arr[j];
//            arr[i] = arr[i] ^ arr[j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
