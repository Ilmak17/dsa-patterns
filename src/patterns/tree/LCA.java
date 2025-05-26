package patterns.tree;

public class LCA {

    public TreeNode findLCABinaryTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;

        TreeNode left = findLCABinaryTree(root.left, p, q);
        TreeNode right = findLCABinaryTree(root.left, p, q);

        if (left != null && right != null) return root;

        return left != null ? left : right;
    }
}
