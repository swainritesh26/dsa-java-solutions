package linkedlist;

import java.util.Stack;

public class LLPalindrome {

    // 🧩 Approach 1 — Using Stack (Brute Force)
    public boolean isPalindrome1(Node head) {
        Stack<Integer> st = new Stack<>();
        Node temp = head;

        // Step 1️⃣ — Push all node values into the stack
        while (temp != null) {
            st.push(temp.val);
            temp = temp.next;
        }

        // Step 2️⃣ — Compare values while popping from the stack
        temp = head;
        while (temp != null) {
            // If mismatch found, not palindrome
            if (temp.val != st.pop()) return false;
            temp = temp.next;
        }

        // If traversed completely → it's a palindrome
        return true;
    }

    // 🧩 Approach 2 — Optimal (O(n), O(1))
    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Step 1️⃣ — Find middle using slow & fast pointer
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2️⃣ — Reverse 2nd half of the list
        Node rev = reverse(slow.next);
        slow.next = null; // Split the list into two halves

        // Step 3️⃣ — Compare first half & reversed second half
        Node first = head;
        while (rev != null) {
            if (first.val != rev.val) return false;
            first = first.next;
            rev = rev.next;
        }

        // Step 4️⃣ — All matched → palindrome
        return true;
    }

    // 🔁 Helper function to reverse linked list
    public Node reverse(Node head) {
        Node prev = null;
        Node temp = head;
        while (temp != null) {
            Node next = temp.next; // Save next node
            temp.next = prev;      // Reverse current link
            prev = temp;           // Move prev forward
            temp = next;           // Move temp forward
        }
        return prev;
    }
}
