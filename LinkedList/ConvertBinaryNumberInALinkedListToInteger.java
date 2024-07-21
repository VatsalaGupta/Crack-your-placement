package LinkedList;

public class ConvertBinaryNumberInALinkedListToInteger {

    public static void main(String[] args) {
        // Create linked list: 1 -> 0 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);

        ConvertBinaryNumberInALinkedListToInteger solution = new ConvertBinaryNumberInALinkedListToInteger();
        int result = solution.getDecimalValue(head);

        System.out.println(result);  // Output: 5
    }

    public int getDecimalValue(ListNode head) {
        int decimal = 0;
        ListNode temp = head;
        while (temp != null) {
            decimal = (decimal << 1) | temp.val;
            temp = temp.next;
        }
        return decimal;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
