package server.network;

import java.net.Socket;

import util.Person;
import util.UserList;
import data.TradeData;

public class ServerModel {

    public UserList userList;
    private static int userNumber = 0;

    public ServerModel() {
        userList = new UserList();
    }

    /**
     * ユーザを追加します。
     * @param socket ユーザのソケット
     */
    public void addUser(Socket socket) {
        Person user = new Person(socket, getUserNumber());
        userList.addUser(user);
    }

    private int getUserNumber() {
        userNumber += 1;
        return userNumber;
    }

    public UserList getUserList() {
        return this.userList;
    }

    public void send(TradeData data, int id) {
        userList.getUser(id).getConnection().send(data);
    }

    public void sendAll(TradeData data) {
        for (Person user : userList.getAllUser()) {
            user.getConnection().send(data);
        }
    }

}
