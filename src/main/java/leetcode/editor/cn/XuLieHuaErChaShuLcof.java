package leetcode.editor.cn;

//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/ 
// Related Topics 树 设计

import leecode.TreeNode;
import leecode.TreeUtils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * LC 剑指 Offer 37
 * Created by wujianchao
 */
public class XuLieHuaErChaShuLcof{
    
    public static void main(String[] args) {
        Codec solution = new XuLieHuaErChaShuLcof().new Codec();

        TreeNode root = TreeUtils.toTree("[1,2,3,4,null,null,null,5,null, null, null]");
        String r = solution.serialize(root);
        System.out.println(r);
        TreeNode root0 = solution.deserialize(r);

        System.out.println(root0.equals(root));
        
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        return serializeR(root);
    }

    private String serializeR(TreeNode root) {
        if(root == null)
            return "null";
        String ret = String.valueOf(root.val);

        String left = serializeR(root.left);
        String right = serializeR(root.right);

        return ret + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())
            return null;

        Integer[] arr = toArray(data);

        return deserializeR(arr, new AtomicInteger(0));
    }

    private Integer[] toArray(String data) {
        String[] arr = data.split(",");
        Integer[] ret = new Integer[arr.length];
        for(int i=0; i< arr.length; i++) {
            String e = arr[i];
            if(e.trim().equals("null")){
                ret[i] = null;
            }else {
                ret[i] = Integer.parseInt(e);
            }
        }
        return  ret;
    }

    private TreeNode deserializeR(Integer[] arr, AtomicInteger i) {
        if(i.get()>= arr.length || arr[i.get()] == null) {
            i.incrementAndGet();
            return null;
        }
        TreeNode node = newNode(arr[i.get()]);
        i.incrementAndGet();
        node.left = deserializeR(arr, i);
        node.right = deserializeR(arr, i);
        return node;
    }

    TreeNode newNode(Integer val) {
        if(val == null) {
            return null;
        }
        return new TreeNode(val);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

    
}

