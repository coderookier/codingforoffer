package chapter5;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author gutongxue
 * @date 2019/11/12 21:27
 * 找出输入整数中最小的K个数,使用优先队列实现，实现复杂度为O(NlogK)
 **/
public class Question40 {

    public ArrayList<Integer> getLeastNumbers(int[] numbers, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (numbers == null || numbers.length <= 0 || k > numbers.length) {
            return res;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < numbers.length; i++) {
            priorityQueue.offer(numbers[i]);
        }
        for (int i = 0; i < k; i++) {
            res.add(priorityQueue.poll());
        }
        return res;
    }
    public static void main(String[] args) {
        Question40 question40 = new Question40();
        int[] numbers = {4,5,1,6,2,7,3,8};
        int k = 4;
        ArrayList<Integer> ans = new ArrayList<>(question40.getLeastNumbers(numbers, k));
        for (Integer num : ans) {
            System.out.println(num);
        }
    }
}
