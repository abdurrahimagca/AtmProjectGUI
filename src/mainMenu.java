import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainMenu extends  JFrame {
    private JButton deposit;
    private JButton SendMoney;
    private JButton wDraw;
    private JButton payDebt;
    private JPanel mainMenu;
    private JLabel MenuImage;
    private JLabel menuText;
    private JLabel welcomeText;
    private JLabel showBalanceText;
    private JLabel SurnameText;
    private JButton Exit;
    private JLabel withdrawMoneyImage;
    private JLabel ImageDeposit;
    private JPanel ImageMain;
    public static String message=null;

    public mainMenu() {
        add(mainMenu);
        setSize(500,500);
       mainMenu.setBackground(new Color(116, 68, 70));
       menuText.setForeground(Color.white);
       welcomeText.setText("Hoşgeldiniz Sn. " + SqlQuery.StringGetSQL("SELECT Name FROM clients WHERE id=" + Card.id, "Name"));
       SurnameText.setText(SqlQuery.StringGetSQL("SELECT Surname FROM clients WHERE id=" + Card.id, "Surname"));
       message = "Guncel Bakiyeniz: " + SqlQuery.StringGetSQL("SELECT deposit FROM clients WHERE id=" + Card.id,
               "deposit");
       showBalanceText.setText(message);
       welcomeText.setForeground(Color.white);
       SurnameText.setForeground(Color.white);
       showBalanceText.setForeground(Color.white);
       setVisible(true);


        wDraw.addActionListener(e -> {
            if (e.getSource() == wDraw) {
                new Withdraw();
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });
        deposit.addActionListener(e -> {
            if (e.getSource() == deposit) {
                new Deposit();
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();

            }

        });
        SendMoney.addActionListener(e -> {
            if (e.getSource() == SendMoney) {
                new sendMoney();
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();


            }
        });
        payDebt.addActionListener(e -> {
            if (e.getSource() == payDebt) {

                new payoffDebt();
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();

            }
        });
        Exit.addActionListener(e -> System.exit(0));
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        MenuImage = new JLabel(new ImageIcon("Images\\piggy.png"));

    }
}






