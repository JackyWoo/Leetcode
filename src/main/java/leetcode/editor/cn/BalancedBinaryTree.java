package leetcode.editor.cn;

//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
// Related Topics 树 深度优先搜索

import leecode.TreeNode;
import leecode.TreeUtils;

/**
 * LC 110
 * Created by wujianchao
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
        TreeNode node = TreeUtils.toTree("[1,2,null,4, null]");
        System.out.println(solution.isBalanced(node));
    }

    //---------------------------------//

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
    /**
     * 思路：
     *      1. 左右子树的深度差不超过1
     *      2. 左子树是平衡的并且右子树是平衡的
     */
    class Solution {

        public boolean isBalanced(TreeNode root) {
            return isBalancedR(root);
        }

        public boolean isBalancedR(TreeNode root) {
            if(root == null){
                return true;
            }
            int left = depth(root.left);
            int right = depth(root.right);

            return Math.abs(left - right) <2 & isBalanced(root.left) & isBalanced(root.right);
        }

        private int depth(TreeNode root) {
            if (root == null)
                return 0;
            int left = depth(root.left);
            int right = depth(root.right);

            return Math.max(left, right) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}

