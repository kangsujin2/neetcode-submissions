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
        if (removeIndex == 0) return head.next;

        
        cur = head;
        for (int i=0; i<removeIndex-1; i++) { 
            cur = cur.next;
        }

        if (cur.next != null) {
            cur.next = cur.next.next;
        }
        return head;
    }
}
