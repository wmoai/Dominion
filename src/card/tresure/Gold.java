package card.tresure;

import old_game.Rule;
import card.Card;
import card.TresureCard;

public class Gold extends Card implements TresureCard {

    public Gold() {
        super();
        this.id = Rule.GOLD;
        this.cost = 6;
        this.name = "金貨";
        this.imagePath = "./dominionPics/geld3_gross.jpg";
    }


    public int getCoin() {
        return 3;
    }

}
