package server.game.player;

import java.util.ArrayList;
import java.util.List;

import util.CardStack;
import util.Person;

import card.Card;
import card.TresureCard;

public class Player {

    private int playerId;

    private Person user;

    /** 山札 */
    private CardStack deck;

    /** 捨て札 */
    private CardStack discarded;

    /** 手札 */
    public List<Card> hand;

    public Player(int id, Person user) {
        this.playerId = id;
        this.user = user;

        deck = new CardStack();
        discarded = new CardStack();

        hand = new ArrayList<Card>();
    }

    /**
     * プレーヤ�??を取�?
     * @return プレーヤ�??
     */
    public Person getUser() {
        return user;
    }

    /**
     * �?��キからカードを�?��引きます�?
     */
    public void drawCard() {
        if (!deck.hasCard()) {
            discardedToDeck();
        }

        hand.add(deck.getTop());
    }

    /**
     * �?��キの�?��上ににカードを�?��ます�?
     * @param card カー�?
     */
    public void addDeck(Card card) {
        deck.putTop(card);
    }

    public void addDiscarded(Card card) {
        discarded.putTop(card);
    }

    /**
     * 捨て札から�?��キを作ります�?
     */
    private void discardedToDeck() {
        while (discarded.hasCard()) {
            deck.putTop(discarded.getRandom());
        }
    }

    /**
     * �?��キを繰ります�?
     */
    public void shaffleDeck() {
        for (int i = 0; i < 10000; i++) {
            deck.putTop(deck.getRandom());
        }
    }

    /**
     * 手札をドローします�?
     */
    public void initializeHand() {
        for (int i = 0; i < 5; i++) {
            drawCard();
        }
    }

    /**
     * 自ターンを終�?��ます�?
     */
    public void turnEnd() {
        for (Card card : hand) {
            discarded.putTop(card);
        }

        hand.clear();
        initializeHand();
    }

    public int getCoins() {
        int result = 0;

        for (Card card : hand) {
            if(!(card instanceof TresureCard)) {
                continue;
            }

            result += ((TresureCard)card).getCoin();
        }

        return result;
    }

    public boolean canBuy(Card card) {
        if (getCoins() >= card.getCost()) {
            return true;
        }
        return false;
    }
}
