package client.frame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ConnectDialog extends JFrame implements ActionListener {

    private static final long serialVersionUID = 6595090997448488156L;

    private static final String DEFAULT_IP = "localhost";
    private static final String DEFAULT_PORT = "5555";

    private JTextField ipArea;
    private JTextField portArea;
    private JButton btn;

    public ConnectDialog() {

        super("Connect to");

        setBounds(100,100,200,100);
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.CENTER);
        setLayout(flowLayout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ipArea = new JTextField(15);
        ipArea.setText(DEFAULT_IP);
        portArea = new JTextField(4);
        portArea.setText(DEFAULT_PORT);

        btn = new JButton("Connect");
        btn.addActionListener(this);

        add(ipArea);
        add(portArea);
        add(btn);

        setVisible(true);
    }

    /**
     * ボタン押下時、ログインします。
     */
    public void actionPerformed(ActionEvent e) {
        btn.setEnabled(false);
        try {
//            Login data = new Login();
//            data.name = nameArea.getText();
            System.out.println(ipArea.getText());
            System.out.println(portArea.getText());
            synchronized(this){
                this.notify();
            }
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

    public String[] getInput(){
        try{
            synchronized(this){
                this.wait();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return new String[]{ipArea.getText(), portArea.getText()};
    }
    public static void main(String[] args){
        ConnectDialog d = new ConnectDialog();
    }
}