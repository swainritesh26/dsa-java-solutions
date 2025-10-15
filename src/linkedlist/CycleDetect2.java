package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class CycleDetect2 {

    // 🔹 Brute Force Approach — Using HashSet
    // → Keep track of all visited nodes in a Set.
    // → If we visit the same node again, it means the cycle starts there.
    // → Return that node.
    // → Time: O(N), Space: O(N)
    public Node detectCycle1(Node head) {
        Set<Node> st = new HashSet<>();   // stores node references
        Node temp = head;
        while (temp != null) {
            if (st.contains(temp)) {      // already visited node → start of cycle
                return temp;
            }
            st.add(temp);                 // mark node as visited
            temp = temp.next;
        }
        return null;                      // no cycle
    }

    // 🔹 Optimal Approach — Floyd’s Cycle Detection (Tortoise and Hare)
    // Step 1️⃣: Use two pointers (slow & fast) to detect if a cycle exists.
    // Step 2️⃣: If they meet, move one pointer to head.
    // Step 3️⃣: Move both one step at a time — the point they meet again is the start of the cycle.
    // → Time: O(N), Space: O(1)
    public Node detectCycle(Node head) {
        Node slow = head;
        Node fast = head;

        // Step 1: Detect meeting point inside the loop
        while (fast != null && fast.next != null) {
            slow = slow.next;          // move slow by 1
            fast = fast.next.next;     // move fast by 2
            if (slow == fast) break;   // cycle detected, exit loop
        }

        // If fast reaches null → no cycle
        if (fast == null || fast.next == null)
            return null;

        // Step 2: Move slow to head, keep fast at meeting point
        slow = head;

        // Step 3: Move both pointers 1 step at a time
        // They meet at the starting node of the cycle
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Step 4: Return start of the cycle
        return slow;
    }
}
