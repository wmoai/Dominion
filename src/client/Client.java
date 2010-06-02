package client;

import java.net.Socket;

import client.frame.ConnectDialog;
import client.frame.LoginDialog;
import client.frame.LoungeFrame;
import client.frame.game.DominionFrame;
import client.network.ClientModel;


public class Client {

    public static ClientModel clientModel;
    public static ConnectDialog connectDialog;
    public static LoginDialog loginDialog;
    public static LoungeFrame loungeFrame;
    public static DominionFrame dominionFrame;

    public static void main(String[] args) {
        try {
            connectDialog = new ConnectDialog();
            String[] input = connectDialog.getInput();
            Socket socket = new Socket(input[0],Integer.parseInt(input[1]));
//            Socket socket = new Socket("localhost",5555);

            clientModel = new ClientModel(socket);

        } catch (Exception e) {
            System.out.println("接続失敗");
            e.printStackTrace();
        }

        loginDialog = new LoginDialog();
    }

}
