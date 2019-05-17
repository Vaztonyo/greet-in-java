package greet.methods;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DbMethods {
    final String GREET_DATABASE_URL = "jdbc:h2:./target/greet-in-java";

    public void addToDataBase(String name, int greetCount) throws ClassNotFoundException, SQLException {
        Connection conn = connectToDB();

        final String INSERT_NAME_SQL = "insert into greeted (name, timesGreeted) values (?, ?)";

        findUser(name);

        PreparedStatement addDataPreparedStatement;
        if (findUser(name).isEmpty()) {
            try {
                addDataPreparedStatement = conn.prepareStatement(INSERT_NAME_SQL);
                addDataPreparedStatement.setString(1, name);
                addDataPreparedStatement.setInt(2, greetCount);
                addDataPreparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else{
            updateCount(name);
        }

    }

    public Map<String, Integer> findUser(String name) throws SQLException, ClassNotFoundException {
        Connection conn = connectToDB();

        final String FIND_NAME_SQL = "select * from greeted where name = ?";
        Map<String, Integer> getName = new HashMap<>();

        PreparedStatement getNamePreparedStatement;
        try {
            getNamePreparedStatement = conn.prepareStatement(FIND_NAME_SQL);
            getNamePreparedStatement.setString(1, name);
            ResultSet rs = getNamePreparedStatement.executeQuery();

            if (rs.next()) {
                int timesGreeted = rs.getInt("timesGreeted");
                String userName = rs.getString("name");

                getName.put(userName, timesGreeted);
            }
            return getName;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return getName;
    }

    public void updateCount(String name) throws SQLException, ClassNotFoundException {
        Connection conn = connectToDB();
        final String UPDATE_COUNT_SQL = "update greeted set timesGreeted = timesGreeted + 1 where name = ?";

        PreparedStatement updateCountPreparedStatement;

        try {
            updateCountPreparedStatement = conn.prepareStatement(UPDATE_COUNT_SQL);

            updateCountPreparedStatement.setString(1, name);

            updateCountPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public Map<String, Integer> getAllDataInDB() throws ClassNotFoundException, SQLException {
        Connection conn = connectToDB();

        final String FIND_NAME_SQL = "select * from greeted";
        Map<String, Integer> names = new HashMap<>();
        PreparedStatement showDataPreparedStatement;

        showDataPreparedStatement = conn.prepareStatement(FIND_NAME_SQL);

        ResultSet rs = showDataPreparedStatement.executeQuery();

        while (rs.next()) {
            int timesGreeted = rs.getInt("timesGreeted");
            String userName = rs.getString("name");

            names.put(userName, timesGreeted);
        }
        return names;
    }

    public void deleteData() throws ClassNotFoundException, SQLException {
        Connection conn = connectToDB();

        final String DELETE_NAME_SQL = "delete from greeted where id > 0";

        PreparedStatement deletePreparedStatement;
        try {
            deletePreparedStatement = conn.prepareStatement(DELETE_NAME_SQL);
            deletePreparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOneName(String name) throws ClassNotFoundException, SQLException {
        Connection conn = connectToDB();

        final String DELETE_NAME_SQL = "delete from greeted where name = ?";

        PreparedStatement deletePreparedStatement;
        try {
            deletePreparedStatement = conn.prepareStatement(DELETE_NAME_SQL);
            deletePreparedStatement.setString(1, name);
            deletePreparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int countDataInDB() throws SQLException, ClassNotFoundException {
        Connection conn = connectToDB();

        final String COUNT_DATA_SQL = "select count(*) as count from greeted";

        PreparedStatement countDataPreparedStatement;
        int number = 0;
        try {

            countDataPreparedStatement = conn.prepareStatement(COUNT_DATA_SQL);
            ResultSet rs = countDataPreparedStatement.executeQuery();
            while (rs.next()){
                number = rs.getInt("count");
            }
            return number;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return number;
    }

    public final Connection connectToDB() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection(GREET_DATABASE_URL, "sa", "");
        return conn;
    }
}
