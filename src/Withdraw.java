import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Withdraw extends JFrame {
    private JTextField WithDrawAmount;
    private JButton WithdrawButton;
    private JPanel withDraw;
    private JLabel infoWithdrawText;
    private JLabel withdrawIm;

    public Withdraw(){

        add(withDraw);
     
        setSize(500,500);
        withDraw.setBackground(new Color(116,68,70));
        infoWithdrawText.setForeground(Color.white);
        setVisible(true);



        WithdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String tempamount = WithDrawAmount.getText();
                System.out.println(tempamount);

                double amount=0.0;
                try {

                    amount = Double.parseDouble(tempamount);

                } catch (Exception ex) {
                    System.out.println("hata29satır");
                }
                try {
                    if (Transactions.withdraw(Card.id, amount)) {

                        if (e.getSource() == WithdrawButton) {
                            mainMenu.message= "Guncel Bakiyeniz: " + SqlQuery.StringGetSQL("SELECT deposit FROM clients WHERE id=" + Card.id,
                                    "deposit");

                        }
                    }
                }catch (Exception ex){
                    System.out.println("hata37witdraw");
                    ex.printStackTrace();
                }

            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        withdrawIm = new JLabel(new ImageIcon("Images\\cashwithdrawal.png"));
    }
}
