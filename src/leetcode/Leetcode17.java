package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gutongxue
 * @date 2019/9/20 21:06
 * 电话号码能表示的字母组合
 **/
public class Leetcode17 {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() <= 0) {
            return result;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper(result, "", digits, map);
        return result;
    }

    /**
     *
     * @param result 存入每组字母组合的数组列表
     * @param combination 遍历到当前字符时当前已确定的字母组合
     * @param next_digits 剩余待遍历的字符
     */
    private void helper(List<String> result, String combination, String next_digits, Map<Character, String> map) {
        //一组结果
        if (next_digits.length() == 0) {
            result.add(combination);
        }
        else {
            char digit = next_digits.charAt(0);
            //当前数字代表的所有字母
            String letters = map.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                helper(result, combination + letter, next_digits.substring(1), map);
            }
        }
    }

    public static void main(String[] args) {
        Leetcode17 leetcode17 = new Leetcode17();
        String digits = "237";
        ArrayList<String> result = (ArrayList<String>) leetcode17.letterCombinations(digits);
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }
}
