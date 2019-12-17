package chapter6;

import java.util.ArrayList;

/**
 * @author gutongxue
 * @date 2019/12/12 21:18
 * 输入一个正数s，打印出所有和为s的连续正数序列（至少包含两个数）
 **/
public class Question57_2 {
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        //初始化序列为1,2
        int small = 1, big = 2;
        int currentSum = small + big;
        list.add(small);
        list.add(big);
        while (small <= sum / 2) {
            if (currentSum == sum) {
                res.add(new ArrayList<>(list));
                list.remove(0);
                currentSum -= small;
                small++;
            }
            else if (currentSum < sum) {
                //当前和较小，则纳入更多的数
                big++;
                currentSum += big;
                list.add(big);
            }
            else {
                //当前和较大，则删除第一个
                list.remove(0);
                currentSum -= small;
                small++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Question57_2 question57_2 = new Question57_2();
        ArrayList<ArrayList<Integer>> res = question57_2.findContinuousSequence(15);
        for (ArrayList<Integer> list : res) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
