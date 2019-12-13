package Chapter6;

/**
 * @author gutongxue
 * @date 2019/12/12 21:55
 * 翻转句子中单词顺序
 * 先翻转整个句子，后分别翻转每个单词（单词包括与其相连的标点符号）
 **/
public class Question58 {

    public void reverseSentence(String str) {
        //先将字符串转为字符数组方便操作
        char[] arr = str.toCharArray();
        //翻转整个句子
        reverse(arr, 0, str.length() - 1);
        for (char ch : arr) {
            System.out.print(ch);
        }
        System.out.println();
        //依次翻转每个单词
        int begin = 0, end;
        for (int i = 0; i < arr.length; i++) {
            //分隔单词，翻转
            if (arr[i] == ' ' || i == arr.length - 1) {
                if (i == arr.length - 1) {
                    end = i;
                }
                else {
                    end = i - 1;
                }
                //翻转这个单词
                reverse(arr, begin, end);
                begin = i + 1;
            }
            //已全部翻转
            if (begin >= arr.length) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : arr) {
            sb.append(ch);
        }
        System.out.println(sb.toString());
    }
    public void reverse(char[] arr, int begin, int end) {
        while (begin < end) {
            swap(arr, begin, end);
            begin++;
            end--;
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Question58 question58 = new Question58();
        String str = "I am a student.";
        question58.reverseSentence(str);
    }
}
