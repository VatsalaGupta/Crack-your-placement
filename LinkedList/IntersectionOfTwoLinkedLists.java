public class IntersectionOfTwoLinkedLists {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Boundary check
        if (headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        // If a & b have different lengths, then we will stop the loop after second iteration
        while (a != b) {
            // For the end of the first iteration, reset the pointer to the head of the other linked list
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        
        return a;
    }

    public static void main(String[] args) {
        // Creating two linked lists with intersection:
        // List A: [4, 1, 8, 4, 5]
        // List B: [5, 6, 1, 8, 4, 5]
        // Intersection value: 8, skipA: 2, skipB: 3

        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(4);
        intersect.next.next = new ListNode(5);

        ListNode listA = new ListNode(4);
        listA.next = new ListNode(1);
        listA.next.next = intersect;

        ListNode listB = new ListNode(5);
        listB.next = new ListNode(6);
        listB.next = new ListNode(1);
        listB.next.next = intersect;

        System.out.println("List A:");
        printList(listA);

        System.out.println("List B:");
        printList(listB);

        ListNode intersection = getIntersectionNode(listA, listB);

        if (intersection != null) {
            System.out.println("Intersection at node with value: " + intersection.val);
        } else {
            System.out.println("No intersection.");
        }
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
