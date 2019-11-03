package io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author gutongxue
 * @date 2019/11/2 14:49
 **/
public class TestFile {
    public static void main(String[] args) throws IOException{
        FileInputStream fileInputStream = null;
        try {
            //创建字节输入流
            fileInputStream = new FileInputStream("D:\\demo.txt");
            int hasRead = 0;
            //循环重复取水过程
            while ((hasRead = fileInputStream.read()) > 0) {
                //读多少写多少
                System.out.println(hasRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
        }
    }
}
