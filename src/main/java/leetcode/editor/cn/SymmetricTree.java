package leetcode.editor.cn;

//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 885 👎 0

import leecode.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * LC 101
 * Created by wujianchao
 */
public class SymmetricTree{
    
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
        
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
    public boolean isSymmetric(TreeNode root) {

        if(root == null) return true;
        return isSymmetric(root.left, root.right);

    }

    private  boolean isSymmetric(TreeNode a, TreeNode b) {
        if(a == null && b == null)
            return true;
        if(a!=null && b==null || a==null &&b!=null)
            return false;
        //调换左右子树
        return a.val==b.val && isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}

