

public class RemoveDuplicatesFromSortedList {
    
    public static void main(String[] args) {
        // Create linked list: 1 -> 1 -> 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);

        RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();
        ListNode result = solution.deleteDuplicates(head);

        // Print the resulting linked list
        ListNode temp = result;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively call deleteDuplicates for the next node
        head.next = deleteDuplicates(head.next);

        // Compare the current node with the next node
        if (head.val == head.next.val) {
            return head.next; // Skip the current node
        } else {
            return head; // Keep the current node
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
