package server.network;

import java.net.Socket;

import server.Server;
import util.Person;
import data.Cease;
import data.Join;
import data.JoinFailed;
import data.Login;
import data.LoginFailed;
import data.Start;
import data.TradeData;

/**
 * サーバ側受信ロジッククラス
 */
public class ServerLogic {

    public void readData(Socket socket, TradeData data, int id) {
        if (data == null) {
            return;
        }

        if (data instanceof Login) {
            Login login = (Login)data;
            if (Server.serverModel.getUserList().canLogin(login.name)) {
                Person visitor = Server.serverModel.userList.getUser(id);
                visitor.setName(login.name);
                Server.loungeModel.addVisitor(visitor);
                Server.serverModel.sendAll(Server.loungeModel.getLoungeData());
            } else {
                Server.serverModel.send(new LoginFailed(), id);
            }
        } else if (data instanceof Join) {
            if (Server.loungeModel.canJoin()) {
                Server.serverModel.send(new Join(), id);

                Server.loungeModel.join(id);
                Server.serverModel.sendAll(Server.loungeModel.getLoungeData());
            } else {
                Server.serverModel.send(new JoinFailed(), id);
            }
        } else if (data instanceof Cease) {
            Server.loungeModel.cease(id);
            Server.serverModel.sendAll(Server.loungeModel.getLoungeData());
        } else if (data instanceof Start) {
            Server.loungeModel.startGame();
            Server.serverModel.sendAll(new Start());

        }
    }
}
