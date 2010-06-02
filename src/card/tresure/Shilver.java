package card.tresure;

import old_game.Rule;
import card.Card;
import card.TresureCard;

public class Shilver extends Card implements TresureCard {

    public Shilver() {
        super();
        this.id = Rule.SHILVER;
        this.cost = 3;
        this.name = "銀貨";
        this.imagePath = "./dominionPics/geld2_gross.jpg";
    }


    public int getCoin() {
        return 2;
    }

}
