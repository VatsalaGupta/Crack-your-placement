class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class reverselinkedlist2 {

    public static void main(String[] args) {
        int[] headArray = {1, 2, 3, 4, 5};
        int left = 2;
        int right = 4;

        ListNode head = createList(headArray);
        System.out.print("Original List: ");
        printList(head);

        ListNode reversedList = reverseBetween(head, left, right);
        System.out.print("Reversed List: ");
        printList(reversedList);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode frow = curr.next;
            curr.next = frow.next;

            frow.next = prev.next;
            prev.next = frow;
        }
        return dummy.next;
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
