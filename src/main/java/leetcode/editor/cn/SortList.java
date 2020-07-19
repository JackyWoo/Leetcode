package leetcode.editor.cn;

//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表 
// 👍 610 👎 0

import leecode.ListNode;

/**
 * LC 148
 * Created by wujianchao
 */
public class SortList{
    
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
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
    //归并排序，递归方式
    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null)return head;

        //切分
        ListNode slow, fast;
        slow = head;
        fast = slow.next;
        for(;fast != null && fast.next != null;){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;

        //解决
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        // merge
        ListNode h = new ListNode(0);

        ListNode cursor = h;

        for(;left != null && right != null;){
            if(left.val < right.val){
                cursor.next = left;
                left = left.next;
            }else{
                cursor.next = right;
                right = right.next;
            }
            cursor = cursor.next;
        }

        if(left != null){
            cursor.next=left;
        }
        if(right != null){
            cursor.next=right;
        }

        return h.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}

