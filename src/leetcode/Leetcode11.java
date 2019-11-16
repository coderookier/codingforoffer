package leetcode;

/**
 * @author gutongxue
 * @date 2019/11/16 20:44
 * 盛最多水的容器
 **/
public class Leetcode11 {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = Integer.MIN_VALUE;
        int currentArea = 0;
        while (left < right) {
            currentArea = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, currentArea);
            //由外向里宽度会减小，只有把左右两个指针高度中较低的移动才有可能遇到更大的值
            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return max;
    }
}
