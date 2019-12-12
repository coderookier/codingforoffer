package Chapter6;

/**
 * @author gutongxue
 * @date 2019/12/6 17:06
 * 整型数组里除了两个数字出现一次之外，其他数字都出现两次，请找出这个两个数字
 * 若只有一个数字出现一次，则所有数字异或后的结果就是该数
 * 将原数组分为两个各包含一个只出现一次数字的数组
 **/
public class Question56 {
    public int[] findNumsAppearOnce(int[] data) {
        if (data == null || data.length <= 1) {
            throw new RuntimeException("invalid input");
        }
        //存放数组中所有数字异或的结果
        int xor = 0;
        for (int num : data) {
            xor ^= num;
        }
        if (xor == 0) {
            return null;
        }
        //通过按位与，找出异或结果中从低到高位首次出现1的位置
        int p = 1;
        while ((xor & p) == 0) {
            p = p << 1;
        }
        int[] data1 = new int[data.length];
        int[] data2 = new int[data.length];
        int i1 = 0, i2 = 0;
        for (int j = 0; j < data.length; j++) {
            int num = data[j] & p;
            if (num == 0) {
                data1[i1] = data[j];
                i1++;
            }
            else {
                data2[i2] = data[j];
                i2++;
            }
        }
        int res1 = 0, res2 = 0;
        //第一个只出现一次的数字
        for (int num1 : data1) {
            res1 ^= num1;
        }
        //第二个只出现一次的数字
        for (int num2 : data2) {
            res2 ^= num2;
        }
        int[] res = new int[2];
        res[0] = res1;
        res[1] = res2;
        return res;
    }

    public static void main(String[] args) {
        int[] data = {2,4,3,6,3,2,5,5,4,6,12,14};
        Question56 question56 = new Question56();
        int[] res = question56.findNumsAppearOnce(data);
        for (int resNum : res) {
            System.out.println(resNum);
        }
    }
}
