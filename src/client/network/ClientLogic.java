package client.network;

import client.Client;
import client.frame.LoungeFrame;
import client.frame.game.DominionFrame;
import data.Join;
import data.JoinFailed;
import data.LoginFailed;
import data.Lounge;
import data.Start;
import data.TradeData;

/**
 * クライアント側受信ロジッククラス
 */
public class ClientLogic {

    public void readData(TradeData data) {
        if (data == null) {
            return;
        }

        if (data instanceof LoginFailed) {
            Client.loginDialog.setButtonEnable();
            System.out.println("ログイン失敗");
        } else if (data instanceof Lounge) {
            if (Client.loginDialog != null) {
                System.out.println("ログイン成功");
                Client.loginDialog.setInvisible();
                Client.loginDialog = null;

                Client.loungeFrame = new LoungeFrame();
            }
            Client.loungeFrame.drawLounge((Lounge)data);
        } else if (data instanceof Join) {
            System.out.println("参加成功");
            Client.loungeFrame.setCeaseBtnEnable();
        } else if (data instanceof JoinFailed) {
            System.out.println("参加失敗");
            Client.loungeFrame.setJoinBtnEnable();
        } else if (data instanceof Start) {
            System.out.println("ゲーム開始");
            Client.loungeFrame.setInvisible();
            Client.loungeFrame = null;

            Client.dominionFrame = new DominionFrame();
        }
    }
}
