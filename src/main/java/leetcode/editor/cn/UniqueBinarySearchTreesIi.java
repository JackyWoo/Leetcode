package leetcode.editor.cn;

//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。 
//
// 
//
// 示例： 
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 树 动态规划

import leecode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * LC 95
 * Created by wujianchao
 */
public class UniqueBinarySearchTreesIi{
    
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTreesIi().new Solution();

        List<TreeNode> result = solution.generateTrees(3);
        for(TreeNode n : result){
            System.out.println(n);
        }
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
    public List<TreeNode> generateTrees(int n) {
        return generateTreesR(1, n);
    }

    public List<TreeNode> generateTreesR(int start, int end) {
        if(start == end) {
            List<TreeNode> list = new LinkedList<>();
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> result = new LinkedList<>();
        for(int i=start; i<=end; i++) {

            List<TreeNode> left =new LinkedList<>();
            List<TreeNode> right = new LinkedList<>();

            if(start<=i-1) {
                left = generateTreesR(start, i - 1);
            }
            if(end>=i+1) {
                right = generateTreesR(i + 1, end);
            }

            if(left.size()>0 && right.size()>0) {
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        result.add(root);
                    }
                }
            }else if(left.size()>0){
                for (TreeNode r : left) {
                    TreeNode root = new TreeNode(i);
                    root.left = r;
                    result.add(root);
                }
            }else if(right.size()>0){
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.right = r;
                    result.add(root);
                }
            }else {

            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}

