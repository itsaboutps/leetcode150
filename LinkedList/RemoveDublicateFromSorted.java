package LinkedList;

public class RemoveDublicateFromSorted {
    public static void main(String[] args) {

        // LinkedList\reorderList.png

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        // !using iterative approach
        ListNode newHead = new UsingIteration().deleteDuplicates(n1);

        // !using recursive approach
        // ListNode newHead = reverseRecursive(n1);
        // ListNode newHead = approach1(n1, null);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class UsingIteration {
    public ListNode deleteDuplicates(ListNode head) {

        // !if head is null or head.next is null then return head
        if (head == null || head.next == null)
            return head;

        // !creating a dummy node
        // !and pointing the next of dummy to head
        // !so that we can return dummy.next
        // !and we can return the head of the linked list
        // !after removing the dublicates

        ListNode dummy = new ListNode(1);
        dummy.next = head;

        // !creating a prev node and pointing it to dummy
        // !so that we can keep track of the previous node
        // !and we can remove the dublicates
        // !and we can return the head of the linked list
        // !after removing the dublicates
        ListNode prev = dummy;

        // !iterating the linked list
        // !and checking if the current node is dublicate
        // !if it is dublicate then we will remove it
        // !if it is not dublicate then we will move the prev to head
        // !and we will move the head to head.next
        while (head != null) {
            boolean dublicate = false;

            // !if head.next is not null and head.val is equal to head.next.val
            // !then we will move the head to head.next
            // !and we will set dublicate to true
            // !and we will keep moving the head to head.next
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
                dublicate = true;
            }

            if (dublicate) {
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return dummy.next;

    }

}