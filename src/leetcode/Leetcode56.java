package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author gutongxue
 * @date 2019/9/17 19:38
 * 56.合并区间
 **/


class MyComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[0] > o2[0] ? 1 : o1[0]==o2[0] ? 0 : -1;
    }
}
public class Leetcode56 {

    public int[][] merge(int[][] intervals) {
        //无效输入
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        //根据区间起始值对区间进行排序
        Arrays.sort(intervals, new MyComparator());
        //存放结果
        List<int[]> list = new ArrayList<>();

        //遍历区间数组
        for (int i = 0; i < intervals.length; i++) {
            //当前还在合并中的区间,必须在循环内定义该数组
            int[] temp = new int[2];
            temp[0] = intervals[i][0];
            temp[1] = intervals[i][1];
            while (i < intervals.length - 1 && temp[1] >= intervals[i+1][0]) {
                temp[1] = Math.max(temp[1], intervals[i+1][1]);
                i++;
            }
            //已合并完成一个区间，加入list
            list.add(temp);
        }
        //数组列表转为数组返回
        int[][] result = new int[list.size()][2];
        list.toArray(result);
        return result;
    }

    public static void main(String[] args) {
        int[][] demo1 = new int[][] {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] demo2 = new int[][] {{1,4}, {4,5}};
        Leetcode56 mergeIntervals = new Leetcode56();
        int[][] arr = mergeIntervals.merge(demo1);
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }
}


