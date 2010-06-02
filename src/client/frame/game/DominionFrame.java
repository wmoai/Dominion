package client.frame.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DominionFrame extends JFrame {

    private static final long serialVersionUID = 2884872171322673437L;

    private JPanel mainPanel;
    private JPanel handPanel;
    private JPanel systemPanel;

    public DominionFrame() {
        super("Dominion");

        setBounds(100,100,1024,768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(30, 500));
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.RED);
        add(mainPanel, BorderLayout.NORTH);

        handPanel = new JPanel();
        handPanel.setPreferredSize(new Dimension(30, 280));
        handPanel.setBackground(Color.YELLOW);
        add(handPanel, BorderLayout.CENTER);

        systemPanel = new JPanel();
        systemPanel.setPreferredSize(new Dimension(30, 40));
        systemPanel.setBackground(Color.WHITE);
        add(systemPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

}
