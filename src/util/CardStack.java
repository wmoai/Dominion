package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import card.Card;

public class CardStack {

    private List<Card> cardStack;

    public CardStack() {
        cardStack = new ArrayList<Card>();
    }

    public void putTop(Card card) {
        cardStack.add(0, card);
    }

    public Card getTop() {
        if (cardStack.size() == 0) {
            return null;
        }
        Card card = cardStack.get(0);
        cardStack.remove(0);

        return card;
    }

    public Card getRandom() {
        if (cardStack.size() == 0) {
            return null;
        }
        Random random = new Random();

        int randomIndex = random.nextInt(cardStack.size());
        Card card = cardStack.get(randomIndex);
        cardStack.remove(randomIndex);

        return card;
    }

    public boolean hasCard() {
        if (cardStack.size() == 0) {
            return false;
        }
        return true;
    }

    public int getNumberOfCards() {
        return cardStack.size();
    }

//    public Card lookTop() {
//        if (cardStack.size() == 0) {
//            return null;
//        }
//        return cardStack.get(0);
//    }
}
