package greet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ConnectionTest {
    final String GREET_DATABASE_URL = "jdbc:h2:./target/greet-in-java";

    public Connection getConnection() throws Exception {
        Connection conn = DriverManager.getConnection(GREET_DATABASE_URL, "sa", "");
        return conn;
    }

    @Test
    public void loadJdbcDriver() {

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            fail(e);
        }
    }

    @Test
    public void connectToDatabase() {

        try {
            Class.forName("org.h2.Driver");

            Connection conn = DriverManager.getConnection(GREET_DATABASE_URL, "sa", "");
            System.out.println(conn);
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    public void executeSQLStatement() {

        try {

            Connection connect = getConnection();
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery ("select * from greeted");

            System.out.println(rs);

        } catch (Exception e) {
            fail(e);
        }
    }


}
