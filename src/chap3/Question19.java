package chap3;

/**
 * @author gutongxue
 * @date 2019/10/7 13:50
 * 实现一个函数用来匹配包含'.'和'*'的正则表达式
 **/
public class Question19 {
    /**
     *
     * @param str 字符串
     * @param pattern 模式串
     * @return
     */
    public boolean match(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        //字符串与模式串的滑动指针
        int pStr = 0;
        int pPattern = 0;
        return matchCore(str, pattern, pStr, pPattern);
    }

    private boolean matchCore(String str, String pattern, int pStr, int pPattern) {
        //匹配完成
        if (pStr == str.length() && pPattern == pattern.length()) {
            return true;
        }
        //匹配失败
        if (pStr != str.length() && pPattern == pattern.length()) {
            return false;
        }

        //模式串中下一个字符是'*'
        if (pPattern < pattern.length() - 1 && pattern.charAt(pPattern + 1) == '*') {
            //当字符匹配
            if (pStr < str.length() && (str.charAt(pStr) == pattern.charAt(pPattern) || pattern.charAt(pPattern) == '.')) {
                //代表'*'的前一字符出现一次
                return matchCore(str, pattern, pStr + 1, pPattern + 2)
                        //代表'*'的前一字符出现不止一次
                        || matchCore(str, pattern, pStr + 1, pPattern)
                        //代表'*'的前一字符出现0次
                        || matchCore(str, pattern, pStr, pPattern + 2);
            }
            //当前字符不匹配，则直接将模式串指针后移2位
            else {
                return matchCore(str, pattern, pStr, pPattern + 2);
            }
        }

        //模式串下一个字符不是'*'，当前字符串匹配则各自向后滑动一位
        if (pStr < str.length() && (str.charAt(pStr) == pattern.charAt(pPattern) || pattern.charAt(pPattern) == '.')) {
            return matchCore(str, pattern, pStr + 1, pPattern + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        Question19 question19 = new Question19();
        String str = "aaa";
        String pattern_1 = "a.a";
        String pattern_2 = "ab*ac*a";
        String pattern_3 = "aa.a";
        System.out.println(question19.match(str, pattern_1));
        System.out.println(question19.match(str, pattern_2));
        System.out.println(question19.match(str, pattern_3));
        System.out.println(question19.match("", ""));
        System.out.println(question19.match("", "a*"));
    }
}
