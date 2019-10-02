package leetcode;

/**
 * @author gutongxue
 * @date 2019/10/2 16:24
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次，找出那个只出现一次的元素
 **/
public class Leetcode137 {

    /**
     * 出现三次的数字，则二进制表示某位上1出现的次数为3的倍数
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        int flag = 1;
        for (int i = 0; i <= 31; i++){
            flag = 1 << i;
            //sum记录该位置上1出现的次数
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & flag) != 0) {
                    sum++;
                }
            }
            if ((sum % 3) != 0) {
                res += flag;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode137 leetcode137 = new Leetcode137();
        int[] nums = {0,1,0,1,0,1,99};
        System.out.println(leetcode137.singleNumber(nums));
    }
}
