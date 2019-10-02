package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gutongxue
 * @date 2019/10/2 14:37
 * 给定一组不含重复元素的整数数组nums，返回该数组所有可能的子集
 **/
public class Leetcode78 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subsetsCore(new ArrayList<>(), nums, 0);
        return res;
    }

    private void subsetsCore(List<Integer> list, int[] nums, int start) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            //添加
            list.add(nums[i]);
            subsetsCore(list, nums, i + 1);
            //回溯
            list.remove(list.size() - 1);
        }
    }

    /**
     *假设输入是[1,2,3]
     * 全部子集为[000] [001] [010] [011] [100] [101] [110] [111]
     * 1表示子集中这位数字存在，如[010]表示子集为2
     * 子集代表的二进制数全部小于1<<数组length
     */
    public List<List<Integer>> subsets_solution2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < (1 << len); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0) {
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode78 leetcode78 = new Leetcode78();
        int[] nums = {1,2,3};
        //List<List<Integer>> ans = new ArrayList<>(leetcode78.subsets(nums));
        List<List<Integer>> ans2 = new ArrayList<>(leetcode78.subsets_solution2(nums));
      /*  for (List<Integer> list : ans) {
            System.out.println(list);
        }
        */
        for (List<Integer> list : ans2) {
            System.out.println(list);
        }
    }
}
