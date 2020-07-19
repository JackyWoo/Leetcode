package leecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wujianchao on 2020/7/1.
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }

    /**
     *
     * @return bfs string
     */
    @Override
    public String toString() {
        return bfs();
    }

    @Override
    public boolean equals(Object o) {
        if(o == null)
            return false;
        if(!(o instanceof TreeNode)){
            return false;
        }
        TreeNode n = (TreeNode) o;
        return preOrder(this, n);
    }

    boolean preOrder(TreeNode l, TreeNode r) {
        if(l == null && r == null){
            return true;
        }
        if(l == null || r == null || l.val != r.val) {
            return false;
        }

        boolean left = preOrder(l.left, r.left);
        if(!left){
            return false;
        }
        boolean right = preOrder(l.right, r.right);
        if(!right){
            return false;
        }

        return true;
    }

    private String bfs(){
        TreeNode root = this;
        Queue<TreeNode> queue = new LinkedList<>();
        String result = "";
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                result += "null,";
            } else {
                result += Integer.toString(node.val) ;
                result +=",";
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return result.substring(0, result.length() -1);
    }


    public static void main(String[] args) {
        TreeNode n = TreeUtils.toTree("[1,2,3,4,5,null,6]");
        System.out.println(n.toString());
    }

}
