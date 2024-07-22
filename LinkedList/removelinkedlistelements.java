public class removelinkedlistelements {

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

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Creating the linked list: [1,2,6,3,4,5,6]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        int val = 6;

        System.out.println("Original list:");
        printList(head);

        head = removeElements(head, val);

        System.out.println("List after removing " + val + ":");
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
