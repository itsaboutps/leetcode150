package LinkedList;

public class ListNode {
    protected int val;
    protected ListNode next;

    // constructor to create new node
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
