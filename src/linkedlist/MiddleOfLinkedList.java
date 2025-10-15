package linkedlist;

// 🔹 Find the middle node of a linked list
public class MiddleOfLinkedList {

    // 🔸 Brute Force Approach: Two-pass method
    public Node middleNode1(Node head) {
        int cnt = 0;
        Node temp = head;

        // 1️⃣ Count total number of nodes
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        // 2️⃣ Traverse again to reach middle node
        temp = head;
        for (int i = 0; i < cnt / 2; i++) {  // go till middle index
            temp = temp.next;
        }

        // 3️⃣ Return the middle node
        return temp;
    }

    // 🔸 Optimal Approach: Fast & Slow Pointer
    public Node middleNode(Node head) {
        Node slow = head; // moves 1 step
        Node fast = head; // moves 2 steps

        // Move fast by 2 and slow by 1 till fast reaches end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // When fast reaches end, slow is at middle
        return slow;
    }
}
