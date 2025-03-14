import java.sql.*;

public class DatabaseSchema {
    public static void createTable(){
        String tableSchema = "CREATE TABLE IF NOT EXISTS accounts ("
                + "account_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "holder VARCHAR(50) NOT NULL, "
                + "balance INTEGER NOT NULL, "
                + "login VARCHAR(50) NOT NULL UNIQUE, "
                + "pin INT(5) NOT NULL, "
                + "status ENUM('ACTIVE', 'DISABLED') NOT NULL DEFAULT 'ACTIVE'"
                + " ); ";
        try {
            Connection connection = MySQLSource.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(tableSchema);
            System.out.println("Accounts Table created");
        }catch ( Exception e ){
            e.printStackTrace();
        }
    }
}
