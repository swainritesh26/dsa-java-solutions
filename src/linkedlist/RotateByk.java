package linkedlist;

public class RotateByk {

    // ✅ Function to rotate the linked list to the right by k places
    // Example: 1→2→3→4→5, k=2 → 4→5→1→2→3
    public Node rotateRight(Node head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        Node temp = head;
        int n = 1;

        // Count total number of nodes
        while (temp.next != null) {
            temp = temp.next;
            n++;
        }

        // Make the list circular
        temp.next = head;

        // Normalize k if it's greater than length
        k = k % n;
        if (k == 0) {
            temp.next = null; // break circle
            return head;
        }

        // Find the node just before the new head (n - k steps)
        int stepsToNewHead = n - k;
        Node newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        // The node after newTail will be new head
        Node newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
    }
}
