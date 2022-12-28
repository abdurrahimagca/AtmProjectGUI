import java.sql.ResultSet;

public class Card {

    protected static String cardNum;


    protected static String pin;

    public Card(String cardNum) {
        Card.cardNum = cardNum;
        Card.pin = "0000";

    }

    public static void setPin(String pin) {
        Card.pin = pin;
    }


    public static String id;


    public static void setId() {

        ResultSet rs = SqlQuery.getResult(("SELECT id FROM clients WHERE CardNum=" + cardNum));
        try {
            if (rs != null) {
                while (rs.next()) {
                    id = rs.getString("id");
                }
            }
        } catch (Exception e) {
            System.out.println("Kullanici bulunamadi ERR39");
            System.exit(2);
        }

    }

}
