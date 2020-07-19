package algo;

/**
 * 合并两个有序链表，要求不能有额外的空间消耗
 *
 * Created by wujianchao on 2020/7/2.
 */
public class MergeTwoOrderedLinkedList {

    static class Node {
        int val;
        Node right;
        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Node l1 = new Node(1);
        l1.right = new Node(4);
        l1.right.right = new Node(6);

        Node l2 = new Node(1);
        l2.right = new Node(3);
        l2.right.right = new Node(5);

        Node n = new MergeTwoOrderedLinkedList().merge(l1, l2);

        while(n != null) {
            System.out.println(n.val);
            n = n.right;
        }
    }


    public Node merge(Node l1, Node l2) {
        Node c1 = l1;
        Node c2 = l2;

        Node pre = null;

        Node tmp = null;

        while(c1 != null && c2 != null) {

            if(c1.val<=c2.val){
                tmp = c1;
                c1 = c1.right;
            } else {
                tmp = c2;
                c2 = c2.right;
            }
            if(pre != null){
                pre.right = tmp;
            }
            pre = tmp;
        }
        
        pre.right=(c1 != null ? c1 : c2);
        return l1.val <= l2.val? l1 : l2;

    }
}
