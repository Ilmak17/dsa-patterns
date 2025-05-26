package patterns.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryTraversal {

    public List<Integer> boundary(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;
        if (isLeaf(root)) result.add(root.val);

        addLeftBoundary(root, result);
        addLeaves(root, result);
        addRightBoundary(root, result);

        return result;
    }

    private void addRightBoundary(TreeNode root, List<Integer> result) {
        List<Integer> tmp = new ArrayList<>();
        while (root != null) {
            if (!isLeaf(root)) tmp.add(root.val);
            root = (root.right != null) ? root.right : root.left;
        }
        Collections.reverse(tmp);
        result.addAll(tmp);
    }

    private void addLeaves(TreeNode root, List<Integer> result) {
        if (isLeaf(root)) {
            result.add(root.val);
            return;
        }
        addLeaves(root.left, result);
        addLeaves(root.right, result);
    }

    private void addLeftBoundary(TreeNode root, List<Integer> result) {
        while (root != null) {
            if (!isLeaf(root)) result.add(root.val);
            root = root.left == null ? root.right : root.left;
        }
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
