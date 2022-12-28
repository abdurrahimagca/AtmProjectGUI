import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deposit extends JFrame{
    private JTextField depositAmount;
    private JButton depositButton;
    private JPanel Deposit;
    private JLabel depositText;
    private JLabel depositIm;

    public Deposit() {
    add(Deposit);
    setSize(500,500);
        Deposit.setBackground(new Color(116,68,70));
    depositText.setForeground(Color.white);
    setVisible(true);
    depositButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String tempamount = depositAmount.getText();
            System.out.println(tempamount);

            double amount=0.0;
            try {

                amount = Double.parseDouble(tempamount);

            } catch (Exception ex) {
                System.out.println("hata29satır");
            }
            try {
                if (Transactions.deposit(Card.id, amount)) {
                    if (e.getSource() == depositButton) {
                        System.out.println("fkjsdafkld");
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
        depositIm = new JLabel(new ImageIcon("Images\\deposit.png"));
    }
}
