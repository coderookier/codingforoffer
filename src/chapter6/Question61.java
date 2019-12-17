package chapter6;

import java.util.Arrays;

/**
 * @author gutongxue
 * @date 2019/12/17 16:38
 * 从扑克牌中抽5张，判断是不是一个顺子，大小王可以看成任意数字，A为1，J为11，Q为12，K为13
 * 将大小看作0
 **/
public class Question61 {
    public boolean isContinuous(int[] nums) {
        if (nums == null || nums.length < 5) {
            return false;
        }
        //数组排序
        Arrays.sort(nums);
        //统计数组中0的个数
        int numOfZero = 0;
        for (int i = 0; i < 5; i++) {
            if (nums[i] == 0) {
                numOfZero++;
            }
        }
        //统计数组中间隔的数目，需要用0填充
        int numOfGap = 0;
        //第一个非0数字位置
        int small = numOfZero;
        //相邻位置
        int big = small + 1;
        while(big < 5) {
            //存在重复非零元素
            if (nums[small] == nums[big]) {
                return false;
            }
            numOfGap += nums[big] - nums[small] - 1;
            small = big;
            big++;
        }
        //大小王数目大于间隔数则是顺子
        return (numOfZero >= numOfGap) ? true : false;
    }

    public static void main(String[] args) {
        Question61 question61 = new Question61();
        int[] nums = {3,5,4,1,0};
        System.out.println(question61.isContinuous(nums));
    }
}
