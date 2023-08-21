package ua.com.yugo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;         // само соединение между двумя точками

public class ClientSocket {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8081); // передаем адрес и порт сервера
        PrintWriter out = new PrintWriter(socket.getOutputStream()); // записываем данные, которые нужно отправить на поток
        out.println("Hello server!");
        out.println("How are you?");
        out.close();
        socket.close();
    }
}