package redis;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author dengmingliang
 * @Description
 * @ClassName RedisServerDemo
 * @Date 2019/12/22 8:35 下午
 */
public class RedisServerDemo {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6378);
            Socket socket = serverSocket.accept();
            InputStream stream = socket.getInputStream();

            byte[] temp = new byte[80];
            stream.read(temp);
            String str = new String(temp, "UTF-8");
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
