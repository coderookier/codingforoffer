package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gutongxue
 * @date 2019/11/4 20:44
 * 生成杨辉三角的前numRows行
 **/
public class Leetcode118 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);
        helper(numRows);
        return res;
    }

    private void helper(int numRows) {
        while (res.size() < numRows) {
            ArrayList<Integer> list = (ArrayList<Integer>) res.get(res.size() - 1);
            ArrayList<Integer> currentList = new ArrayList<>();
            currentList.add(1);
            for (int j = 1; j < list.size(); j++) {
                currentList.add(list.get(j - 1) + list.get(j));
            }
            currentList.add(1);
            res.add(currentList);
        }
    }
}
