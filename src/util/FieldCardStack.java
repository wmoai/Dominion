package util;

import old_game.Rule;
import card.Card;

public class FieldCardStack extends CardStack {

    public String name;
    public int cost;
    public String imagePath;
    public int id;

    public FieldCardStack(int id) {
        Card card = Rule.getCard(id);

        name = card.getName();
        cost = card.getCost();
        imagePath = card.getImagePath();
        this.id = id;

        for (int i = 0; i < Rule.getCardSize(id); i++) {
            putTop(Rule.getCard(id));
        }
    }
}
