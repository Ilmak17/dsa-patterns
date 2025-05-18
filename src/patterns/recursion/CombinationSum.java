package patterns.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(candidates, 0, target, new ArrayList<>(), res);

        return res;
    }

    private void backtrack(int[] nums,
                           int idx,
                           int target,
                           List<Integer> cur,
                           List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if (target - nums[i] < 0) continue;
            cur.add(nums[i]);
            backtrack(nums, i, target - nums[i], cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
