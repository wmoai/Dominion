package server.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import server.Server;

public class ServerThread extends Thread {

    private ServerSocket serverSocket;

    public ServerThread() {

        try {
            serverSocket = new ServerSocket(5555);

            start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("接続：" + socket.getInetAddress());

                //ユーザを追�?
                Server.serverModel.addUser(socket);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("メインスレッド終了");
                break;
            }
        }
    }
}
