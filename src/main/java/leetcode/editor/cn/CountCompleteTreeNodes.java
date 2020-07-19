package leetcode.editor.cn;

//给出一个完全二叉树，求出该树的节点个数。 
//
// 说明： 
//
// 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为
//第 h 层，则该层包含 1~ 2h 个节点。 
//
// 示例: 
//
// 输入: 
//    1
//   / \
//  2   3
// / \  /
//4  5 6
//
//输出: 6 
// Related Topics 树 二分查找 
// 👍 182 👎 0

import leecode.TreeNode;

/**
 * LC 222
 * Created by wujianchao
 */
public class CountCompleteTreeNodes{
    
    public static void main(String[] args) {
        Solution solution = new CountCompleteTreeNodes().new Solution();
        
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
    public int countNodes(TreeNode root) {
        if(root ==null)return 0;

        int result = 0;
        // exclude root
        int height = height(root);

        // non-leaf count
        result = (int) Math.pow(2, height) -1;

        //calculate leaf count
        int leaf = 0;


        //calculate root to last leaf node path
        boolean [] right = new boolean[height];
        TreeNode cursor = root;
        for(int i=0;i<height;i++){
            right[i] = childSameHeight(cursor);
            if(right[i]){
                cursor=cursor.right;
            }
            cursor = cursor.left;
        }

        for(int i=0;i<height;i++){
            if(right[i]){
                leaf +=Math.pow(2, height-i);
            }
        }
        leaf +=1;

        return result + leaf;

    }

    boolean childSameHeight(TreeNode root) {
        return depth(root.left) - depth(root.right) == 0;
    }

    int depth(TreeNode root){
        if(root == null)return  -1;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    int height(TreeNode node){
        int height=0;
        for(;node.left!=null;){
            height++;
        }
        return height;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    
}

