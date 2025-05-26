package patterns.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthBT {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int mmin = q.peek().getValue();

            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                int curId = q.peek().getValue() - mmin;
                TreeNode node = q.peek().getKey();
                q.poll();

                if (i == 0) {
                    first = curId;
                }

                if (i == size - 1) {
                    last = curId;
                }

                if (node.left != null) {
                    q.offer(new Pair<>(node.left, curId * 2 + 1));
                }

                if (node.right != null) {
                    q.offer(new Pair<>(node.right, curId * 2 + 2));
                }
            }

            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
}
