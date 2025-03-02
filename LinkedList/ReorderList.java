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

        reorderList(n1);
        printLinkedList(solutionUsing(n1));
    }

    private static ListNode solutionUsing(ListNode head) {
        //optimsed approach left
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'solutionUsing'");
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
            array.get(i).next = array.get(i);
            i++;
            if (i >= j) {
                break;
            }
            array.get(j).next = array.get(i);
            j--;

        }
        array.get(i).next = null;

        System.out.println(array);

    }

    private static void printLinkedList(ListNode head) {
        ListNode dummy = head;

        while (dummy != null) {
            System.out.println(dummy.val);
            dummy = dummy.next;
        }
    }
}
