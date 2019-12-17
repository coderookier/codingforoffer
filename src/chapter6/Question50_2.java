package chapter6;

/**
 * @author gutongxue
 * @date 2019/12/2 20:13
 * 删除字符串中所有重复出现的字符，如google-->gole
 **/
public class Question50_2 {
    public String deleteRepeatingChar(String s) {
        if (s == null || s.length() <= 0) {
            return null;
        }
        String str = "";
        //记录字符有没有出现，出现则赋值true
        boolean[] flag = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!flag[ch]) {
                str += ch;
                flag[ch] = true;
            }
        }
        return str;
    }
    public static void main(String[] args) {
        Question50_2 question50_2 = new Question50_2();
        String s = "google";
        String s2 = "aaaaaaaaaaaaaa";
        System.out.println(question50_2.deleteRepeatingChar(s));
        System.out.println(question50_2.deleteRepeatingChar(s2));
    }
}
