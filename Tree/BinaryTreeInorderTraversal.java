package Tree;
import java.util.*;

public class BinaryTreeInorderTraversal {
    
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// The order of in-order traversal is left-root-right, and the specific algorithm is:

// Starting from the root node, push the root node onto the stack

// Then push all its left child nodes into the stack, take out the top node of the stack, and save the node value

// Then move the current pointer to its right child node. If there is a right child node, all its left child nodes can be pushed into the stack in the next loop, and repeat the above steps.
//! Input: root = [1,null,2,3]
//! Output: [1,3,2]


//! The order of in-order traversal is that 左-根-右the root node is not output first, which is a little complicated.

//!     1. Root node is pushed into the stack

//!     2. Determine whether there is a left node. If so, push it into the stack until it reaches the leaf node.

// At this time, the stack stores all left nodes and root nodes.

//!     3. Pop the stack, check if there is a right node, if there is, push it into the stack, and continue to execute 2
// It is worth noting that the result of in-order traversal of a binary search tree (BST) is an ordered array.
class SolutionIterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<> ();
        Stack<TreeNode> stack = new Stack<> ();
        
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// https://leetcode.com/problems/binary-tree-inorder-traversal/description/
class SolutionRecursive {
    List<Integer> res = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return res;
    }

    public void inorder (TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        res.add(root.val);

        inorder(root.right);
    }
}