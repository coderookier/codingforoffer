package leetcode;

/**
 * @author gutongxue
 * @date 2019/11/3 16:44
 * 删除排序数组中的重复项，使得每个元素最多出现2次，使用O(1)空间复杂度
 **/
public class Leetcode80 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            throw new RuntimeException("invalid input parameters");
        }
        if (nums.length <= 2) {
            return nums.length;
        }
        //滑动遍历指针
        int index = 2;
        //已删除重复元素的数组部分
        int removeIndex = 1;
        while (index < nums.length){
            //这部分if是根据分情况之后发现可以合并写
            if (nums[index] == nums[removeIndex] && nums[removeIndex] == nums[removeIndex - 1]) {
                //已出现两次
                index++;
            }
            else {
                nums[++removeIndex] = nums[index];
                index++;
            }
        }
        return removeIndex + 1;
    }
}
