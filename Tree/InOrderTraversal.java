package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

public static void main(String[] args) {
    System.out.println();
}



    
}


public List<Integer> inorderTraversal(TreeNode root){
    final int WHITE = 0, GRAY =1;

    List<Integer> res = new ArrayList<>();
    Stack<Pair> stack = new Stack<>();


    stack.push(new Pair(WHITE,root));

    while(!stack.isEmpty()){
        Pair pair = stack.pop();
        TreeNode node = pair.node;
        int color = pair.color;

        if(node == null) continue;

        if(color == WHITE){
            stack.push(new Pair(WHITE, node.right));
            stack.push(new Pair(GRAY,node));
            stack.push(new Pair(WHITE, node.left));
        }else{
            res.add(node.val);
        }
    }
    return res;
}