package data;

import java.util.ArrayList;
import java.util.List;

public class Lounge extends TradeData {

    private static final long serialVersionUID = -4046607341994455127L;

    public List<String> visitorList;
    public List<String> playerList;

    public boolean canStart;
    public boolean gameFlg;

    public Lounge() {
        visitorList = new ArrayList<String>();
        playerList = new ArrayList<String>();

        canStart = false;
        gameFlg = false;
    }
}
