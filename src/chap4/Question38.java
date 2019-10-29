package chap4;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author gutongxue
 * @date 2019/10/29 15:19
 * 输入一个字符串，打印出该字符串中所有字符的所有排列
 **/
public class Question38 {

    public ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        char[] strs = str.toCharArray();
        if (str != null && str.length() > 0) {
            permutationHelper(strs, 0, res);
        }
        Collections.sort(res);
        return res;
    }

    public void permutationHelper(char[] strs, int index, ArrayList<String> res) {
        if (index == strs.length - 1) {
            String str = String.valueOf(strs);
            if (!res.contains(str)) {
                res.add(str);
            }
        }
        else {
            for (int i = index; i < strs.length; i++) {
                swap(strs, index, i);
                permutationHelper(strs, index + 1, res);
                swap(strs, index, i);
            }
        }
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        Question38 question38 = new Question38();
        String str = "abca";
        ArrayList<String> res = question38.permutation(str);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
