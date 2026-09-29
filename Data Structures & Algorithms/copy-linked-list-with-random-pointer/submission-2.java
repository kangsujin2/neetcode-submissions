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
        HashMap<Node, Node> map = new HashMap<>();
        map.put(null, null);

        Node cur = head;
        while (cur != null) {
            if (!map.containsKey(cur)) map.put(cur, new Node(0));
            map.get(cur).val = cur.val;
            
            if (!map.containsKey(cur.next)) map.put(cur.next, new Node(0));
            map.get(cur).next = map.get(cur.next);

            if (!map.containsKey(cur.random)) map.put(cur.random, new Node(0));
            map.get(cur).random = map.get(cur.random);

            cur = cur.next;
        }

        return map.get(head);

    }
}
