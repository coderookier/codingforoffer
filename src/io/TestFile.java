package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author gutongxue
 * @date 2019/11/2 14:49
 **/
public class TestFile {
    public static void main(String[] args) throws IOException{
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //创建字节输入流
            fileInputStream = new FileInputStream("D:\\demo.txt");
            //创建字节输出流
            fileOutputStream = new FileOutputStream("D:\\ouput.txt");
            byte[] b = new byte[1024];
            //用于保存实际的字节数
            int hasRead = 0;
            //循环重复取水过程
            while ((hasRead = fileInputStream.read(b)) > 0) {
                //读多少写多少
                fileOutputStream.write(b,0,hasRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
            fileOutputStream.close();
        }
    }
}
