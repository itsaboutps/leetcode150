package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNode {
    public static void main(String[] args) {
        System.out.println("remove-nth-node-from-end-of-list");
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        int nthNod = 2;
        // bruteForce(n1,nthNod);
        iterationUsingTwoPass(n1, nthNod);

    }

    private static ListNode iterationUsingTwoPass(ListNode head, int nthNod) {

        ListNode curr = head;
        int N = 0;

        while(curr!=null){

            N+=1;
            curr = curr.next;
        }
        int removeIndex = N - nthNod;
        System.out.println(removeIndex);

        //case of removing first node
        if(removeIndex==0){
            return head.next;
        }

        curr = head;
        for (int i = 0; i < N-1; i++) {
            if((i+1) == removeIndex){
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
            
        }


        throw new IllegalArgumentException("Input arrays");

    }

    private static ListNode bruteForce(ListNode head, int nthNod) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }

        int removeIndex = nodes.size() - nthNod;
        if (removeIndex == 0) {
            return head.next;
        }

        nodes.get(removeIndex - 1).next = nodes.get(removeIndex).next;

        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
        // return head;
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
