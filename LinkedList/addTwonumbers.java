public class addTwonumbers {

    public static void main(String[] args) {
        // Define the two lists as arrays for simplicity
        int[] l1Array = {2, 4, 3};
        int[] l2Array = {5, 6, 4};

        // Convert arrays to linked lists
        ListNode l1 = arrayToList(l1Array);
        ListNode l2 = arrayToList(l2Array);

        // Add the two numbers
        ListNode result = addTwoNumbers(l1, l2);

        // Print the result
        printList(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 != null ? l1 : l2;

        ListNode c1 = l1;
        ListNode c2 = l2;

        ListNode dummy = new ListNode(-1);
        ListNode itr = dummy;

        int carry = 0;
        while (c1 != null || c2 != null || carry != 0) {
            int sum = carry + (c1 != null ? c1.val : 0) + (c2 != null ? c2.val : 0);

            int ld = sum % 10;
            carry = sum / 10;

            itr.next = new ListNode(ld);
            itr = itr.next;

            if (c1 != null) c1 = c1.next;
            if (c2 != null) c2 = c2.next;
        }
        return dummy.next;
    }

    public static ListNode arrayToList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

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

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
