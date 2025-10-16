package linkedlist;

public class SwappingNodeInLL {
    public Node swapNodes(Node head, int k) {
        Node slow = head;
        Node fast = head, curr = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        curr = fast;
        while (curr.next != null) {
            slow = slow.next;
            curr = curr.next;
        }
        int temp = slow.val;
        slow.val = fast.val;
        fast.val = temp;
        return head;
    }

    public Node swapNodes1(Node head, int k) {
        Node slow = head;
        Node fast = head;
        for(int i=1;i<k;i++){
            fast = fast.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        fast = head;
        for(int i=1;i<k;i++){
            fast = fast.next;
        }
        int temp = slow.val;
        slow.val = fast.val;
        fast.val = temp;
        return head;
    }
}
