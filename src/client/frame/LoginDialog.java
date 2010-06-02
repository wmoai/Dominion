package client.frame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import client.Client;
import data.Login;

public class LoginDialog extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = -1195755263610858436L;

    private JTextField nameArea;
    private JButton btn;

    public LoginDialog() {
        super("Enter your name");

        setBounds(100,100,200,100);
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.CENTER);
        setLayout(flowLayout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nameArea = new JTextField(15);

        btn = new JButton("Login");
        btn.addActionListener(this);

        add(nameArea);
        add(btn);

        setVisible(true);
    }

    /**
     * ボタン押下時、ログインします。
     */
    public void actionPerformed(ActionEvent e) {
        btn.setEnabled(false);
        try {
            Login data = new Login();
            data.name = nameArea.getText();

            Client.clientModel.send(data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * ボタンを使用可能にします。
     */
    public void setButtonEnable() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                btn.setEnabled(true);
            }
        });
    }

    /**
     * こ�?�?��アログを不可視化します。
     */
    public void setInvisible() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                setVisible(false);
            }
        });
    }
}
