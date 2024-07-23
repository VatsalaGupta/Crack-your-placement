class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        int[] headArray = {1, 2, 3, 4, 5};
        int n = 2;

        ListNode head = createList(headArray);
        System.out.print("Original List: ");
        printList(head);

        head = removeNthFromEnd(head, n);
        System.out.print("List after removing " + n + "th node from end: ");
        printList(head);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = findLength(head);
        int traverseTill = length - n - 1;
        if (traverseTill == -1) return head.next;

        ListNode curr = head;
        for (int i = 0; i < traverseTill; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }

    public static int findLength(ListNode head) {
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    // Helper method to create a list from an array
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print the list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
