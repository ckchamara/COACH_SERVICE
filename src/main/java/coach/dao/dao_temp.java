package coach.dao;

import java.sql.*;

public class dao_temp {
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    public static ResultSet executeQuery(String sql) throws Exception {
        try {
            // Statements allow to issue SQL queries to the database
          Connection dbConnect = dbConnection.getInstance().getConnection();

            statement = dbConnect.createStatement();
            // Result set get the result of the SQL query
//            resultSet = dbConnect.createStatement().executeQuery("SELECT * FROM busbook.customers");
            resultSet = dbConnect.createStatement().executeQuery(sql);

            // Result set get the result of the SQL query
            return statement.executeQuery(sql);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    // You need to close the resultSet
    private static void close() throws SQLException {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

        } catch (Exception e) {
            throw e;
        }
    }

}
