package coach.dao;

// Java program implementing Singleton class
// with using getInstance() method

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Class 1
// Helper class
class dbConnection {
    // Static variable reference of single_instance
    // of type Singleton
    private static dbConnection single_instance = null;

    private Connection connect;

    // Constructor
    // Here we will be creating private constructor
    // restricted to this class itself
    private dbConnection() throws SQLException, ClassNotFoundException {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            // Decl;aring a variable of type String
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

