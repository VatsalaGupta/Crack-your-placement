public class reverseLinkedList {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { 
            this.val = val; 
        }

        ListNode(int val, ListNode next) { 
            this.val = val; 
            this.next = next; 
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null, curr = head, next = null;
        
        while (curr != null) {
            next = curr.next;  // Save next
            curr.next = prev;  // Reverse current node's pointer
            prev = curr;       // Move pointers one position ahead.
            curr = next;
        }
        
        return prev;
    }

    public static void main(String[] args) {
        // Creating the linked list: [1,2,3,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original list:");
        printList(head);

        head = reverseList(head);

        System.out.println("Reversed list:");
        printList(head);
    }

    // Method to print the linked list
    public static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
