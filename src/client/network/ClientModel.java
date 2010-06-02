package client.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import data.TradeData;

public class ClientModel {

    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    private Reception reception;

    public ClientModel(Socket socket) {
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
            oos.close();
            ois.close();
            socket.close();
            System.out.println("接続切断");
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

        private ClientLogic logic;

        public Reception() {
            logic = new ClientLogic();
            setDaemon(true);

            start();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    TradeData data = (TradeData)ois.readObject();
                    System.out.println("データ受信:" + data.getClass());
                    logic.readData(data);
                } catch (Exception e) {
                    System.out.println("受信中に例外");
                    e.printStackTrace();
                    break;
                }
            }
        }
    }}
