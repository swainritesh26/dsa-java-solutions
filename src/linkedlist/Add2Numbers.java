package linkedlist;

public class Add2Numbers {
    public Node addTwoNumbers(Node l1, Node l2) {
        // 🔹 Dummy node to simplify list construction
        Node newNode = new Node(-1);
        Node temp = newNode;

        // 🔹 Variable to store carry (for sums >= 10)
        int carry = 0;

        // 🔹 Loop runs until both lists are exhausted and no carry remains
        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;

            // ➕ Add l1's value if available
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // ➕ Add l2's value if available
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // ➕ Add carry from previous operation
            sum += carry;

            // 🔸 Compute new carry and the digit to store
            carry = sum / 10;
            int digit = sum % 10;

            // 🔸 Create a new node with the computed digit
            Node node = new Node(digit);

            // 🔗 Attach new node to result list
            temp.next = node;
            temp = temp.next;
        }

        // ✅ Return the head of the newly formed list (skip dummy)
        return newNode.next;
    }
}
