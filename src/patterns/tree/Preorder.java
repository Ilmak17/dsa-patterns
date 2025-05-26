package patterns.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Preorder {

    public void preorder(TreeNode root, List<Integer> preorder) {
        if (root == null) return;
        preorder.add(root.val);
        preorder(root.left, preorder);
        preorder(root.right, preorder);
    }

    public List<Integer> preorder(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();

        if (root == null) {
            return preorder;
        }

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.empty()) {
            root = st.pop();

            preorder.add(root.val);

            if (root.right != null) {
                st.push(root.right);
            }

            if (root.left != null) {
                st.push(root.left);
            }
        }

        return preorder;
    }
}
