package Chapter6;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gutongxue
 * @date 2019/12/2 19:46
 * 找到字符串中第一个只出现一次的字符
 **/
public class Question50 {
    public char firstNotRepeatingChar(String s) {
        if (s == null || s.length() <= 0) {
            throw new RuntimeException("invalid input");
        }
        //统计字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            //字符首次出现
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            }
            else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return s.charAt(0);
    }

    public static void main(String[] args) {
        String s = "hiqfwlefjbvhfjdkjazhaewfhyqiuw";
        Question50 question50 = new Question50();
        System.out.println(question50.firstNotRepeatingChar(s));
    }
}
