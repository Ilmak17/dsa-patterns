package patterns.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

class Tuple {
    TreeNode node;
    int x;
    int y;

    Tuple(TreeNode node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }
}

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class VerticalOrderTraversal {

    public List<List<Integer>> verticalOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> treeMap = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode cur = tuple.node;
            int x = tuple.x;
            int y = tuple.y;

            treeMap.computeIfAbsent(x, k -> new TreeMap<>());
            treeMap.get(x).computeIfAbsent(y, k -> new PriorityQueue<>());
            treeMap.get(x).get(y).add(cur.val);

            if (cur.left != null) {
                queue.add(new Tuple(cur.left, x - 1, y + 1));
            }

            if (cur.right != null) {
                queue.add(new Tuple(cur.right, x + 1, y + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> map : treeMap.values()) {
            List<Integer> col = new ArrayList<>();

            for (PriorityQueue<Integer> pq : map.values()) {
                while (!pq.isEmpty()) col.add(pq.poll());
            }

            result.add(col);
        }

        return result;
    }

    public List<Integer> topViewOrderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Map<Integer, Integer> mpp = new TreeMap<>();

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();

        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> it = q.poll();
            TreeNode node = it.getKey();
            int line = it.getValue();

            if (!mpp.containsKey(line)) {
                mpp.put(line, node.val);
            }

            if (node.left != null) {
                q.add(new Pair<>(node.left, line - 1));
            }

            if (node.right != null) {
                q.add(new Pair<>(node.right, line + 1));
            }
        }

        ans.addAll(mpp.values());

        return ans;
    }

    public List<Integer> bottomView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Map<Integer, Integer> map = new TreeMap<>();

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();

        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> it = q.poll();
            TreeNode node = it.getKey();
            int line = it.getValue();

            map.put(line, node.val);

            if (node.left != null) {
                q.add(new Pair<>(node.left, line - 1));
            }

            if (node.right != null) {
                q.add(new Pair<>(node.right, line + 1));
            }
        }

        ans.addAll(map.values());

        return ans;
    }
}
