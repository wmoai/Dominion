package server.network;

import java.util.ArrayList;
import java.util.List;

import util.Person;
import data.Lounge;

public class LoungeModel {

    /** 訪問者リスト */
    private List<Person> visitorList;
    /** プレーヤリスト */
    private List<Person> playerList;
    /** ゲーム開始フラグ true:ゲーム中 false:ゲーム未開始 */
    private boolean game;

    /**
     * コンストラクタ
     */
    public LoungeModel() {
        visitorList = new ArrayList<Person>();
        playerList = new ArrayList<Person>();
        game = false;
    }

    public void addVisitor(Person user) {
        visitorList.add(user);
    }

    public void removeUser(int id) {
        for (Person visitor : visitorList) {
            if (visitor.getId() == id) {
                visitorList.remove(visitor);
                return;
            }
        }
        for (Person player : playerList) {
            if (player.getId() == id) {
                playerList.remove(player);
                return;
            }
        }
    }

    /**
     * 通信用ラウンジ�??タを取得します�?
     * @return ラウンジ�??タ
     */
    public Lounge getLoungeData() {
        Lounge lounge = new Lounge();
        for (Person visitor : visitorList) {
            lounge.visitorList.add(visitor.getName());
        }

        for (Person player : playerList) {
            lounge.playerList.add(player.getName());
        }

        lounge.canStart = canStart();
        lounge.gameFlg = game;

        return lounge;
    }

    /**
     * 参加可能か判断します�?
     * @return 参加可否
     */
    public boolean canJoin() {
        if (playerList.size() == 4) {
            return false;
        }
        return true;
    }

    /**
     * ビジター �?プレーヤ
     * @param id
     */
    public void join(int id) {
        for (Person visitor : visitorList) {
            if (visitor.getId() == id) {
                playerList.add(visitor);

                visitorList.remove(visitor);
                return;
            }
        }
    }

    /**
     * プレーヤ �?ビジター
     */
    public void cease(int id) {
        for (Person player : playerList) {
            if (player.getId() == id) {
                visitorList.add(player);

                playerList.remove(player);
                return;
            }
        }
    }

    /**
     * 開始可否を判定します�?
     * @return 開始可否
     */
    public boolean canStart() {
        if (playerList.size() > 1) {
            return true;
        }
        return false;
    }

    /**
     * ゲー�?��始フラグを立てます�?
     */
    public void startGame() {
        this.game = true;
    }
}
