package LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {

        // LinkedList\reorderList.png

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        // !using iterative approach
        ListNode newHead = reverseUsingIterativeApproach(n1);

        // !using recursive approach
        // ListNode newHead = reverseRecursive(n1);
        // ListNode newHead = approach1(n1, null);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

    }

    // time complexity is O(n) and memory complexity is O(n)
    private static ListNode reverseRecursive(ListNode head) {

        // ! important base case of RECURSION;

        // !if head is null or head.next is null then return head
        if (head == null || head.next == null) {
            return head;
        }


        // !recursive call
        // !this will return the new head of the reversed linked list
        // !for example if we have 1 --> 2 --> 3 --> 4 --> 5 --> null
        // !then this will return 5 --> 4 --> 3 --> 2 --> 1 --> null
        // !and we will store the address of 5 in newHead
        // !and we will store the address of 1 in head
        // !and we will return newHead
        // !so the newHead will be the head of the reversed linked list
        // !and we will return the newHead
        ListNode newHead = reverseRecursive(head.next);

        head.next.next = head; //5.next = 4; 5 → 4 → NULL

        head.next = null;  // head.next = null; // 4.next = null



        return newHead;

    }

    // time complexity is O(n) and memory complexity is O(1)
    private static ListNode reverseUsingIterativeApproach(ListNode head) {

        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            // 1 --> 2 --> 3 --> 4 --> 5 --> null
            // 1 --> null
            // 2 --> 1 --> null
            // 3 --> 2 --> 1 --> null
            // 4 --> 3 --> 2 --> 1 --> null
            // 5 --> 4 --> 3 --> 2 --> 1 --> null

            // !store the address of next node
            ListNode tempAddress = current.next;

            // !reverse the link
            current.next = previous;

            // !move the pointers
            previous = current;

            // !move the pointers
            current = tempAddress;
        }

        // !return the new head
        return previous;

    }
}
