package leetcode.editor.cn;

//给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。 
//
// 说明： 
//你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 1 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 3 
//
// 进阶： 
//如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？ 
// Related Topics 树 二分查找 
// 👍 236 👎 0

import leecode.TreeNode;

import java.util.Stack;

/**
 * LC 230
 * Created by wujianchao
 */
public class KthSmallestElementInABst{
    
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInABst().new Solution();
        
    }
    
    //---------------------------------//
    
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
    public int kthSmallest(TreeNode root, int k) {
        return dfs(root, k);
    }

    //中序遍历
    private int dfs(TreeNode root, int k){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cursor = root;

        while(cursor !=null || !stack.isEmpty()){
            while(cursor!=null){
                stack.push(cursor);
                cursor = cursor.left;
            }
            //visit last left node
            cursor = stack.pop();
            if(--k==0) {
                return cursor.val;
            }
            cursor =  cursor.right;
        }

        // not found
        return -1;

    }

}
//leetcode submit region end(Prohibit modification and deletion)

    
}

