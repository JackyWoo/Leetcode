package leetcode.editor.cn;

//对链表进行插入排序。 
//
// 
//插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。 
//每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。 
//
// 
//
// 插入排序算法： 
//
// 
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。 
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。 
// 重复直到所有输入数据插入完为止。 
// 
//
// 
//
// 示例 1： 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2： 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5
// 
// Related Topics 排序 链表 
// 👍 185 👎 0

import leecode.ListNode;

/**
 * LC 147
 * Created by wujianchao
 */
public class InsertionSortList{
    
    public static void main(String[] args) {
        Solution solution = new InsertionSortList().new Solution();
        ListNode head = new ListNode(4);

        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(3);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;

        solution.insertionSortList(head);
    }
    
    //---------------------------------//
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }


        // add dummy head
        ListNode h = new ListNode(0);
        h.next = head;

        ListNode cur = h.next;
        //最后一个排好序的节点
        ListNode pre = h;

        for(;cur!=null;){
            if(pre == h || pre.val<=cur.val){
                pre = cur;
                cur = cur.next;
                continue;
            }

            // 插入到head -> pre中

            ListNode work = h;

            for(;work !=pre;){
                int v = work.next.val;
                if(cur.val>v){
                    work = work.next;
                    continue;
                }
                //swap and return
                ListNode pos = work;
                ListNode curNext = cur.next;
                work.next = cur;
                cur.next = pos.next;
                cur = curNext;
                pre.next = cur;
                break;
            }

        }

        return h.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}

