package leetcode.editor.cn;

//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 244 👎 0

import leecode.TreeNode;

/**
 * LC 106
 * Created by wujianchao
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal{
    
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        int[] inorder = new int[]{4,2,5,1,6,3,7};
        int[] postorder = new int[] {4,5,2,6,7,3,1};
        TreeNode tree = solution.buildTree(inorder, postorder);
        System.out.println(tree);
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length-1, postorder.length -1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int start, int end, int root) {

        if(start > end){
            return null;
        }

        TreeNode rootNode = new TreeNode(postorder[root]);
        int indexOfRoot = indexOfRoot(inorder, start, end, postorder[root]);
        int leftSize = indexOfRoot - start;
        int rightSize = end - indexOfRoot;
        TreeNode left = buildTree(inorder, postorder, start, indexOfRoot -1, root - rightSize -1);
        TreeNode right = buildTree(inorder, postorder, indexOfRoot +1, end, root-1);
        rootNode.left = left;
        rootNode.right = right;
        return rootNode;
    }

    private int indexOfRoot(int[] inorder, int start, int end, int target) {
        for(int i=start;i<=end;i++){
            if(inorder[i] == target){
                return i;
            }
        }
        System.out.println(start);
        System.out.println(end);
        System.out.println(target);
        throw new IllegalStateException("can not fond root in inorder arr");
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}

