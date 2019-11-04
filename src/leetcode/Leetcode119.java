package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gutongxue
 * @date 2019/11/4 20:44
 * 返回杨辉三角的第k行，O(k)空间复杂度
 **/
public class Leetcode119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0) {
            return list;
        }
        list.add(1);
        int num = 1;
        //前一行该位置的元素
        int pre = 1;
        int current;
        while (num <= rowIndex) {
            int size = list.size();
            for (int i = 1; i < size; i++) {
                current = list.get(i);
                list.set(i, list.get(i) + pre);
                pre = current;
            }
            list.add(1);
            num++;
        }
        return list;
    }
}
