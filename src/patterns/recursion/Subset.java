package patterns.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> res = new ArrayList<>();

        backtrack(nums, 0, 0, res);

        return res;
    }

    private void backtrack(int[] nums, int idx, int sum, List<Integer> res) {
        if (nums.length == idx) {
            res.add(sum);
            return;
        }
        backtrack(nums, idx + 1, sum + nums[idx], res);
        backtrack(nums, idx + 1, sum, res);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), res);

        return res;
    }

    private void backtrack(int[] nums,
                           int idx,
                           List<Integer> cur,
                           List<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[idx]);
        backtrack(nums, idx + 1, cur, res);
        cur.remove(cur.size() - 1);
        while (idx + 1 < nums.length && nums[idx] == nums[idx + 1]) {
            idx++;
        }
        backtrack(nums, idx + 1, cur, res);
    }
}
