package Chapter6;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author gutongxue
 * @date 2019/12/17 15:36
 * 给定一个数组和滑动窗口大小，找出每个窗口里的最大值
 **/
public class Question59 {
    public ArrayList<Integer> getMaxWindowsValue(int[] nums, int size) {
        if (nums == null || nums.length <= 0 || nums.length < size || size <= 0) {
            return null;
        }
        //队列中用于存放当前窗口数字下标，队列头部存放最大值下标
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.poll();
            }
            queue.offer(i);
        }
        for (int i = size; i < nums.length; i++) {
            //队列头部的值作为当前窗口最大值放入list
            list.add(nums[queue.peek()]);
            //从队列尾部依次比较与当前值的大小，小于则弹出
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            //队列头部的值已经不在当前窗口范围内，则出队列
            if (!queue.isEmpty() && queue.peek() <= (i - size)) {
                queue.poll();
            }
            queue.offer(i);
        }
        //最后一个窗口的最大值
        list.add(nums[queue.peek()]);
        return list;
    }

    public static void main(String[] args) {
        Question59 question59 = new Question59();
        int[] nums = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> list = new ArrayList<>(question59.getMaxWindowsValue(nums, 1));
        for (int num : list) {
            System.out.println(num);
        }
    }
}
