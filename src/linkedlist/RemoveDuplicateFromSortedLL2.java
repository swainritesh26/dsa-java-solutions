package linkedlist;

public class RemoveDuplicateFromSortedLL2 {

    // ✅ Removes ALL duplicates from a sorted linked list
    // Example: 1->2->3->3->4->4->5  →  1->2->5
    // Time: O(N), Space: O(1)
    public Node deleteDuplicates(Node head) {

        // Dummy node to simplify edge cases
        // (like when head itself is part of duplicates)
        Node dummy = new Node(-1);

        Node i = head;   // Pointer to traverse original list
        Node j = dummy;  // Tail of new (cleaned) list

        // Traverse the list
        while (i != null) {

            // Case 1: Single node (no duplicate ahead)
            // OR current node value ≠ next node value
            if (i.next == null || i.val != i.next.val) {
                j.next = i;   // Link this node into result
                j = i;        // Move tail
                i = i.next;   // Move forward
            }

            // Case 2: Current node value == next node value
            // → Skip all nodes with this value
            else {
                Node t = i.next;
                while (t != null && t.val == i.val) {
                    t = t.next; // Move until value changes
                }
                i = t; // Jump over duplicates completely
            }
        }

        // Ensure the new list ends properly
        j.next = i;

        // Return the head of the cleaned list
        return dummy.next;
    }
}