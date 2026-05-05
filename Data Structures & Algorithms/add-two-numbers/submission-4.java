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
        int carry = 0;
        ListNode head = new ListNode();
        ListNode currentNode = head;

        System.out.println(l1.val + " - " + l2.val);

        while (l1 != null && l2 != null) {
            int current = l1.val + l2.val + carry;
            System.out.println("current : " + current);
            
            carry = current >= 10 ? 1 : 0;
            current = current % 10;

            currentNode.next = new ListNode(current);
            System.out.println("current : " + current + " , carry : " + carry);

            l1 = l1.next;
            l2 = l2.next;

            currentNode = currentNode.next;
        }   

        while (l1 != null) {
            int current = l1.val + carry;

            carry = current >= 10 ? 1 : 0;
            current = current % 10;

            currentNode.next = new ListNode(current);
            System.out.println("current : " + current + " , carry : " + carry);

            l1 = l1.next;
            currentNode = currentNode.next;
        } 

        while (l2 != null) {
            int current = l2.val + carry;

            carry = current >= 10 ? 1 : 0;
            current = current % 10;

            currentNode.next = new ListNode(current);
            System.out.println("current : " + current + " , carry : " + carry);

            l2 = l2.next;
            currentNode = currentNode.next;
        }

        if (carry == 1) {
            currentNode.next = new ListNode(1);
            System.out.println("current : " + 1 + " , carry : " + carry);
        }

        return head.next;
    }
}
