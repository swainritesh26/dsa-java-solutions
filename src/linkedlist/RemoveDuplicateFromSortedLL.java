package linkedlist;

public class RemoveDuplicateFromSortedLL {
    public Node removeDuplicates(Node head) {
        if(head == null) return null;
        // Your code here
        Node i = head;
        Node j = head;
        while(j != null){
            if(i.val != j.val){
                i.next = j;
                i = j;
            }

            j = j.next;

        }
        i.next =j;
        return head;
    }
}
