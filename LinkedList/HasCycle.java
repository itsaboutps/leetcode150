package LinkedList;

import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class HasCycle {

    //approach 1
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        while(head!=null){
            if(!(set.contains(head))){
                set.add(head);
                head = head.next;
            }else{
                return true;
            }

        }
        return false;
    }

    public boolean hasCycleOptimsed(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while((fast !=null) && (fast.next!=null)){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}