package linkedlist;

public class DeleteMiddleNode {

    // 🔹 Brute Force Approach
    // Step 1️⃣: Count total number of nodes.
    // Step 2️⃣: Traverse again to reach (count/2)-th node.
    // Step 3️⃣: Remove the middle node by linking previous node to next of middle.
    // → Time: O(2N), Space: O(1)
    public Node deleteMiddle1(Node head) {
        if (head == null || head.next == null) return null;

        // Step 1: Count nodes
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        // Step 2: Find middle node index
        int mid = cnt / 2;

        // Step 3: Traverse till node before middle
        temp = head;
        for (int i = 0; i < mid - 1; i++) {
            temp = temp.next;
        }

        // Step 4: Delete the middle node
        temp.next = temp.next.next;

        return head;
    }

    // 🔹 Optimal Approach (Floyd’s 2-pointer)
    // → Use slow and fast pointers:
    //     - slow moves 1 step, fast moves 2 steps.
    //     - when fast reaches end, slow points to middle.
    // → Keep a "prev" pointer to link around the middle node.
    // → Time: O(N), Space: O(1)
    public Node deleteMiddle(Node head) {
        // Base case: empty or single node
        if (head == null || head.next == null) return null;

        // Base case: only two nodes — delete first (as middle)
        if (head.next.next == null) {
            head = head.next;
            return head;
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        // Move fast by 2 and slow by 1
        while (fast != null && fast.next != null) {
            prev = slow;           // keep track of node before slow
            slow = slow.next;
            fast = fast.next.next;
        }

        // Slow now points to middle node → delete it
        prev.next = slow.next;

        return head;
    }
}
