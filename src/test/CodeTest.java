package test;

/**
 * @author gutongxue
 * @date 2020/1/30 16:41
 **/
public class CodeTest {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0x0000;i <= 0xffff;i++){
            char res = (char)i;
            if (count == 20){
                count = 0;
                System.out.println();
            }
            System.out.print(i + ":" + res + " ");
            count++;
        }
    }
}
