package linkedlist;

class Node {
    int val;
    Node next;
    Node(int val) {
        this.val = val;
    }
}

class LinkedListOperations {
    Node head;
    Node tail;
    int size;

    void addAtEnd(int val) {
        Node temp = new Node(val);
        if (head == null) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

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

    void addAtFront(int val) {
        Node temp = new Node(val);
        if (head == null) {
            head = tail = temp;
        } else {
            temp.next = head;
            head = temp;
        }
        size++;
    }

    void deleteAtFront() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        head = head.next;
        size--;
        if (head == null) tail = null;
    }

    void deleteAtEnd() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        if (head.next == null) {
            head = tail = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
        size--;
    }

    boolean search(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.val == value) return true;
            temp = temp.next;
        }
        return false;
    }

    void insertAtPosition(int val, int pos) {
        if (pos < 0 || pos > size) {
            System.out.println("Invalid Input");
            return;
        }
        if (pos == 0) addAtFront(val);
        else if (pos == size) addAtEnd(val);
        else {
            Node temp = head;
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
            }
            Node ele = new Node(val);
            ele.next = temp.next;
            temp.next = ele;
            size++;
        }
    }

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

    void delete(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Invalid Input");
            return;
        }
        if (pos == 0) deleteAtFront();
        else if (pos == size - 1) deleteAtEnd();
        else {
            Node temp = head;
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
    }
}

public class LinkedList {
    public static void main(String[] args) {
        LinkedListOperations ll = new LinkedListOperations();
        ll.addAtEnd(10);
        ll.addAtEnd(20);
        ll.addAtFront(30);
        ll.addAtFront(40);
        ll.print();

        System.out.println("Size: " + ll.size);

        ll.insertAtPosition(50, 2);
        ll.print();

        System.out.println("Search 20: " + ll.search(20));
        System.out.println("Get(2): " + ll.get(2));

        ll.delete(3);
        ll.print();

        System.out.println("Size: " + ll.size);
    }
}