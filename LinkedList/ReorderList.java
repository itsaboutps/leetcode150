package LinkedList;

import java.util.ArrayList;

public class ReorderList {
    public static void main(String[] args) {
        System.out.println("Reorder list :: ");
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        // reorderList(n1);
        solutionUsing(n1);
    }

    private static void solutionUsing(ListNode head) {
        

        // 1. Find the middle of the list
        // 2. Reverse the second half
        // 3. Merge the two halves
        
        ListNode fast = head, slow = head;

        // Find the middle of the list
        // 1->2->3->4->5->null
        // 1->2->3->null    
        // 4->5->null
        // 1->2->3->null
        // 4->null
        // 5->null
        // 1->2->3->null
        // 4->null
        // 5->null

        while (fast.next != null && fast.next.next != null) {
            // 1->2->3->4->5->null
            slow = slow.next;
        
            fast = fast.next.next;
        }

        // 1->2->3->4->5->null
        // 1->2->3->null
        // 4->5->null

        ListNode cur = slow.next;
        slow.next = null;

        ListNode pre = null;

        // 1->2->3->null
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }

        // 1->2->3->null
        cur = head;

        //
        while (pre != null) {
            ListNode t = pre.next;
            pre.next = cur.next;
            cur.next = pre;
            cur = pre.next;
            pre = t;
        }
    }

    private static void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        ArrayList<ListNode> array = new ArrayList<>();


        ListNode curr = head;

        while (curr != null) {
            array.add(curr);
            curr = curr.next;
        }

        int i = 0;
        int j = array.size() - 1;

        while (i < j) {
            array.get(i).next = array.get(j);
            i++;
            if (i >= j) {
                break;
            }
            array.get(j).next = array.get(i);
            j--;

        }
        array.get(i).next = null;

        System.out.println(array);
        for (ListNode elem : array) {
            System.out.println(elem.val);
            
        }

    }

    private static void printLinkedList(ListNode head) {
        ListNode dummy = head;

        while (dummy != null) {
            System.out.println(dummy.val);
            dummy = dummy.next;
        }
    }
}
