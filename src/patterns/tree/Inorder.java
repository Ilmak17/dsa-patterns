package patterns.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder {

    public void inorder(TreeNode root, List<Integer> inorder) {
        if (root == null) return;
        inorder(root.left, inorder);
        inorder.add(root.val);
        inorder(root.right, inorder);
    }

    public List<Integer> inorderUsingStack(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (true) {
            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            } else {
                if (stack.isEmpty()) break;
                cur = stack.pop();
                inorder.add(cur.val);
                cur = cur.right;
            }
        }

        return inorder;
    }
}
