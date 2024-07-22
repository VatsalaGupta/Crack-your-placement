public class DeleteNodeHavingGreaterValueOnRight {

    // Definition for singly-linked list node.
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node compute(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // Recursively call for the next node
        Node nextNode = compute(head.next);

        // If the current node's value is greater or equal, it is retained
        if (head.data >= nextNode.data) {
            head.next = nextNode;
            return head;
        } else {
            // Otherwise, the current node is skipped
            return nextNode;
        }
    }

    public static void main(String[] args) {
        // Creating the linked list: 12->15->10->11->5->6->2->3
        Node head = new Node(12);
        head.next = new Node(15);
        head.next.next = new Node(10);
        head.next.next.next = new Node(11);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(3);

        System.out.println("Original list:");
        printList(head);

        head = compute(head);

        System.out.println("Modified list:");
        printList(head);
    }

    // Method to print the linked list
    public static void printList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
