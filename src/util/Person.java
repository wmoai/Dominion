package util;

import java.net.Socket;

import server.network.Connection;



public class Person {

    public static final String LOUNGE = "lunge";
    public static final String GAME = "game";

    private int id;
    private String name;
    private String place;
    private Connection connection;

    public Person(Socket socket, int id) {
        this.id = id;
        place = LOUNGE;
        connection = new Connection(socket, id);
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Connection getConnection() {
        return connection;
    }






}
