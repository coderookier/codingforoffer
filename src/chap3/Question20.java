package chap3;

/**
 * @author gutongxue
 * @date 2019/10/7 13:51
 * 实现一个函数用来判断字符串是否表示数值（包括整数和小数）
 * 表示数值的字符串遵循模式A[.[B]][E|eC]或者.B[E|eC]
 * 其中A为数值的整数部分，B为小数部分，C为指数部分，A和C都是整数，可以有正负号也可以没有，B是没有正负号的整数
 **/
public class Question20 {
    /**
     * 滑动指针
     */
    public int point = 0;
    public boolean isNumeric(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }

        //整数部分A
        boolean numeric = scanInteger(str);
        //遍历到了'.'，则接下来是小数部分B
        if (point < str.length() && str.charAt(point) == '.') {
            point++;
            //整数和小数部分至少存在一个
            numeric = scanUnsignedInteger(str) || numeric;
        }
        //遍历到了'e'或者'E'，则接下来是指数部分C
        if (point < str.length() && (str.charAt(point) == 'e' || str.charAt(point) == 'E')) {
            point++;
            //e的底数和指数必须同时存在
            numeric = scanInteger(str) && numeric;
        }
        //遍历结束且完全匹配
        return numeric && (point == str.length());
    }

    /**
     * 扫描A和C部分，主要是处理正负号
     */
    private boolean scanInteger(String str) {
        if (point < str.length() && (str.charAt(point) == '+' || str.charAt(point) == '-')) {
            point++;
        }
        return scanUnsignedInteger(str);
    }

    /**
     * 处理A和C纯数字部分和B
     */
    boolean scanUnsignedInteger(String str) {
        //
        int before = point;
        while (point < str.length() && str.charAt(point) >= '0' && str.charAt(point) <= '9') {
            point++;
        }
        //存在数字
        return point > before;
    }

    public static void main(String[] args) {
        Question20 question20 = new Question20();
        //true,true,true,false,false,true
        String str1 = "-3.1416";
        String str2 = ".12";
        String str3 = "12.";
        String str4 = "12.E";
        String str5 = "E5";
        String str6 = "12.36E+4";
        //System.out.println(question20.isNumeric(str1));
        System.out.println(question20.isNumeric(str2));
        //System.out.println(question20.isNumeric(str3));
        //System.out.println(question20.isNumeric(str4));
        //System.out.println(question20.isNumeric(str5));
        //System.out.println(question20.isNumeric(str6));
    }
}
