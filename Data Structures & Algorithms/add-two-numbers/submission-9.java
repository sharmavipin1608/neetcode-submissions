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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;

        int carry = 0;
        ListNode head = new ListNode();
        ListNode currentNode = head;

        while (l1 != null || l2 != null || carry != 0) {
            int current = carry;

            if (l1 != null) {
                current += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                current += l2.val;
                l2 = l2.next;
            }
            
            carry = current/10;           
            currentNode.next = new ListNode(current%10);
            currentNode = currentNode.next;
        }   

        return head.next;
    }
}
