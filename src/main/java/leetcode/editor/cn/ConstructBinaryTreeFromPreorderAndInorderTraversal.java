package leetcode.editor.cn;

//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组

import leecode.TreeNode;

import java.util.HashMap;

/**
 * Created by wujianchao
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
//        solution.buildTree();
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
//TODO work
    class Solution {

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            HashMap<Integer, Integer> rootMapping = new HashMap<Integer, Integer>();
            for (int i = 0; i < preorder.length; i++) {
                rootMapping.put(i, getIndex(inorder, i));
            }
            return buildTree0(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, rootMapping);
        }

        private int getIndex(int[] inorder, int i) {
            for (int j : inorder) {
                if (i == inorder[j])
                    return j;
            }
            throw new IllegalArgumentException("");
        }

        TreeNode buildTree0(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, HashMap<Integer, Integer> rootMapping) {
            //root
            TreeNode root = new TreeNode(preorder[preStart]);

            // left sub tree size
            int leftSubTreeSize = rootMapping.get(preorder[preStart]) - inStart;

            // build left sub tree
            //TODO left sub tree is null
            root.left = buildTree0(preorder,
                    inorder,
                    preStart + 1,
                    preStart + leftSubTreeSize,
                    inStart,
                    rootMapping.get(preorder[preStart]) - 1,
                    rootMapping
            );

            // right sub tree size
            int rightSubTreeSize = inEnd - rootMapping.get(preorder[preStart]);

            // build right sub tree
            //TODO right sub tree is null
            root.right = buildTree0(preorder,
                    inorder,
                    preStart + leftSubTreeSize + 1,
                    preEnd,
                    inEnd - rightSubTreeSize,
                    inEnd,
                    rootMapping
            );
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
