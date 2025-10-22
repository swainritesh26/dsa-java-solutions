package linkedlist;

public class ReverseLL2 {
    public Node reverseBetween(Node head, int left, int right) {
        // 🧩 Create dummy node to simplify edge cases (like reversing from 1st node)
        Node dummy = new Node(-1);
        dummy.next = head;

        // Step 1️⃣ — Move `leftPrev` to node just before the 'left' position
        Node leftPrev = dummy;
        for (int i = 1; i < left; i++) {
            leftPrev = leftPrev.next;
        }

        // Step 2️⃣ — Start reversing from `curr`
        Node curr = leftPrev.next;
        Node prev = null;

        // Step 3️⃣ — Reverse the sublist between [left, right]
        for (int i = 0; i < right - left + 1; i++) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step 4️⃣ — Connect reversed sublist back to main list
        leftPrev.next.next = curr; // Tail of reversed part connects to remaining list
        leftPrev.next = prev;      // Node before sublist connects to new head of reversed part

        // Step 5️⃣ — Return head (dummy.next points to possibly new head)
        return dummy.next;
    }
}
