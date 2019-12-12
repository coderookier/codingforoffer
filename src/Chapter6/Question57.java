package Chapter6;

/**
 * @author gutongxue
 * @date 2019/12/12 21:03
 * 递增数组中和为s的两个数
 **/
public class Question57 {
    public int[] findNumbersWithSum(int[] data, int s) {
        if (data == null || data.length <= 1) {
            return null;
        }
        //双指针指向数组首尾
        int left = 0, right = data.length - 1, sum;
        int[] res = new int[2];
        while (left < right) {
            sum = data[left] + data[right];
            if (sum == s) {
                res[0] = data[left];
                res[1] = data[right];
                return res;
            }
            else if (sum < s) {
                left++;
            }
            else {
                right--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Question57 question57 = new Question57();
        int[] data = {1,2,4,7,11,15};
        int[] res = question57.findNumbersWithSum(data, 15);
        if (res == null) {
            System.out.println("未找到");
        }
        for (int num : res) {
            System.out.println(num);
        }
    }
}
