package card.victory;

import old_game.Rule;
import card.Card;
import card.VictoryCard;

public class Estate extends Card implements VictoryCard {

    public Estate() {
        super();
        this.id = Rule.ESTATE;
        this.cost = 2;
        this.name = "屋敷";
        this.imagePath = "./dominionPics/sp1_gross.jpg";
    }


    public int getVictoryPoint() {
        return 1;
    }


}
