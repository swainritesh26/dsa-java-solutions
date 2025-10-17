package linkedlist;

public class RotateByk {

    public Node rotateRight(Node head, int k) {
        // 🧩 Edge cases
        if (head == null || head.next == null || k == 0) return head;

        Node slow = head;
        Node fast = head;
        Node temp = head;
        int n = 0;

        // ✅ Step 1: Count the total number of nodes
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // ✅ Step 2: Handle case when k >= n
        k = k % n;
        if (k == 0) return head;

        // ✅ Step 3: Move fast pointer k steps ahead
        for (int i = 1; i <= k; i++) {
            fast = fast.next;
        }

        // ✅ Step 4: Move both slow and fast one step each
        // until fast reaches the last node
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // ✅ Step 5: Break and rearrange pointers
        Node newHead = slow.next;  // new head after rotation
        slow.next = null;          // break the link
        fast.next = head;          // connect old tail to old head

        // ✅ Step 6: Return new head
        return newHead;
    }
}
