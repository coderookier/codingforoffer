package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author gutongxue
 * @date 2019/9/27 16:09
 * 数组candidates和目标数target，找出candidates中所有可以使和为target组合
 * 每个数字只能使用一次，解集不能包含重复的组合
 **/
public class Leetcode40 {
    private HashSet<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length <= 0 || target <= 0) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        combinationCore(candidates, new ArrayList<>(), target, 0);
        List<List<Integer>> res = new ArrayList<>(set);
        return res;
    }

    public void combinationCore(int[] candidates, List<Integer> list, int target, int start) {
        if (target == 0) {
            set.add(new ArrayList<>(list));
            return;
        }
        else if (target < 0) {
            return;
        }
        else {
            for (int i = start; i < candidates.length; i++) {
                if (target < candidates[i]) {
                    break;
                }
                list.add(candidates[i]);
                combinationCore(candidates, list, target - candidates[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Leetcode40 leetcode40 = new Leetcode40();
        int[] candidates = {10,1,2,7,6,1,5};
        System.out.println(leetcode40.combinationSum2(candidates, 8));
    }
}
