/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node current = head;
        Map<Node, Node> map = new HashMap<>();

        // while (current != null) {
        //     Node copy = new Node(current.val);
        //     map.put(current, copy);
        //     current = current.next;
        // }

        // current = head;
        // while (current != null) {
        //     map.get(current).next = map.get(current.next);
        //     map.get(current).random = map.get(current.random);
        //     current = current.next;
        // }


        while (current != null) {
            Node copy;
            if (map.containsKey(current)) {
                copy = map.get(current);
            } else {
                copy = new Node(current.val);
                map.put(current, copy);
            }

            if (current.next != null && !map.containsKey(current.next)) {
                Node next = new Node(current.next.val);
                map.put(current.next, next);
            }   
            copy.next = map.get(current.next);
            
            if (current.random != null && !map.containsKey(current.random)) {
                Node random = new Node(current.random.val);
                map.put(current.random, random);
            }   
            copy.random = map.get(current.random);

            current = current.next;
        }

        return map.get(head);
    }
}
