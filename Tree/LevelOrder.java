package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    /* Level-order traversal */
    List<Integer> levelOrder(TreeNode root) {
        // Initialize queue, add root node
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // Initialize a list to store the traversal sequence
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); // Queue dequeues
            list.add(node.val); // Save node value
            if (node.left != null)
                queue.offer(node.left); // Left child node enqueues
            if (node.right != null)
                queue.offer(node.right); // Right child node enqueues
        }
        return list;
    }

}
