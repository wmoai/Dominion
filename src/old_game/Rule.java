package old_game;

import card.Card;
import card.tresure.Copper;
import card.tresure.Gold;
import card.tresure.Shilver;
import card.victory.Curse;
import card.victory.Duchy;
import card.victory.Estate;
import card.victory.Province;

public class Rule {

    public static final int COPPER = 0;
    public static final int SHILVER = COPPER + 1;
    public static final int GOLD = SHILVER + 1;
    public static final int ESTATE = GOLD + 1;
    public static final int DUCHY = ESTATE + 1;
    public static final int PROVINCE = DUCHY + 1;
    public static final int CURSE = PROVINCE + 1;


    private static final int COPPER_NUM = 60;
    private static final int SHILVER_NUM = 40;
    private static final int GOLD_NUM = 30;

    private static final int ESTATE_NUM = 24;
    private static final int DUCHY_NUM = 12;
    private static final int PROVINCE_NUM = 12;
    private static final int CURSE_NUM = 30;

    private static final int KINGDOM_NUM = 10;

    public static Card getCard(int id) {
        switch (id) {
            case COPPER:
                return new Copper();
            case SHILVER:
                return new Shilver();
            case GOLD:
                return new Gold();
            case ESTATE:
                return new Estate();
            case DUCHY:
                return new Duchy();
            case PROVINCE:
                return new Province();
            case CURSE:
                return new Curse();

            default:
                return null;
        }
    }

    public static int getCardSize(int id) {
        switch (id) {
            case COPPER:
                return COPPER_NUM;
            case SHILVER:
                return SHILVER_NUM;
            case GOLD:
                return GOLD_NUM;
            case ESTATE:
                return ESTATE_NUM;
            case DUCHY:
                return DUCHY_NUM;
            case PROVINCE:
                return PROVINCE_NUM;
            case CURSE:
                return CURSE_NUM;

            default:
                return 0;
        }
    }
}
