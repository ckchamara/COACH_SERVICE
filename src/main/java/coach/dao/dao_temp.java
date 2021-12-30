package coach.dao;

import java.sql.*;

public class dao_temp {
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    public static ResultSet executeQuery(String sql) throws Exception {
        try {
            // Statements allow to issue SQL queries to the database
         return dbConnection.getInstance().getConnection().createStatement().executeQuery(sql);

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
