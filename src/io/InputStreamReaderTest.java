package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author gutongxue
 * @date 2019/11/3 15:19
 **/
public class InputStreamReaderTest {
    public static void main(String[] args) throws IOException {
        try {
            //将System.in对象转化为Reader对象
            //System.in为标准输入流InputStream类的实例
            InputStreamReader reader = new InputStreamReader(System.in);
            //将普通的reader包装秤BufferedReader
            BufferedReader bufferedReader = new BufferedReader(reader);
            String buffer = null;
            while ((buffer = bufferedReader.readLine()) != null) {
                //读到字符串为"exit"，则程序退出
                if (buffer.equals("exit")) {
                    System.exit(1);
                }
                //打印读取的内容
                System.out.println("输入内容: " + buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
