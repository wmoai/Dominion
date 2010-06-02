package card.victory;

import old_game.Rule;
import card.Card;
import card.VictoryCard;

public class Curse extends Card implements VictoryCard {

    public Curse() {
        super();
        this.id = Rule.CURSE;
        this.cost = 0;
        this.name = "呪い";
        this.imagePath = "./dominionPics/fluch_gross.jpg";
    }


    public int getVictoryPoint() {
        return -1;
    }


}
