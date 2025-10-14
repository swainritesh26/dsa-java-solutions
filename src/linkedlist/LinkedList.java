package linkedlist;

// 🔹 Node class — represents one element in the Linked List
class Node {
    int val;       // stores data
    Node next;     // reference to next node

    Node(int val) {
        this.val = val;
    }
}

// 🔹 LinkedListOperations — performs operations on singly linked list
class LinkedListOperations {
    Node head;     // points to first node
    Node tail;     // points to last node
    int size;      // keeps count of total nodes

    // 🔸 Add node at end
    void addAtEnd(int val) {
        Node temp = new Node(val);
        if (head == null) {           // if list is empty
            head = tail = temp;
        } else {
            tail.next = temp;         // link new node after tail
            tail = temp;              // update tail
        }
        size++;
    }

    // 🔸 Print all elements of linked list
    void print() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // 🔸 Add node at front
    void addAtFront(int val) {
        Node temp = new Node(val);
        if (head == null) {
            head = tail = temp;       // if list empty
        } else {
            temp.next = head;         // link new node before head
            head = temp;              // update head
        }
        size++;
    }

    // 🔸 Delete node from front
    void deleteAtFront() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        head = head.next;             // move head to next node
        size--;
        if (head == null) tail = null; // if list becomes empty
    }

    // 🔸 Delete node from end
    void deleteAtEnd() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        if (head.next == null) {      // only one element
            head = tail = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) { // reach 2nd last node
                temp = temp.next;
            }
            temp.next = null;         // remove last node
            tail = temp;              // update tail
        }
        size--;
    }

    // 🔸 Search if a value exists
    boolean search(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.val == value) return true;
            temp = temp.next;
        }
        return false;
    }

    // 🔸 Insert node at given position (0-based index)
    void insertAtPosition(int val, int pos) {
        if (pos < 0 || pos > size) {
            System.out.println("Invalid Input");
            return;
        }
        if (pos == 0) addAtFront(val);       // insert at front
        else if (pos == size) addAtEnd(val); // insert at end
        else {
            Node temp = head;
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
            }
            Node ele = new Node(val);
            ele.next = temp.next;   // link new node to next node
            temp.next = ele;        // link prev node to new node
            size++;
        }
    }

    // 🔸 Get value at a given position
    int get(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Invalid Input");
            return -1;
        }
        Node temp = head;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    // 🔸 Delete node at given position
    void delete(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Invalid Input");
            return;
        }
        if (pos == 0) deleteAtFront();          // delete first
        else if (pos == size - 1) deleteAtEnd();// delete last
        else {
            Node temp = head;
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;         // unlink node
            size--;
        }
    }
}

// 🔹 Main class — testing linked list operations
public class LinkedList {
    public static void main(String[] args) {
        LinkedListOperations ll = new LinkedListOperations();

        ll.addAtEnd(10);
        ll.addAtEnd(20);
        ll.addAtFront(30);
        ll.addAtFront(40);
        ll.print(); // 40 30 10 20

        System.out.println("Size: " + ll.size);

        ll.insertAtPosition(50, 2); // insert 50 at pos 2
        ll.print(); // 40 30 50 10 20

        System.out.println("Search 20: " + ll.search(20));
        System.out.println("Get(2): " + ll.get(2));

        ll.delete(3); // delete element at pos 3
        ll.print(); // 40 30 50 20

        System.out.println("Size: " + ll.size);
    }
}
