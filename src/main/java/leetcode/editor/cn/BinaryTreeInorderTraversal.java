package leetcode.editor.cn;

//给定一个二叉树，返回它的中序 遍历。 
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
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表

import leecode.TreeNode;
import leecode.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LC 94
 * Created by wujianchao
 */
public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();

        TreeNode node = TreeUtils.toTree("[1,2,3,4,null,null, null, null,5]");
        List<Integer> result = solution.inorderTraversal(node);
        System.out.println(result);
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
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> r = new ArrayList<Integer>();
//            in_order(root, r);
            stackInOrder(root, r);
            return r;
        }

        private void in_order(TreeNode root, List<Integer> r) {
            if(root == null) return;
            in_order(root.left, r);
            r.add(root.val);
            in_order(root.right, r);
        }

        private List<Integer> stackInOrder(TreeNode root,List<Integer> result) {

            Stack<TreeNode > stack = new Stack<>();
            //栈针：表示下一个该加入到stack的值
            TreeNode curr = root;

            while (curr != null || !stack.isEmpty()) {

                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                result.add(curr.val);
                curr = curr.right;
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}

