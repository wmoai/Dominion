package util;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import old_game.Main;
import old_game.Rule;

import server.game.player.Player;
import card.Card;

public class BuyListener implements ActionListener {

    private int cardId;

    public BuyListener(int cardId) {
        super();
        this.cardId = cardId;
    }

    public void actionPerformed(ActionEvent e) {
        if (Main.game.isGameOver()) {
            System.out.println("Game Over !");
            return;
        }

        Player player = Main.game.getPlayPlayer();
        if (!player.canBuy(Rule.getCard(cardId))) {
            return;
        }

        Card card = Main.game.field.cards.get(cardId).getTop();

        if (card == null) {
            return;
        }

        player.addDiscarded(card);

        player.turnEnd();
        Main.game.goAheadTurn();
        Main.game.play();

    }

}
