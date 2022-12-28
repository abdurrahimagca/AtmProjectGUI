import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends Card {


    public Login(String cardNum) {
        super(cardNum);
    }

    public static boolean isCardValid() throws SQLException {
        ResultSet checkRs = SqlQuery.getResult(("SELECT id FROM clients WHERE CardNum=" + cardNum));

        while (checkRs.next()) {
            return true;
        }

        return false;


    }

    public static boolean isPinTrue() {

        String cardsPin = SqlQuery.StringGetSQL("SELECT PIN FROM clients WHERE CardNum=" + cardNum, "PIN");



        if (!(pin.length() == 4)) {

            JOptionPane.showMessageDialog(null,"Pininiz Dort Haneden Olusmalidir");
            return false;
        }
        try {
            int x = Integer.parseInt(pin);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,"Pin rakamlardan olusmalidir. ");
            return false;
        }
        if (!(pin.equals(cardsPin))) {
             JOptionPane.showMessageDialog(null,"Şifreniz Hatalıdır. Lütfen Tekrar Deneyiniz");

            return false;

        }
        return true;
    }


}
