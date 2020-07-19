package leetcode.editor.cn;

//二叉搜索树中的两个节点被错误地交换。 
//
// 请在不改变其结构的情况下，恢复这棵树。 
//
// 示例 1: 
//
// 输入: [1,3,null,null,2]
//
//   1
//  /
// 3
//  \
//   2
//
//输出: [3,1,null,null,2]
//
//   3
//  /
// 1
//  \
//   2
// 
//
// 示例 2: 
//
// 输入: [3,1,4,null,null,2]
//
//  3
// / \
//1   4
//   /
//  2
//
//输出: [2,1,4,null,null,3]
//
//  2
// / \
//1   4
//   /
//  3 
//
// 进阶: 
//
// 
// 使用 O(n) 空间复杂度的解法很容易实现。 
// 你能想出一个只使用常数空间的解决方案吗？ 
// 
// Related Topics 树 深度优先搜索

import leecode.TreeNode;

/**
 * Created by wujianchao
 */
public class RecoverBinarySearchTree{
    
    public static void main(String[] args) {
        Solution solution = new RecoverBinarySearchTree().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    TreeNode x = null;
    TreeNode y = null;
    TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        in_order(root);
    }

    //第一个节点,是第一个按照中序遍历时候前一个节点大于后一个节点,我们选取前一个节点,这里指节点4;
    //第二个节点,是在第一个节点找到之后, 后面出现前一个节点大于后一个节点,我们选择后一个节点,这里指节点1;
    private void in_order(TreeNode root) {
        if(root == null) return;
        in_order(root.left);

        if(pre != null){
            if(root.val < pre.val){
                x = pre;
            }
            //已经找到第一个节点
            if(x != null){

            }


        }
        pre = root;

        in_order(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
