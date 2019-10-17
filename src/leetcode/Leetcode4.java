package leetcode;

/**
 * @author gutongxue
 * @date 2019/10/17 20:52
 * 寻找两个有序数组的中位数，要求时间复杂度O(log(m+n))
 * 对数复杂度首先想到二分查找，求中位数可看作求第k小的特殊情况
 **/
public class Leetcode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        //中位数左
        int left = (len1 + len2 + 1) >> 1;
        //中位数右
        int right = (len1 + len2 + 2) >> 1;
        //奇数则两次k相同，偶数则相邻
        return (getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left)
                + getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right)) * 0.5;
    }

    public int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        //数组的剩余长度
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //确保len1小于len2，则空数组只可能是len1
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        //如果数组1已经为空，则只需返回数组2中第start2 + k - 1个
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        //判断两个数组k/2位置
        int i = start1 + Math.min(len1, k/2) - 1;
        int j = start2 + Math.min(len2, k/2) - 1;
        //舍弃较小数组的前i或者j个元素
        if (nums1[i] > nums2[j]) {
            //更新k的值
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k -(j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i -start1 + 1));
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        Leetcode4 leetcode4 = new Leetcode4();
        System.out.println(leetcode4.findMedianSortedArrays(nums1,nums2));
    }
}
