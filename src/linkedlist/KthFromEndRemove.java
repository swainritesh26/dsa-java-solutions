package linkedlist;

public class KthFromEndRemove {

    // 🧩 Brute Force Approach (Two Pass)
    public Node removeNthFromEnd1(Node head, int n) {
        if (head == null) return null;

        // Step 1: Count total nodes
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        // If we need to remove the head node
        if (n == cnt) {
            head = head.next;
            return head;
        }

        // Step 2: Find the (cnt - n)th node (previous node of target)
        temp = head;
        for (int i = 1; i < cnt - n; i++) {
            temp = temp.next;
        }

        // Step 3: Delete target node
        temp.next = temp.next.next;
        return head;
    }

    // ⚡ Optimal Approach (Single Pass, Two Pointers)
    public Node removeNthFromEnd(Node head, int n) {
        if (head == null) return null;

        Node slow = head;
        Node fast = head;
        Node prev = null;

        // Step 1: Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Step 2: If fast == null → we need to delete head
        if (fast == null) {
            head = head.next;
            return head;
        }

        // Step 3: Move both pointers until fast reaches the end
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        // Step 4: Delete target node
        prev.next = slow.next;
        return head;
    }
}