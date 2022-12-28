import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sendMoney extends JFrame{
    private JTextField IBANtext;
    private JTextField amountText;
    private JButton sendButton;
    private JPanel SendMoney;
    private JLabel sendInfor1;
    private JLabel sendInfo2;
    private JLabel sendMoneyIm;
    private JButton back;

    public sendMoney() {
    add(SendMoney);
    setSize(500,500);
    SendMoney.setBackground(new Color(116,68,70));
    sendInfor1.setForeground(Color.white);
    sendInfo2.setForeground(Color.white);
    setVisible(true);
    sendButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String IBAN = IBANtext.getText();
            String tempamount = amountText.getText();
            double amount=0.0;
            try {
                amount = Double.parseDouble(tempamount);
            } catch (Exception ex) {
               ex.printStackTrace();
            }
            try {
                if(Transactions.transfer(Card.id,IBAN, amount)){
                    if (e.getSource() == sendButton) {
                        mainMenu m = new mainMenu();
                        JComponent comp = (JComponent) e.getSource();
                        Window win = SwingUtilities.getWindowAncestor(comp);
                        win.dispose();

                    }

                }
            }
            catch(Exception ex){
                ex.printStackTrace();

            }


        }
    });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu m = new mainMenu();
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        sendMoneyIm = new JLabel(new ImageIcon("Images\\send.png"));
    }
}
