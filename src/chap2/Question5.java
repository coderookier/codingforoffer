package chap2;

/**
 * @author gutongxue
 * @date 2019/9/9 19:50
 **/

/**
 * 将字符串中空格替换成%20
 * 要求字符串长度可以手动设置，使用StringBuffer
 * 分析可知，每存在一个空格，字符串长度+2
 */

public class Question5 {
    /**
     * 时间复杂度O(N)
     * @param sb
     */
    public String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0) {
            return str.toString();
        }
        //统计字符串中的空格数
        int numOfSpace = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                numOfSpace++;
            }
        }
        //没有空格直接返回
        if (numOfSpace == 0) {
            return str.toString();
        }
        StringBuffer sb = new StringBuffer();
        sb.setLength(str.length() + 2 * numOfSpace);
        int index1 = str.length() - 1, index2 = sb.length() - 1;
        //从后往前遍历，并将字符逐个存放到index2对应位置
        while (index1 >= 0 && index2 >= 0) {
            //遍历原字符串到空格，则在新字符串指定位置存放%20
            if (str.charAt(index1) == ' ') {
                sb.setCharAt(index2--, '0');
                sb.setCharAt(index2--, '2');
                sb.setCharAt(index2--, '%');
                index1--;
            }
            //原字符串没有空格位置直接将字符存放到新字符串指定位置
            while (index1 >= 0 && index2 >= 0 && str.charAt(index1) != ' ') {
                sb.setCharAt(index2--, str.charAt(index1--));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Question5 question5 = new Question5();
        StringBuffer sb = new StringBuffer("We Are Happy");
        System.out.println(question5.replaceSpace(sb));
    }
}
