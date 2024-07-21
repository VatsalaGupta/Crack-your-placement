package LinkedList;

public class LinkedListCycle {
    
    public static void main(String[] args) {
        // Create linked list: 3 -> 2 -> 0 -> -4
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        // Create a cycle for testing
        int pos = 1; // Cycle starts at index 1
        ListNode cycleStart = head;
        ListNode temp = head;
        while (pos-- > 0) {
            cycleStart = cycleStart.next;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = cycleStart; // Create the cycle

        // Check for cycle
        Solution solution = new Solution();
        boolean hasCycle = solution.hasCycle(head);
        System.out.println(hasCycle); // Output: true
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) return false;
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) return true;
            }
            return false;
        }
    }
}
