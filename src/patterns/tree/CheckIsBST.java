package patterns.tree;

public class CheckIsBST {

    public boolean isBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkBST(TreeNode root, Long min, Long max) {
        if (root == null) return true;

        if (root.val <= min || root.val >= max) return false;

        return checkBST(root.left, min, Long.valueOf(root.val)) && checkBST(root.right, Long.valueOf(root.val), max);
    }
}
