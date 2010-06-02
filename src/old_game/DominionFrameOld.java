package old_game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import server.game.player.Player;
import util.BuyListener;
import util.FieldCardStack;
import util.ImageLogic;
import card.Card;


public class DominionFrameOld extends JFrame {

    public DominionFrameOld(String title) {
        super(title);
        setBounds(100, 100, 1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void drawScreen(Field field, List<Player> playerList) {
        Container contentPane = getContentPane();
        contentPane.removeAll();

        drawFixCard(field);
        drawHandCard(playerList);

        setVisible(true);
    }

    private void drawFixCard(Field field) {
        Container contentPane = getContentPane();

        JPanel fixPanel = new JPanel();
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        fixPanel.setLayout(flowLayout);
        fixPanel.setPreferredSize(new Dimension(110, 110));

        fixPanel.add(getStackCard(field.cards.get(Rule.COPPER)));
        fixPanel.add(getStackCard(field.cards.get(Rule.SHILVER)));
        fixPanel.add(getStackCard(field.cards.get(Rule.GOLD)));
        fixPanel.add(getStackCard(field.cards.get(Rule.ESTATE)));
        fixPanel.add(getStackCard(field.cards.get(Rule.DUCHY)));
        fixPanel.add(getStackCard(field.cards.get(Rule.PROVINCE)));
        fixPanel.add(getStackCard(field.cards.get(Rule.CURSE)));

        contentPane.add(fixPanel, BorderLayout.CENTER);

    }


//    private JButton getStackCard(String path, int cardId) {
    private JButton getStackCard(FieldCardStack cards) {

        JLabel label = getImageLable(cards.imagePath, 90, 90);
        label.setBounds(5,5,90,90);

        JButton card = new JButton();
        card.setLayout(null);
        card.setBackground(Color.BLACK);
        card.setPreferredSize(new Dimension(100, 100));

        JLabel cost = new JLabel(cards.cost + "");
        cost.setFont(new Font("Segoe UI", Font.BOLD, 24));
        cost.setBounds(12,57,40,40);

        JLabel num = new JLabel(cards.getNumberOfCards() + "");
        num.setFont(new Font("Segoe UI", Font.BOLD, 18));
        num.setForeground(Color.WHITE);
        num.setBounds(75,70,40,40);

        card.add(cost);
        card.add(num);
        card.add(label);

        card.addActionListener(new BuyListener(cards.id));

        return card;
    }

    private void drawHandCard(List<Player> playerList) {
        Container contentPane = getContentPane();

        JPanel handPanel = new JPanel();
        FlowLayout flowLayout2 = new FlowLayout();
        flowLayout2.setAlignment(FlowLayout.CENTER);
        handPanel.setLayout(flowLayout2);
        handPanel.setPreferredSize(new Dimension(110, 110));
        handPanel.setBackground(Color.RED);
        addCardToHandPanel(playerList.get(0), handPanel);
        contentPane.add(handPanel, BorderLayout.SOUTH);

        JPanel leftPanel = new JPanel();
        flowLayout2.setAlignment(FlowLayout.CENTER);
        leftPanel.setLayout(flowLayout2);
        leftPanel.setPreferredSize(new Dimension(110, 110));
        leftPanel.setBackground(Color.BLUE);
        addCardToHandPanel(playerList.get(1), leftPanel);
        contentPane.add(leftPanel, BorderLayout.WEST);

        JPanel topPanel = new JPanel();
        flowLayout2.setAlignment(FlowLayout.CENTER);
        topPanel.setLayout(flowLayout2);
        topPanel.setPreferredSize(new Dimension(110, 110));
        topPanel.setBackground(Color.ORANGE);
        addCardToHandPanel(playerList.get(2), topPanel);
        contentPane.add(topPanel, BorderLayout.NORTH);

        JPanel rightPanel = new JPanel();
        flowLayout2.setAlignment(FlowLayout.CENTER);
        rightPanel.setLayout(flowLayout2);
        rightPanel.setPreferredSize(new Dimension(110, 110));
        rightPanel.setBackground(Color.YELLOW);
        addCardToHandPanel(playerList.get(3), rightPanel);
        contentPane.add(rightPanel, BorderLayout.EAST);

    }

    private void addCardToHandPanel(Player player, JPanel panel) {
        for (Card card : player.hand) {
            JLabel label = getImageLable(card.getImagePath(), 90, 90);

            JButton cardBase = new JButton();
            cardBase.setLayout(null);
            cardBase.setBackground(Color.BLACK);
            cardBase.setPreferredSize(new Dimension(100, 100));

            cardBase.add(label);

            panel.add(cardBase);
        }
    }

    private JLabel getImageLable(String imagePath, int width, int height) {
        JLabel label = null;
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            ImageLogic imageLogic = new ImageLogic();
            image = imageLogic.changSize(image, width, height);

            label = new JLabel(new ImageIcon(image));
            label.setBounds(5,5, width,height);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return label;
    }
}
