package linkedlist;

public class OddEvenLinkedList {

    public Node oddEvenList(Node head) {
        // ✅ Base case: if list is empty or has only one node → nothing to rearrange
        if (head == null) return null;

        // 🔹 Initialize pointers
        Node odd = head;          // Points to the current odd node
        Node even = head.next;    // Points to the current even node
        Node evenHead = even;     // Save the start of even list (to attach later)

        // 🔹 Loop until we reach the end of list
        // Condition ensures both even and even.next exist
        while (even != null && even.next != null) {
            // Link odd node to the next odd node
            odd.next = even.next;
            odd = odd.next;           // Move odd pointer forward

            // Link even node to the next even node
            even.next = odd.next;
            even = even.next;         // Move even pointer forward
        }

        // 🔸 Attach even list at the end of the odd list
        odd.next = evenHead;

        // ✅ Return the modified head
        return head;
    }
}
