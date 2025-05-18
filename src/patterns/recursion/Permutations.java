package patterns.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), permutations);

        return permutations;
    }

    private void backtrack(int[] nums, int idx, List<Integer> oldPermutation, List<List<Integer>> res) {
        if (oldPermutation.size() == nums.length) {
            res.add(new ArrayList<>(oldPermutation));
            return;
        }

        for (int i = 0; i <= oldPermutation.size(); i++) {
            List<Integer> newPermutation = new ArrayList<>(oldPermutation);
            newPermutation.add(i, nums[idx]);
            backtrack(nums, idx + 1, newPermutation, res);
        }
    }
}
