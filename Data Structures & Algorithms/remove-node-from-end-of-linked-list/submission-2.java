/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int N = 0; 
        ListNode cur = head;
        while (cur != null) {
            N++;
            cur = cur.next;
        }

        int removeIndex = N - n;

        ListNode dummy = new ListNode(0, head);
        cur = dummy;

        for (int i=0; i<removeIndex; i++) { 
            cur = cur.next;
        }

        cur.next = cur.next.next;

        return dummy.next;
    }
}
