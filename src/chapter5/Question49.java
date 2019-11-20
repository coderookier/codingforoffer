package chapter5;

/**
 * @author gutongxue
 * @date 2019/11/20 17:27
 * 求从小到大的第index个丑数，丑数是只包含因子2,3,5的数，习惯上把1称为第一个丑数
 **/
public class Question49 {
    public int getUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }
        //记录丑数
        int[] list = new int[index];
        list[0] = 1;
        //需要返回的即是list[index - 1]
        //指向数组索引
        int count = 0;
        //已经乘以2的丑数索引指针
        int i2 = 0;
        //已经乘以3的丑数索引指针
        int i3 = 0;
        //已经乘以5的丑数索引指针
        int i5 = 0;

        while (count < index - 1) {
            //需要新加入丑数数组中的数
            int temp = Math.min(Math.min(list[i2] * 2, list[i3] * 3), list[i5] * 5);
            if (temp == list[i2] * 2) {
                i2++;
            }
            if (temp == list[i3] * 3) {
                i3++;
            }
            if (temp == list[i5] * 5) {
                i5++;
            }
            list[++count] = temp;
        }
        return list[index - 1];
    }

    public static void main(String[] args) {
        Question49 question49 = new Question49();
        int num = question49.getUglyNumber(1000);
        System.out.println(num);
    }
}
