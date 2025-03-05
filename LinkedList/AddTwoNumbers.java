package LinkedList;

public class AddTwoNumbers {
    public static void main(String[] args) {
        System.out.println("Add two numbers");
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        // ListNode n4 = new ListNode(4);
        // ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        // n3.next = n4;
        // n4.next = n5;

        ListNode k1 = new ListNode(5);
        ListNode k2 = new ListNode(6);
        ListNode k3 = new ListNode(4);
        // ListNode k4 = new ListNode(4);
        // ListNode k5 = new ListNode(5);

        k1.next = k2;
        k2.next = k3;
        // k3.next = k4;
        // k4.next = k5;

        print(addTwoNumbers(n1, k1));
    }

    private static void print(ListNode twoNumbersSum) {
        while(twoNumbersSum!=null){
            System.out.println(twoNumbersSum.val);
            twoNumbersSum = twoNumbersSum.next;
        }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int val = v1 + v2 + carry;
            carry = val / 10;
            val = val % 10;
            cur.next = new ListNode(val);

            cur = cur.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return dummy.next;
    }
}
