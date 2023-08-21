package ua.com.yugo;

import java.net.ServerSocket; // библиотека для создания серверного соединения
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8081); // устанавливаем порт на сервере, порт может быть любой
        Socket input = serverSocket.accept(); // чтоб принять на вход соединение и создать объект сокета, теперь наши сокеты соединяться
        Scanner in = new Scanner(input.getInputStream()); // чтоб прочитать принятую инфо подключаем сканер
        while (in.hasNext()) { // читаем пока что-то есть, не одно сообщение
            System.out.println(in.nextLine());  // выводим, то что приходит
        }
        in.close(); // закрываем сканер
        input.close(); // закрываем соединение
        serverSocket.close();   // закрываем порт
    }
}
