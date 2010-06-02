package card.victory;

import old_game.Rule;
import card.Card;
import card.VictoryCard;

public class Province extends Card implements VictoryCard {

    public Province() {
        super();
        this.id = Rule.PROVINCE;
        this.cost = 8;
        this.name = "属州";
        this.imagePath = "./dominionPics/sp3_gross.jpg";
    }


    public int getVictoryPoint() {
        return 6;
    }

}
