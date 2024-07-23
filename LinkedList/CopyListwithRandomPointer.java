class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListwithRandomPointer {

    public static void main(String[] args) {
        int[][] nodes = {{7, -1}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};
        Node head = createList(nodes);
        printList(head);

        Node copiedList = copyRandomList(head);
        printList(copiedList);
    }

    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Clone nodes and place them next to original nodes
        Node temp = head;
        while (temp != null) {
            Node next = temp.next;
            Node clone = new Node(temp.val);
            temp.next = clone;
            clone.next = next;
            temp = next;
        }

        // Step 2: Set the random pointers for the cloned nodes
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // Step 3: Separate the cloned list from the original list
        Node cloneHead = new Node(0);
        Node tempHead = cloneHead;
        temp = head;
        while (temp != null) {
            Node next = temp.next.next;
            Node clone = temp.next;
            tempHead.next = clone;
            tempHead = clone;
            temp.next = next;
            temp = next;
        }
        return cloneHead.next;
    }

    // Helper method to create the list from an array
    public static Node createList(int[][] nodes) {
        if (nodes.length == 0) return null;

        Node[] nodeArray = new Node[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            nodeArray[i] = new Node(nodes[i][0]);
        }
        for (int i = 0; i < nodes.length; i++) {
            if (i < nodes.length - 1) {
                nodeArray[i].next = nodeArray[i + 1];
            }
            if (nodes[i][1] != -1) {
                nodeArray[i].random = nodeArray[nodes[i][1]];
            }
        }
        return nodeArray[0];
    }

    // Helper method to print the list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print("[" + temp.val + ", " + (temp.random != null ? temp.random.val : "null") + "] ");
            temp = temp.next;
        }
        System.out.println();
    }
}
