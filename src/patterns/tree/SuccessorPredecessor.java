package patterns.tree;

import java.util.Arrays;
import java.util.List;

public class SuccessorPredecessor {
    private static final int MAX_VALUE = Integer.MAX_VALUE;

    private int predecessor = -1;
    private int successor = MAX_VALUE;

    public List<Integer> succPredBST(TreeNode root, int key) {
        traverse(root, key);

        return Arrays.asList(
                predecessor == -1 ? -1 : predecessor, successor == MAX_VALUE ? -1 : successor);
    }

    private void traverse(TreeNode node, int key) {
        if (node == null) {
            return;
        }

        if (node.val < key) {
            predecessor = Math.max(predecessor, node.val);
            traverse(node.right, key);
        } else if (node.val > key) {
            successor = Math.min(successor, node.val);
            traverse(node.left, key);
        } else {
            if (node.left != null) {
                TreeNode temp = node.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                predecessor = temp.val;
            }

            if (node.right != null) {
                TreeNode temp = node.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                successor = temp.val;
            }
        }
    }
}
