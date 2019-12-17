package chapter6;

/**
 * @author gutongxue
 * @date 2019/12/2 20:39
 * 判断两个单词是否互为变位词，即字母出现次数相同
 **/
public class Question50_3 {
    public boolean isAnagram(String s1, String s2) {
        if (s1 == null || s1.length() <= 0 || s2 == null || s2.length() <= 0) {
            return false;
        }
        int[] arr = new int[256];
        //统计字符串1中各个字符出现的次数
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            arr[ch] += 1;
        }
        //遍历字符串2，字符每出现一次对应位置元素值-1
        for (int j = 0; j < s2.length(); j++) {
            char ch = s2.charAt(j);
            arr[ch] -= 1;
        }
        for (int num : arr) {
            //数组中有元素值不为0则false
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Question50_3 question50_3 = new Question50_3();
        System.out.println(question50_3.isAnagram("listen", "silent"));
    }
}
