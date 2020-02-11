package netprogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author gutongxue
 * @date 2020/2/10 16:43
 **/
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2000);
        System.out.println("服务器准备就绪----");
        System.out.println("服务器信息: " + serverSocket.getInetAddress() + "port: " + serverSocket.getLocalPort());
        for (; ; ) {
            //等待客户端连接
            Socket client = serverSocket.accept();
            //客户端构建异步线程
            ClientHandler clientHandler = new ClientHandler(client);
            //启动线程
            clientHandler.start();
        }
    }

    private static class ClientHandler extends Thread {
        //client
        private Socket socket;
        private boolean flag = true;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            super.run();
            System.out.println("客户端连接: " + socket.getInetAddress() + "port: " + socket.getPort());

            try {
                //得到打印流，用于服务器输出，服务器回送数据
                PrintStream socketOutput = new PrintStream(socket.getOutputStream());

                //得到输入流
                BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                do {
                    //从客户端拿到一条数据
                    String str = socketInput.readLine();
                    if ("bye".equalsIgnoreCase(str)) {
                        flag = false;
                        //回送
                        socketOutput.println("bye");
                    } else {
                        //打印到屏幕并回送数据长度
                        System.out.println(str);
                        socketOutput.println("回送: " + str.length());
                    }
                } while (flag);
                socketInput.close();
                socketOutput.checkError();

            } catch (Exception e) {
                System.out.println("连接异常断开");
            } finally {
                //连接关闭
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("客户端关闭: " + socket.getInetAddress() + "port: " + socket.getPort());
        }

    }
}
