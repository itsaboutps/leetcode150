package Tree;

public class LowestCommonAnscestor {
    public static void main(String[] args) {
        System.out.println("");
    }
}

class SolutionLowestCommonAnscestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while(curr!=null){
            if(p.val > curr.val && q.val>curr.val){
                curr = curr.right;
            }
            else if(p.val < curr.val && q.val<curr.val){
                curr = curr.left;
            }else{
                return curr;
            }
        }
        return root;
    }
}

class SolutionUsingRescursion {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (Math.max(p.val, q.val) < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (Math.min(p.val, q.val) > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}