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
    private JButton back;

    public payoffDebt(){
        add(Debt);
        setSize(500,500);
        Debt.setBackground(new Color(116,68,70));
        payoffText.setForeground(Color.white);
        payoffText.setText("Borcunuz " + SqlQuery.StringGetSQL("SELECT debt FROM clients WHERE id=" + Card.id,
                "debt"));
        back.setSize(10,10);
        setVisible(true);


        payOffDebt.addActionListener(e -> {
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
                        mainMenu m = new mainMenu();
                        JComponent comp = (JComponent) e.getSource();
                        Window win = SwingUtilities.getWindowAncestor(comp);
                        win.dispose();

                    }
                }
            }catch (Exception ex){
                System.out.println("hata37witdraw");
                ex.printStackTrace();
            }

        });
        back.addActionListener(e -> {
            new mainMenu();
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

        });
        back.addActionListener(e -> {
            new mainMenu();
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        payoffImage = new JLabel(new ImageIcon("Images\\payOff.png"));
    }
}
