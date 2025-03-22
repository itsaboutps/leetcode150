# leetcode150
Practise leetcode 150 question with brief descriptive code 
1. Floyd Cycle Detection Algorithm
2. Practice sliding window technique
3. Memorise Binary Search
4. Memorise Binary Tree Traversal Technique BFS DFS INORDER, POSTORDER, PREORDER



IMPORTANT FUNCTIONS:

# Function to reverse a linked list
private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
}

# Utility function to print the linked list
public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
}

