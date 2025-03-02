package LinkedList;

public class MergeTwoSorted {
    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        // ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        // n4.next = n5;

        ListNode k1 = new ListNode(1);
        ListNode k2 = new ListNode(2);
        ListNode k3 = new ListNode(3);
        ListNode k4 = new ListNode(4);
        ListNode k5 = new ListNode(5);

        k1.next = k2;
        k2.next = k3;
        k3.next = k4;
        k4.next = k5;
        // * */ APPROACH-1
        // ******************************************************************************
        ListNode mergedNode = mergeTwoSorted(n1, k1);

        while (mergedNode != null) {
            System.out.println(mergedNode.val);
            mergedNode = mergedNode.next;
        }
        // ******************************************************************************
        // * */ APPROACH-2

        ListNode mergedNode2 = mergeTwoSortedUsingRecursion(n1, k1);

        while (mergedNode2 != null) {
            System.out.println(mergedNode2.val);
            mergedNode2 = mergedNode2.next;
        }
        // ******************************************************************************

    }

    private static ListNode mergeTwoSortedUsingRecursion(ListNode list1, ListNode list2) {
        // TODO Auto-generated method stub
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoSortedUsingRecursion(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoSortedUsingRecursion(list1, list2.next);
            return list2;
        }
    }

    private static ListNode mergeTwoSorted(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0); // this nodes are important to return the final answer
        ListNode node = dummy; // ! this node is important for traversal

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1 != null) {
            node.next = list1;
        }
        if (list2 != null) {
            node.next = list2;
        }
        return dummy.next;

    }
}
