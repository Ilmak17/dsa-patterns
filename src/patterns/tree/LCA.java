package patterns.tree;

public class LCA {

    public TreeNode findLCABinaryTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;

        TreeNode left = findLCABinaryTree(root.left, p, q);
        TreeNode right = findLCABinaryTree(root.left, p, q);

        if (left != null && right != null) return root;

        return left != null ? left : right;
    }

    public TreeNode findLCABinarySearchTree(TreeNode root, int p, int q) {

        while (root != null) {
            if (root.val > p && root.val > q) {
                root = root.left;
            } else if (root.val < p && root.val < q) {
                root = root.right;
            } else {
                return root;
            }
        }

        return new TreeNode(-1);
    }
}
