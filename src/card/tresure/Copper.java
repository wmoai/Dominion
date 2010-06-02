package card.tresure;

import old_game.Rule;
import card.Card;
import card.TresureCard;


public class Copper extends Card implements TresureCard {

    public Copper() {
        super();
        this.id = Rule.COPPER;
        this.cost = 0;
        this.name = "銅貨";
        this.imagePath = "./dominionPics/geld1_gross.jpg";
    }


    public int getCoin() {
        return 1;
    }

}
