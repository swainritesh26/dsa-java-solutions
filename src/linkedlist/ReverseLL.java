package linkedlist;

public class ReverseLL {

    // 🔁 Function to reverse a singly linked list
    public Node reverseList(Node head) {
        Node temp = head;   // current node pointer
        Node prev = null;   // previous node (used to reverse link)

        // Traverse the list and reverse links one by one
        while (temp != null) {
            Node next = temp.next; // temporarily store next node
            temp.next = prev;      // reverse the current node’s pointer
            prev = temp;           // move prev one step forward
            temp = next;           // move temp one step forward (original next)
        }

        // After loop, 'prev' points to new head of reversed list
        return prev;
    }
}
