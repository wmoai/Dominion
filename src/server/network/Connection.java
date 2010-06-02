package server.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import server.Server;
import data.TradeData;

public class Connection {

    private Socket socket;
    private int id;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    private Reception reception;

    public Connection(Socket socket, int id) {
        this.id = id;
        this.socket = socket;

        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            System.out.println("接続中に例外");
        }

        reception = new Reception();
    }

    public void send(TradeData data) {
        try {
            oos.writeObject(data);
            oos.flush();
            System.out.println("データ送信:" + data.getClass());
        } catch (IOException e) {
            System.out.println("送信中に例外");
            e.printStackTrace();
        }
    }

    public void terminate() {
        try {
            Server.serverModel.userList.removeUser(id);
            oos.close();
            ois.close();
            socket.close();
            System.out.println("スレッド終了");
        } catch (Exception e) {
            System.out.println("スレッド終了中に例外");
            e.printStackTrace();
        }
    }


    /**
     * 入力受付スレッド
     * @author tk
     */
    private class Reception extends Thread {
        private ServerLogic logic;

        public Reception() {
            logic = new ServerLogic();

            setDaemon(true);
            start();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    TradeData data = (TradeData)ois.readObject();
                    System.out.println("データ受信:" + data.getClass());
                    logic.readData(socket, data, id);
                } catch (Exception e) {
                    System.out.println("受信中に例外、接続切断");
                    break;
                }
            }
            terminate();
        }
    }
}
