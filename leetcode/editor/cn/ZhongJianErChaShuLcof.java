//[剑指 Offer 07]重建二叉树

//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 696 👎 0

package editor.cn;


import java.util.HashMap;
import java.util.Map;

public class ZhongJianErChaShuLcof {
    public static void main(String[] args) {
//        Solution solution = new ZhongJianErChaShuLcof().new Solution();

    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        private Map<Integer,Integer> idxMap = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            // 构造映射
            for (int i = 0; i < n; i++) {
                idxMap.put(inorder[i],i);
            }
            // 递归成树
            return build(preorder,0,n-1,inorder,0,n-1);
        }

        private TreeNode build(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
            if(preLeft > preRight){
                return null;
            }
            // 前序中的根节点
            // 中序中的根节点
            Integer inRoot = idxMap.get(preorder[preLeft]);
            // 构建根节点
            TreeNode root = new TreeNode(preorder[preLeft]);
            // 计算左子树节点数目
            int leftSize = inRoot - inLeft;
            // 构造左子树
            root.left = build(preorder,preLeft+1,preLeft + leftSize,inorder,inLeft,inRoot-1);
            // 构造右子树
            root.right = build(preorder,preLeft+leftSize+1,preRight,inorder,inRoot+1,inRight);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
