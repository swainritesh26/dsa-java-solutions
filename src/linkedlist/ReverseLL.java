package linkedlist;

public class ReverseLL {
    public Node reverseList(Node head) {
        Node temp = head;
        Node prev = null;
        while(temp != null){
            Node next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}
