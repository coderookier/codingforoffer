package chapter5;

/**
 * @author gutongxue
 * @date 2019/11/20 15:11
 * 把数字按照规则翻译成字符串，总共有多少种翻译方法0~25分别对应a~z
 **/
public class Question46 {
    public int getTranslationCount(int number) {
        if (number < 0) {
            return 0;
        }
        String numberInString = number + "";
        return getCount(numberInString);
    }

    private int getCount(String numberInString) {
        int len = numberInString.length();
        int dp[] = new int[len];
        //遍历当前位置时总共有多少种翻译方法
        int count = 0;
        //从右到左遍历，即自底向上，避免重复运算
        for (int i = len - 1; i >= 0; i--) {
            count = 0;
            //第一步，不考虑两个数字可以翻译成一个字母的情况，则dp[i] = dp[i + 1]
            if (i < len - 1) {
                count = dp[i + 1];
            }
            else {
                count = 1;
            }
            //第二步，考虑两个数字可以翻译成一个字母的情况，需要进行判断
            if (i < len - 1) {
                String tempStr = numberInString.substring(i, i + 2);
                //这两个位置数字大小
                int temp = Integer.parseInt(tempStr);
                if (temp >= 10 && temp <= 25) {
                    if (i < len - 2) {
                        count += dp[i + 2];
                    }
                    else {
                        count += 1;
                    }
                }
            }
            dp[i] = count;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Question46 question46 = new Question46();
        System.out.println(question46.getTranslationCount(12258));
        System.out.println(question46.getTranslationCount(0));
        System.out.println(question46.getTranslationCount(-5));
    }
}
