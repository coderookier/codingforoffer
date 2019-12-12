package Chapter6;

/**
 * @author gutongxue
 * @date 2019/12/12 20:28
 * 整型数组中除了一个出现一次的数以外，其他数字都出现三次，找出这个数字
 **/
public class Question56_2 {
    public int findNumberAppearOnce(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            throw new RuntimeException("Invalid Input");
        }
        /*
          如果数字出现三次，则二进制表示的每一位也出现三次，即和能被3整除
         */
        //记录整数的31位中每位出现的次数
        int[] bitSum = new int[32];
        int bitMask = 1;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < numbers.length; j++) {
                int bit = bitMask & numbers[j];
                //第j个的第i位为1
                if (bit != 0) {
                    bitSum[i] += 1;
                }
            }
            bitMask = bitMask << 1;
        }
        int result = 0;
        bitMask = 1;
        //将二进制表示的各位数值相加即得到结果
        for (int i = 0; i < 32; i++) {
            if ((bitSum[i] % 3) != 0) {
                result += bitMask;
            }
            bitMask = bitMask << 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {3,3,3,6,6,6,2,2,2,77777};
        Question56_2 question56_2 = new Question56_2();
        System.out.println(question56_2.findNumberAppearOnce(numbers));
    }
}
