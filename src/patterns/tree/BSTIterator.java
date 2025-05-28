package patterns.tree;

import java.util.Stack;

public class BSTIterator {

    private final Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        push(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode temp = stack.pop();
        push(temp.right);

        return temp.val;
    }

    private void push(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
