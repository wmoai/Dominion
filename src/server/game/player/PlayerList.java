package server.game.player;

import java.util.ArrayList;
import java.util.List;

import util.Person;


public class PlayerList {

    private List<Player> players;

    public PlayerList(List<Person> userList) {
        players = new ArrayList<Player>();

        for (int count = 0; count < userList.size(); count++) {
            Player player = new Player(count, userList.get(count));
            players.add(player);
        }
    }

}
