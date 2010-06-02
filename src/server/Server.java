package server;

import server.game.DominionModel;
import server.network.LoungeModel;
import server.network.ServerModel;
import server.network.ServerThread;



public class Server {

    public static ServerModel serverModel;
    public static LoungeModel loungeModel;
    public static DominionModel dominionModel;

    private static ServerThread serverThread;

    public static void main(String[] args) {
        System.out.println("サーバ開始");
        serverModel = new ServerModel();
        loungeModel = new LoungeModel();

        serverThread = new ServerThread();
    }

}
