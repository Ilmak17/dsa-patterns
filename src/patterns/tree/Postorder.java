package patterns.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Postorder {

    public void postorder(TreeNode root, List<Integer> postorder) {
        if (root == null) return;
        postorder(root.left, postorder);
        postorder(root.right, postorder);
        postorder.add(root.val);
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
