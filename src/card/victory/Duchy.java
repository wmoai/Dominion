package card.victory;

import old_game.Rule;
import card.Card;
import card.VictoryCard;

public class Duchy extends Card implements VictoryCard {

    public Duchy() {
        super();
        this.id = Rule.DUCHY;
        this.cost = 5;
        this.name = "公領";
        this.imagePath = "./dominionPics/sp2_gross.jpg";
    }


    public int getVictoryPoint() {
        return 3;
    }

}
