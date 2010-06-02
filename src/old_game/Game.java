package old_game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;

import javax.swing.JFrame;

import server.game.player.Player;
import card.Card;
import card.victory.Estate;

public class Game {

    private DominionFrameOld frame;

    public List<Player> players;
    public Field field;
    public int turn;

    /**
     * コンストラクタ
     */
    public Game() {
        field = new Field();

        players = new ArrayList<Player>();
        createPlayer("1P");
        createPlayer("2P");
        createPlayer("3P");
        createPlayer("4P");

        frame = new DominionFrameOld("Dominion");
    }

    /**
     * プレーヤを生成します�?
     * @param name プレーヤ�?
     */
    private void createPlayer(String name) {
//        Player player = new Player(name);
//
//        for (int i = 0; i < 7; i++) {
//            player.addDeck(field.cards.get(Rule.COPPER).getTop());
//        }
//        for (int i = 0; i < 3; i++) {
//            player.addDeck(field.cards.get(Rule.ESTATE).getTop());
//        }
//        player.shaffleDeck();
//        player.initializeHand();
//
//        players.add(player);
    }

    /**
     * ゲー�??レイ
     */
    public void play() {


//        while (!isGameOver()) {
//
//            for (Player player : players) {
//                System.out.println(player.name);
//                for (Card card : player.hand) {
//                    System.out.print("[" + card.getName() + "]");
//                }
//
//                buyPhase(player);
//
//                player.turnEnd();
//            }
//
//        }
//        Player player = players.get(turn);
//        frame.drawScreen(field, players);
//        System.out.println(player.name);

    }

    private void buyPhase(Player player) {

//        String input = getInput();
//        int cardNumber = Integer.valueOf(input);


    }

    public boolean isGameOver() {
        if (field.cards.get(Rule.PROVINCE).getNumberOfCards() == 0) {
            return true;
        }
        return false;
    }

    private String getInput() {
        String result = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            result = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Player getPlayPlayer() {
        return players.get(turn);
    }

    public void goAheadTurn() {
        if (turn == 3) {
            turn = 0;
        } else {
            turn++;
        }
    }
}
