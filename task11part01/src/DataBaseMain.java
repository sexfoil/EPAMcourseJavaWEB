import MyOffice.MyOffice;

import java.sql.SQLException;

public class DataBaseMain {

    public static void main(String[] args) {

        try {
            new MyOffice().run();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
