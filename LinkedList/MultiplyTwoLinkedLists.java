public class MultiplyTwoLinkedLists {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static long multiplyTwoLists(ListNode l1, ListNode l2) {
        long m = 1000000007;
        long n1 = 0, n2 = 0;

        ListNode temp = l1;
        while (temp != null) {
            n1 = (n1 * 10 + temp.val) % m;
            temp = temp.next;
        }
        temp = l2;
        while (temp != null) {
            n2 = (n2 * 10 + temp.val) % m;
            temp = temp.next;
        }

        return (n1 * n2) % m;
    }

    public static void main(String[] args) {
        // Creating the first linked list: 3->2
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(2);

        // Creating the second linked list: 2
        ListNode l2 = new ListNode(2);

        System.out.println("LinkedList L1: 3->2");
        System.out.println("LinkedList L2: 2");

        long result = multiplyTwoLists(l1, l2);

        System.out.println("Result of multiplication: " + result);
    }
}
