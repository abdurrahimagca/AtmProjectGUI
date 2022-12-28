import java.sql.ResultSet;

public class Card {

    protected static String cardNum;



    protected static String pin;

    public Card(String cardNum) {
        this.cardNum = cardNum;
        this.pin = "0000";

    }

    public static void setPin(String pin) {
        Card.pin = pin;
    }


    public static String getCardNum() {
        return cardNum;
    }

    public static String getPin() {
        return pin;
    }

    public static String id;



   public static void setId()  {

        ResultSet rs = SqlQuery.getResult(("SELECT id FROM clients WHERE CardNum=" + cardNum));
        try {
            while (rs.next()) {
                id = rs.getString("id");
            }
        }catch (Exception e){
            System.out.println("Kullanici bulunamadi ERR39");
            System.exit(2);
        }

    }

}
