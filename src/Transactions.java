import javax.swing.*;
import java.sql.*;


public class Transactions {


    private static double stringToDouble(String text) {

        double val = 0;
        try {

            val = Double.parseDouble(text);

        } catch (Exception ignored) {

        }
        return val;
    }


    public static boolean withdraw(String id, double amount) {
        double deposit;
        if (amount < 10 || amount > 1000) {

            JOptionPane.showMessageDialog(null, "Cekilecek tutar 10'dan kucuk 1000'den buyuk olamaz!");
            return false;
        }

        String temp = SqlQuery.StringGetSQL("SELECT deposit FROM clients WHERE id=" + id, "deposit");


        try {
            deposit = Double.parseDouble(temp);
            System.out.println(deposit);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        if (deposit < amount) {
            JOptionPane.showMessageDialog(null, "cekilmek istenen tutar bakiyeden fazla.. ");
            return false;
        } else if (deposit > amount) {
            deposit = deposit - amount;
            temp = String.valueOf(deposit);

            SqlQuery.UpdateData("UPDATE clients SET deposit=" + temp + "WHERE id=" + id);
            JOptionPane.showMessageDialog(null, "Para Cekme Basarili. Guncel bakiyeniz: " + temp);
            return true;
        }
        return false;
    }


    public static boolean deposit(String id, double amount) {
        double deposit;

        String temp = SqlQuery.StringGetSQL("SELECT deposit FROM clients WHERE id=" + id, "deposit");
        if (amount < 1) {
            JOptionPane.showMessageDialog(null, "Yatiralacak tutar sifirdan kucuk olamaz!");

            return false;
        }

        deposit = stringToDouble(temp);

        deposit = deposit + amount;
        temp = String.valueOf(deposit);
        SqlQuery.UpdateData("UPDATE clients SET deposit=" + temp + "WHERE id=" + id);
        JOptionPane.showMessageDialog(null, "Para Yatirma islemi basarili. Guncel Bakiyeniz:  " + temp);

        return true;

    }


    public static boolean transfer(String id, String IBAN, double amount) throws SQLException {

        if (IBAN.length() != 24) {
            JOptionPane.showMessageDialog(null, "IBAN uzunlu??u 24 haneli olmal??d??r.");
            return false;
        }

        ResultSet rs = SqlQuery.getResult("SELECT id FROM clients WHERE IBAN='TR" + IBAN+"'");


      if(!rs.next()){
          JOptionPane.showMessageDialog(null,"Yanl???? IBAN");
          return false;
      }

      String recevierID = SqlQuery.StringGetSQL("SELECT id FROM clients WHERE IBAN='TR" + IBAN+"'", "id");
      if(recevierID.equals(id)){
          JOptionPane.showMessageDialog(null,"Kendinize transfer yapamazs??n??z. ");
          return false;
      }


        double depositSender, depositReceiver;
        String temp = SqlQuery.StringGetSQL("SELECT deposit FROM clients WHERE id=" + id, "deposit");
        depositSender = stringToDouble(temp);
        depositSender = depositSender - amount;
        if (amount < 1) {

            JOptionPane.showMessageDialog(null, "Gondereceginiz tutar 0'dan buyuk olmal??d??r. ");
            return false;
        }
        if (depositSender < amount) {

            JOptionPane.showMessageDialog(null, "Bakiye yetersiz. ");
            return false;
        }
        temp = SqlQuery.StringGetSQL("SELECT deposit FROM clients WHERE IBAN='TR" + IBAN + "'", "deposit");
        depositReceiver = stringToDouble(temp);

        depositReceiver = depositReceiver + amount;

        temp = String.valueOf(depositReceiver);
        SqlQuery.UpdateData("UPDATE clients SET deposit=" + temp + " WHERE IBAN='TR" + IBAN + "'");

        temp = String.valueOf(depositSender);
        SqlQuery.UpdateData("UPDATE clients SET deposit=" + temp + "WHERE id=" + id);
        JOptionPane.showMessageDialog(null, "Para gonderme basarili. Guncel Bakiyeniz: " + temp);
        return true;

    }


    public static boolean payOffDebt(String id, double amount) {
        double deposit, debt;
        String temp = SqlQuery.StringGetSQL("SELECT debt FROM clients WHERE id=" + id, "debt");
        debt = stringToDouble(temp);
        temp = SqlQuery.StringGetSQL("SELECT deposit FROM clients WHERE id=" + id, "deposit");
        deposit = stringToDouble(temp);
        if (amount > deposit) {

            JOptionPane.showMessageDialog(null, "Odemek istediginiz tutar bakiyenizden fazla olamaz. ");
            return false;
        } else if (amount > debt) {

            deposit = deposit - debt;
            debt = 0;
            temp = String.valueOf(deposit);
            SqlQuery.UpdateData("UPDATE clients SET deposit=" + temp + "WHERE id=" + id);
            SqlQuery.UpdateData("UPDATE clients SET debt=0 WHERE id=" + id);
            System.out.println();
            JOptionPane.showMessageDialog(null, "girdiginiz tutar borcunuzdan fazladir, borcunuz: " + debt + " TL ??denmistir. ");
            return true;

        } else {
            deposit = deposit - amount;
            temp = String.valueOf(deposit);
            SqlQuery.UpdateData("UPDATE clients SET deposit=" + temp + "WHERE id=" + id);
            debt = debt - amount;
            temp = String.valueOf(debt);
            SqlQuery.UpdateData("UPDATE clients SET debt=" + temp + "WHERE id=" + id);
            JOptionPane.showMessageDialog(null, "Borc odeme basarili kalan borcunuz: " + debt);
            return true;
        }
    }


}
