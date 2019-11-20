package chapter5;

/**
 * @author gutongxue
 * @date 2019/11/20 16:39
 * 最长不包含重复字符的子字符串
 * 动态规划
 **/
public class Question48 {
    public int longestSubstringWithoutDuplication(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        //最大长度
        int maxLength = 0;
        //当前子字符串的长度
        int currentLength = 0;
        //用来记录每个字符上一次出现在字符串中的下标
        int[] position = new int[26];
        for (int i = 0; i < 26; i++) {
            position[i] = -1;
        }
        for (int i = 0; i < str.length(); i++) {
            //初始为-1
            int preIndex = position[str.charAt(i) - 'a'];
            //该字符第一次出现或者上次出现时己经不在此子字符串中
            if (preIndex < 0 || i - preIndex > currentLength) {
                currentLength++;
            }
            else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                //更新currentLength
                currentLength = i - preIndex;
            }
            //将该字符的下标保存到位置数组中
            position[str.charAt(i) - 'a'] = i;
        }
        if (currentLength > maxLength) {
            maxLength = currentLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Question48 question48 = new Question48();
        String string = "arabcacfr";
        System.out.println(question48.longestSubstringWithoutDuplication(string));
    }
}
