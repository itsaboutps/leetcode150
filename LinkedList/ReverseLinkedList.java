package LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        //!using iterative approach
        // ListNode newHead = reverseUsingIterativeApproach(n1);

        //!using recursive approach
        ListNode newHead = reverseRecursive(n1);

        while(newHead!=null){
            System.out.println(newHead.val);
            newHead= newHead.next;
        }

    }

    private static ListNode reverseRecursive(ListNode head) {

        //! important base case of RECURSION;
         if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseRecursive(head.next);

        head.next.next = head;
        head.next = null;
        
        return newHead;

    }

    // time complexity is O(n) and memory complexity is O(1)
    private static ListNode reverseUsingIterativeApproach(ListNode head) {

        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode tempAddress = current.next;
            current.next = previous;
            previous = current;
            current = tempAddress;
        }
        return previous;

    }
}
