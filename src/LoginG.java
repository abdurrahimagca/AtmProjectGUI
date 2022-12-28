import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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




        signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cardnum = cardNum.getText();
                String pin = new String(pass.getPassword());
                Card card = new Card(cardnum);
                Card.setPin(pin);
                boolean passToSecPart = true;


                try {
                    if(!Login.isCardValid()){


                        cardNum.setText("");
                        pass.setText("");
                        passToSecPart = false;


                    } else if (Login.isCardValid() && !Login.isPinTrue()) {

                        cardNum.setText(cardnum);
                        pass.setText("");
                        passToSecPart = false;

                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                if(passToSecPart) {
                    try {
                        if (Login.isCardValid() && Login.isPinTrue()) {
                            Card.setId();

                            if (e.getSource() == signin) {

                                mainMenu m = new mainMenu();

                            }
                        }
                    } catch (SQLException ex) {

                        throw new RuntimeException(ex);
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

