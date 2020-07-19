package leetcode.editor.cn;

//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//
//       1
//      / \
//     2   3
//
//输出: 6
// 
//
// 示例 2: 
//
// 输入: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出: 42 
// Related Topics 树 深度优先搜索 
// 👍 575 👎 0

import leecode.TreeNode;
import leecode.TreeUtils;

/**
 * LC 124
 * Created by wujianchao
 */
public class BinaryTreeMaximumPathSum{
    
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
        TreeNode root = TreeUtils.toTree("[-3]");
        solution.maxPathSum(root);
        
    }
    
    //---------------------------------//
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
         maxValue(root);
         return max;
    }

    //节点最大单边值
    int maxValue(TreeNode root){
        if(root == null)
            return 0;
        int left = Math.max(0, maxValue(root.left));
        int right = Math.max(0, maxValue(root.right));

        max = Math.max(max, root.val + left + right);

        return root.val + Math.max(left, right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}

