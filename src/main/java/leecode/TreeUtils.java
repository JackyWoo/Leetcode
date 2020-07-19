package leecode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wujianchao on 2020/7/1.
 */
public class TreeUtils {

    static ObjectMapper mapper = new ObjectMapper();

    public static TreeNode toTree(String s) {
        LinkedList<Integer> arr = null;
        try {
            arr = mapper.readValue(s, LinkedList.class);
        } catch (JsonProcessingException e) {
        }

        if(arr.size() == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = newNode(arr.poll());
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode n = queue.poll();
            TreeNode left = newNode(arr.poll());
            TreeNode right = newNode(arr.poll());

            n.left = left;
            n.right = right;

            if(left != null) {
                queue.add(left);
            }
            if(right != null){
                queue.add(right);
            }

        }

        return root;
    }

    private static TreeNode newNode(Integer val) {
        if(val == null) {
            return null;
        }
        return new TreeNode(val);
    }

    public static String toString(TreeNode tree){
        if(tree == null) {
            return "[]";
        }

        LinkedList<Integer> r = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);

        while(!queue.isEmpty()){
            TreeNode n = queue.poll();
            r.add(n==null? null:n.val);
            if(n != null){
                queue.add(n.left);
                queue.add(n.right);
            } else {
                System.out.println("node is null");
            }
        }

        try {
            return mapper.writeValueAsString(r);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {
        String s1 = "[1,2,3,4,5,null,6,null,null,null,null,null,null]";
        TreeNode tree1 = toTree(s1);
        System.out.println(toString(tree1));

        String s2 = "[1,2,3,4,null,null,null,5,null,null,null]";
        TreeNode tree2 = toTree(s2);
        System.out.println(toString(tree2));
    }
}
