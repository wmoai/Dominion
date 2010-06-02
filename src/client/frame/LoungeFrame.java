package client.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import client.Client;
import data.Cease;
import data.Join;
import data.Lounge;
import data.Start;

public class LoungeFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -1727870920165264879L;

    private JScrollPane visitorPanel;
    private JScrollPane playerPanel;

    private JButton joinBtn;
    private JButton ceaseBtn;
    private JButton startBtn;

    /**
     * コンストラクタ
     * �?��ンポ�?ネント�?期化
     */
    public LoungeFrame() {
        super("Lounge");

        setBounds(100,100,320,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel();
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.LEFT);
        topPanel.setLayout(fl);
        topPanel.setPreferredSize(new Dimension(40, 40));

        joinBtn = new JButton("参加");
        joinBtn.setPreferredSize(new Dimension(60, 25));
        joinBtn.addActionListener(new JoinListener());
        topPanel.add(joinBtn);

        ceaseBtn = new JButton("退室");
        ceaseBtn.setPreferredSize(new Dimension(60, 25));
        ceaseBtn.addActionListener(new CeaseListener());
        ceaseBtn.setEnabled(false);
        topPanel.add(ceaseBtn);

        startBtn = new JButton("開始");
        startBtn.setPreferredSize(new Dimension(60, 25));
        startBtn.addActionListener(new StartListener());
        startBtn.setEnabled(false);
        topPanel.add(startBtn);

        JPanel mainPanel = new JPanel();
        FlowLayout fl2 = new FlowLayout();
        fl2.setAlignment(FlowLayout.CENTER);
        mainPanel.setLayout(fl2);
        mainPanel.setPreferredSize(new Dimension(400, 400));

        visitorPanel = new JScrollPane();
        visitorPanel.setPreferredSize(new Dimension(150, 300));
        mainPanel.add(visitorPanel);

        playerPanel = new JScrollPane();
        playerPanel.setPreferredSize(new Dimension(150, 300));
        mainPanel.add(playerPanel);

        add(topPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * ラウンジフレー�?��描きま�?
     * @param data ラウンジ�??タ
     */
    public void drawLounge(final Lounge data) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JList visitorList = new JList(data.visitorList.toArray());
                JList playerList = new JList(data.playerList.toArray());
                if (data.gameFlg) {
                    playerList.setEnabled(false);
                }

                visitorPanel.getViewport().setView(visitorList);
                playerPanel.getViewport().setView(playerList);

                if (data.canStart) {
                    startBtn.setEnabled(true);
                } else {
                    startBtn.setEnabled(false);
                }
            }
        });
    }

    /**
     * 参加ボタンを有効にします�?
     */
    public void setJoinBtnEnable() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                joinBtn.setEnabled(true);
            }
        });
    }

    /**
     * �?��ボタンを有効にします�?
     */
    public void setCeaseBtnEnable() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ceaseBtn.setEnabled(true);
            }
        });
    }

    /**
     * こ�?フレー�?��不可視化します�?
     */
    public void setInvisible() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                setVisible(false);
            }
        });
    }

    /**
     * 参加アクションクラス�?
     */
    class JoinListener implements ActionListener {
       public void actionPerformed(ActionEvent e) {
           joinBtn.setEnabled(false);
           Client.clientModel.send(new Join());
        }
    }

    /**
     * �?��アクションクラス
     */
    class CeaseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ceaseBtn.setEnabled(false);
            joinBtn.setEnabled(true);
            Client.clientModel.send(new Cease());
        }
    }

    /**
     * ゲー�?��始アクションクラス
     */
    class StartListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Client.clientModel.send(new Start());
        }
    }

}
