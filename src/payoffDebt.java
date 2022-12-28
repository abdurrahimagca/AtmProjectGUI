import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class payoffDebt extends JFrame{
    private JPanel Debt;
    private JTextField amountText;
    private JButton payOffDebt;
    private JLabel payoffImage;
    private JLabel payoffText;

    public payoffDebt(){
        add(Debt);
        setSize(500,500);
        Debt.setBackground(new Color(116,68,70));
        payoffText.setForeground(Color.white);
        payoffText.setText("Borcunuz " + SqlQuery.StringGetSQL("SELECT debt FROM clients WHERE id=" + Card.id,
                "debt"));
        setVisible(true);


        payOffDebt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tempamount = amountText.getText();
                System.out.println(tempamount);

                double amount=0.0;
                try {

                    amount = Double.parseDouble(tempamount);

                } catch (Exception ex) {
                    System.out.println("hata29satır");
                }
                try {
                    if (Transactions.payOffDebt(Card.id,amount)) {
                        if (e.getSource() == payOffDebt) {

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
        payoffImage = new JLabel(new ImageIcon("Images\\payOff.png"));
    }
}
