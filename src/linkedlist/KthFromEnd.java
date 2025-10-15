package linkedlist;

public class KthFromEnd {

    // 🔹 Brute Force Approach
    // Step 1️⃣: Count total nodes.
    // Step 2️⃣: Compute position from start → (n - k + 1).
    // Step 3️⃣: Traverse again to that position.
    // → Time: O(2N), Space: O(1)
    public int getKthFromLast1(Node head, int k) {
        int cnt = 0;
        Node temp = head;

        // Step 1: Count number of nodes
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        // If k is greater than list length, invalid
        if (k > cnt) return -1;

        // Step 2: Find (cnt - k + 1)-th node from start
        int pos = cnt - k + 1;
        temp = head;

        // Step 3: Move to that node
        for (int i = 1; i < pos; i++) {
            temp = temp.next;
        }

        return temp.val;
    }

    // 🔹 Optimal Approach (Two Pointer Technique)
    // → Move fast pointer k steps ahead.
    // → Move both slow and fast one step each until fast reaches end.
    // → Now slow points to the k-th node from end.
    // → Time: O(N), Space: O(1)
    public int getKthFromLast(Node head, int k) {
        Node slow = head;
        Node fast = head;

        // Step 1: Move fast k steps ahead
        for (int i = 1; i <= k; i++) {
            // If list has fewer than k nodes
            if (fast == null) return -1;
            fast = fast.next;
        }

        // Step 2: Move both until fast reaches end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Step 3: Slow now points to k-th node from end
        return slow.val;
    }
}
