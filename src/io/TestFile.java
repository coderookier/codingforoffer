package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author gutongxue
 * @date 2019/11/2 14:49
 **/
public class TestFile {
    public static void main(String[] args) throws IOException{
        String path = "D:\\userfiles\\lala\\hehe\\test.txt";
        File file = new File(path);
        if (file.getParentFile() != null || !file.getParentFile().isDirectory()) {
            file.getParentFile().mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
    }
}
