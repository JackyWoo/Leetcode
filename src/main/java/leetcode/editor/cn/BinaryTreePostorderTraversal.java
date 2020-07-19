package leetcode.editor.cn;

//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 340 👎 0

import leecode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LC 145
 * Created by wujianchao
 */
public class BinaryTreePostorderTraversal{
    
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
        
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        // next value to added
        TreeNode cursor = root;


        while(cursor != null || !stack.isEmpty()) {

            while (cursor != null) {
                stack.push(cursor);
                cursor = cursor.left;
            }
            cursor = stack.pop();
            TreeNode n = cursor;


            cursor = cursor.right;
            result.add(n.val);
        }
        return  result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}

