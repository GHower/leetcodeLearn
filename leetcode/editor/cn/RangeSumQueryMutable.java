//[307]区域和检索 - 数组可修改

//给你一个数组 nums ，请你完成两类查询。 
//
// 
// 其中一类查询要求 更新 数组 nums 下标对应的值 
// 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right 
// 
//
// 实现 NumArray 类： 
//
// 
// NumArray(int[] nums) 用整数数组 nums 初始化对象 
// void update(int index, int val) 将 nums[index] 的值 更新 为 val 
// int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元
//素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]） 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["NumArray", "sumRange", "update", "sumRange"]
//[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
//输出：
//[null, 9, null, 8]
//
//解释：
//NumArray numArray = new NumArray([1, 3, 5]);
//numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
//numArray.update(1, 2);   // nums = [1,2,5]
//numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -100 <= nums[i] <= 100 
// 0 <= index < nums.length 
// -100 <= val <= 100 
// 0 <= left <= right < nums.length 
// 调用 update 和 sumRange 方法次数不大于 3 * 104 
// 
// Related Topics 设计 树状数组 线段树 数组 
// 👍 454 👎 0

package editor.cn;

public class RangeSumQueryMutable {
    public static void main(String[] args) {
//        Solution solution = new RangeSumQueryMutable().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        // 线段树
        private int[] segmentTree;
        private int n;

        public NumArray(int[] nums) {
            n = nums.length;
            segmentTree = new int[nums.length * 4];

            build(0, 0, n - 1, nums);
        }

        // 构建总和 线段树
        private void build(int node, int left, int right, int[] nums) {
            // 叶子节点
            if (left == right) {
                segmentTree[node] = nums[left];
                return;
            }
            int m = left + (right - left) / 2;
            // 左线段
            build(node * 2 + 1, left, m, nums);
            // 右线段
            build(node * 2 + 2, m + 1, right, nums);
            // 当前阶段线段 为 左右子节点的线段和
            segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
        }

        public void update(int index, int val) {
            change(index, val, 0, 0, n - 1);
        }

        // 修改线段树内的节点，需要更新影响的线段，
        // 这是牺牲了修改效率换取了查询效率
        private void change(int index, int val, int node, int left, int right) {
            // 需要修改的节点
            if (left == right) {
                segmentTree[node] = val;
                return;
            }
            int m = left + (right - left) / 2;

            if (index <= m) {
                // 左线段
                change(index, val, node * 2 + 1, left, m);
            } else {
                // 右线段
                change(index, val, node * 2 + 2, m+1, right);
            }
            segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
        }

        public int sumRange(int left, int right) {
            // 1. 线段查询的范围可能只占用划分线段的一部分
            return range(left, right, 0, 0, n - 1);
        }

        private int range(int left, int right, int node, int l, int r) {
            if (left == l && right == r) {
                return segmentTree[node];
            }
            int m = l + (r - l) / 2;

            if (right <= m) {
                // 收缩右侧子树的线段,因为查找范围根本不涉及那部分
                return range(left, right, node * 2 + 1, l, m);
            } else if (left > m) {
                // 同理收左侧
                return range(left, right, node * 2 + 2, m + 1, r);
            } else {
                // 开始缩查找范围，通过极小的线段累加得到最终结果
                // 每个极小线段从第一个if返回
                return range(left, m, node * 2 + 1, l, m) + range(m+1, right, node * 2 + 2, m + 1, r);
            }
        }

    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
