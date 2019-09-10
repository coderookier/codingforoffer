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
    public void replaceBlank(StringBuffer sb) {
        if (sb == null || sb.length() <= 0) {
            return;
        }
        int originLen = sb.length();
        //扫描一次，记录空格数
        int spaceNum = 0;
        for (int i = 0; i < originLen; i++) {
            if (sb.charAt(i) == ' ') {
                spaceNum++;
            }
        }
        //不存在空格，直接返回
        if (spaceNum == 0) {
            return;
        }
        int resizeLen = originLen + spaceNum * 2;
        //指向原字符串最后一位的指针
        int indexOfOrigin = originLen - 1;
        //指向替换后的字符串最后一位
        int indexOfNew = resizeLen - 1;

        while (indexOfOrigin >= 0 && indexOfOrigin < indexOfNew) {

            //当前indexOfOrigin所指字符是空格
            //indexOfNew所指位置依次移动插入'0','2','%'
            if (sb.charAt(indexOfOrigin) == ' ') {
                sb.setCharAt(indexOfNew--, '0');
                sb.setCharAt(indexOfNew--, '2');
                sb.setCharAt(indexOfNew--, '%');
            }
            //当前字符不是空格，则将该字符放到indexOfNew所指位置
            else {
                sb.setCharAt(indexOfNew--, sb.charAt(indexOfOrigin));
            }
            indexOfOrigin--;
        }
    }
}
