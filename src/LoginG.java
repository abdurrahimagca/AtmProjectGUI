import javax.swing.*;
import java.awt.*;


public class LoginG extends  JFrame{
    private JTextField cardNum;
    private JPasswordField pass;
    private JButton signin;
    private JPanel login;
    private JLabel cardnumlabel;
    private JLabel pintext;
    private JLabel Image;

    public LoginG()
    {

        add(login);
        setSize(700,400);
        login.setBackground(new Color(116,68,70));
        cardnumlabel.setForeground(Color.white);
        pintext.setForeground(Color.white);
        login.setVisible(true);




        signin.addActionListener(e -> {
            String cardnum = cardNum.getText();
            String pin = new String(pass.getPassword());
            Card card = new Card(cardnum);
            Card.setPin(pin);
            boolean passToSecPart = true;


            if(!Login.isCardValid()){


                cardNum.setText("");
                pass.setText("");
                passToSecPart = false;


            } else if (Login.isCardValid() && !Login.isPinTrue()) {

                cardNum.setText(cardnum);
                pass.setText("");
                passToSecPart = false;

            }

            if(passToSecPart) {
                if (Login.isCardValid() && Login.isPinTrue()) {
                    Card.setId();

                    if (e.getSource() == signin) {

                        new mainMenu();
                        JComponent comp = (JComponent) e.getSource();
                        Window win = SwingUtilities.getWindowAncestor(comp);
                        win.dispose();


                    }
                }
            }

        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        Image = new JLabel(new ImageIcon("Images\\piggy.png"));
        Image.setForeground(Color.white);



    }
}

