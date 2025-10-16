package linkedlist;

public class InterSectionPoints {
        // ✅ Approach: Using Length Difference
        // Time Complexity: O(m + n)
        // Space Complexity: O(1)
        public Node getIntersectionNode(Node headA, Node headB) {

            // Step 1: Count lengths of both lists
            Node temp1 = headA;
            Node temp2 = headB;
            int cnt1 = 0, cnt2 = 0;

            while (temp1 != null) {
                cnt1++;
                temp1 = temp1.next;
            }
            while (temp2 != null) {
                cnt2++;
                temp2 = temp2.next;
            }

            // Step 2: Reset pointers to heads
            temp1 = headA;
            temp2 = headB;

            // Step 3: Move pointer of longer list ahead by |cnt1 - cnt2| nodes
            if (cnt1 > cnt2) {
                for (int i = 0; i < cnt1 - cnt2; i++) {
                    temp1 = temp1.next;
                }
            } else {
                for (int i = 0; i < cnt2 - cnt1; i++) {
                    temp2 = temp2.next;
                }
            }

            // Step 4: Traverse both lists together until they meet
            // Meeting point means intersection node (same reference)
            while (temp1 != temp2) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }

            // Step 5: Return intersection node (or null if no intersection)
            return temp1;
        }


        // ✅ Alternative Optimal Approach (Two Pointer Traversal)
        // Shorter and cleaner: No need to count lengths
        public Node getIntersectionNode2(Node headA, Node headB) {
            if (headA == null || headB == null) return null;

            Node a = headA;
            Node b = headB;

            // Traverse both lists
            // When one reaches the end, switch to the other list's head
            while (a != b) {
                a = (a == null) ? headB : a.next;
                b = (b == null) ? headA : b.next;
            }

            // When they meet, either it's the intersection node or null (no intersection)
            return a;
        }
}
