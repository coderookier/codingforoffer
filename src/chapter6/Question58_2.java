package chapter6;

/**
 * @author gutongxue
 * @date 2019/12/13 11:14
 * 左转字符串，把字符串前面的若干个字符转移到字符串的尾部
 **/
public class Question58_2 {
    public void leftRotateString(String str, int n) {
        if (str == null || str.length() <= 0 || n < 1) {
            return;
        }
        char[] arr = str.toCharArray();
        reverse(arr, 0, n - 1);
        reverse(arr, n, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
        StringBuilder sb = new StringBuilder();
        for (char ch : arr) {
            sb.append(ch);
        }
        System.out.println(sb);
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
        Question58_2 question58_2 = new Question58_2();
        String str = "abcdefg";
        question58_2.leftRotateString(str, 2);
    }
}
