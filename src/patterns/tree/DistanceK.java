package patterns.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DistanceK {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.add(node.right);
            }
        }

        List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);
        int currentDistance = 0;

        while (!queue.isEmpty()) {
            if (currentDistance == k) {
                while (!queue.isEmpty()) {
                    result.add(queue.poll().val);
                }
                return result;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    queue.add(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    queue.add(node.right);
                    visited.add(node.right);
                }
                if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
                    queue.add(parentMap.get(node));
                    visited.add(parentMap.get(node));
                }
            }
            currentDistance++;
        }

        return result;
    }
}
