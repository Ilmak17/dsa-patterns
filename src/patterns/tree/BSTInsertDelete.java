package patterns.tree;

public class BSTInsertDelete {

    public TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            root.val = getMin(root.right);
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }

    private int getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node.val;
    }
}
