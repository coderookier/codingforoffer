package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gutongxue
 * @date 2019/9/27 16:08
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合
 * 回溯法
 **/
public class Leetcode39 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //无效输入
        if (candidates == null || candidates.length <= 0 || target <= 0) {
            return res;
        }
        //排序便于计算
        Arrays.sort(candidates);
        combinationCore(candidates, new ArrayList<>(), 0, target);
        return res;
    }
    public void combinationCore(int[] candidates, List<Integer> list, int start, int target) {
        if (target == 0) {
            //找到解并保存，从该条子路径退出进行回溯
            res.add(new ArrayList<>(list));
            return;
        }
        else if (target < 0) {
            //此路径无解，直接退出该路径进行回溯
            return;
        }
        else {
            for (int i = start; i < candidates.length; i++) {
                if (target < candidates[i]) {
                    break;
                }
                list.add(candidates[i]);
                combinationCore(candidates, list, i, target - candidates[i]);
                //对返回的路径删除该点的值
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        Leetcode39 leetcode39 = new Leetcode39();
        System.out.println(leetcode39.combinationSum(candidates, 7));
    }
}
