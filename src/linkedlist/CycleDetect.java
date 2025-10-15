package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class CycleDetect {

    // 🔹 Brute Force Approach: Using HashSet
    // → Store each visited node in a Set.
    // → If a node is already in the set → cycle exists.
    // → Time: O(N), Space: O(N)
    public boolean hasCycle1(Node head) {
        Set<Node> st = new HashSet<>();   // store node references, not values
        Node temp = head;
        while (temp != null) {
            if (st.contains(temp)) {      // if same node seen again → cycle
                return true;
            }
            st.add(temp);
            temp = temp.next;
        }
        return false;                     // reached null → no cycle
    }

    // 🔹 Optimal Approach: Floyd’s Cycle Detection (Tortoise & Hare)
    // → Two pointers: slow moves 1 step, fast moves 2 steps
    // → If they meet → cycle exists
    // → Time: O(N), Space: O(1)
    public boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // move 1 step
            fast = fast.next.next;     // move 2 steps

            if (slow == fast)          // meeting point → cycle detected
                return true;
        }

        return false;                  // no meeting → no cycle
    }
}