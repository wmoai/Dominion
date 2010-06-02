package util;

import java.util.ArrayList;
import java.util.List;

import server.Server;


public class UserList {

    private List<Person> users;

    public UserList() {
        users = new ArrayList<Person>();
    }

    public void addUser(Person user) {
        users.add(user);
    }

    public void removeUser(int id) {
        for (Person user : users) {
            if (user.getId() == id) {
                if (user.getPlace().equals(Person.LOUNGE)) {
                    Server.loungeModel.removeUser(id);
                }
                users.remove(user);
                Server.serverModel.sendAll(Server.loungeModel.getLoungeData());
                return;
            }
        }
    }

    public boolean canLogin(String name) {
        for (Person user : users) {
            if (user.getName() == null) {
                continue;
            }

            if (user.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public Person getUser(int id) {
        for (Person user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public List<Person> getAllUser() {
        return users;
    }
}
