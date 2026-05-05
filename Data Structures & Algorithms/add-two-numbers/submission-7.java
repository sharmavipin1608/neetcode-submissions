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

        while (!(l1 == null && l2 == null)) {
            int l1Val = null == l1 ? 0 : l1.val;
            int l2Val = null == l2 ? 0 : l2.val;
            int current = l1Val + l2Val + carry;
            
            carry = current/10;
            current = current % 10;

            currentNode.next = new ListNode(current);
            
            l1 = null == l1 ? null : l1.next;
            l2 = null == l2 ? null : l2.next;

            currentNode = currentNode.next;
        }   

        // while (l1 != null) {
        //     int current = l1.val + carry;

        //     carry = current >= 10 ? 1 : 0;
        //     current = current % 10;

        //     currentNode.next = new ListNode(current);
            
        //     l1 = l1.next;
        //     currentNode = currentNode.next;
        // } 

        // while (l2 != null) {
        //     int current = l2.val + carry;

        //     carry = current >= 10 ? 1 : 0;
        //     current = current % 10;

        //     currentNode.next = new ListNode(current);
            
        //     l2 = l2.next;
        //     currentNode = currentNode.next;
        // }

        if (carry == 1) {
            currentNode.next = new ListNode(1);
            System.out.println("current : " + 1 + " , carry : " + carry);
        }

        return head.next;
    }
}
