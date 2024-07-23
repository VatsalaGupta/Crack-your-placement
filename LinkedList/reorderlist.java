class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class reorderlist {

    public static void main(String[] args) {
        int[] headArray = {1, 2, 3, 4};

        ListNode head = createList(headArray);
        System.out.print("Original List: ");
        printList(head);

        reorderList(head);
        System.out.print("Reordered List: ");
        printList(head);
    }

    public static ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode curr = head;
        ListNode nextNode = null;
        while (curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public static void merge(ListNode list1, ListNode list2) {
        while (list1 != null && list2 != null) {
            ListNode next1 = list1.next;
            ListNode next2 = list2.next;

            list1.next = list2;
            if (next1 == null) break;

            list2.next = next1;
            list1 = next1;
            list2 = next2;
        }
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        // Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Cut the list into two halves
        prev.next = null;
        
        // Reverse the second half
        ListNode list2 = reverse(slow);
        
        // Merge the two halves
        merge(head, list2);
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
