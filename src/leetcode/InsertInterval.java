package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gutongxue
 * @date 2019/9/18 15:15
 * 57.插入区间
 **/
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            int[][] result = {{newInterval[0],newInterval[1]}};
            return result;
        }
        //true表示新区间还未插入
        boolean flag = true;
        //新区间小于所有区间
        if (intervals[0][0] > newInterval[1]) {
            list.add(newInterval);
            flag = false;
        }
        for (int i = 0; i < intervals.length; i++) {
            int[] temp = new int[2];
            temp[0] = intervals[i][0];
            temp[1] = intervals[i][1];
            if (flag) {
                //插入的区间左边大于当前区间右边，则直接将当前区间放入list
                if (temp[1] < newInterval[0]) {
                    list.add(temp);
                    if (i < intervals.length - 1 && newInterval[1] < intervals[i+1][0]) {
                        list.add(newInterval);
                        flag = false;
                    }
                }
                //插入新区间
                else {
                    temp[0] = Math.min(temp[0], newInterval[0]);
                    temp[1] = Math.max(temp[1], newInterval[1]);
                    while (i < intervals.length && temp[1] >= intervals[i][0]) {
                        temp[1] = Math.max(intervals[i][1], temp[1]);
                        i++;
                    }
                    list.add(temp);
                    flag = false;
                    i--;
                }
            }
            //已经新插入区间
            else {
                list.add(temp);
            }
        }
        //新区间大于所有区间
        if (flag) {
            list.add(newInterval);
        }
        int[][] result = new int[list.size()][2];
        list.toArray(result);
        return result;
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        int[][] result = insertInterval.insert(intervals, newInterval);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }
}
