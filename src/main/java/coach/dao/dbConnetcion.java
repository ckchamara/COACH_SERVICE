package coach.dao;

// Java program implementing Singleton class
// with using getInstance() method

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class dbConnection {

    private static dbConnection single_instance = null;

    private Connection connect;

    private dbConnection() throws SQLException, ClassNotFoundException {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/busbook?"
                            + "user=root&password=admin");

        } catch (Exception e) {
            throw e;
        }
    }

    public static dbConnection getInstance() throws SQLException, ClassNotFoundException {
        if (single_instance == null)
            single_instance = new dbConnection();

        return single_instance;
    }

    public Connection getConnection() {
        return connect;
    }
}

