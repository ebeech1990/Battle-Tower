package battletower.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import static java.util.logging.Level.*;

public class Connector
{
    private static final Logger LOGGER = Logger.getLogger(Connector.class.getName());

    public static final String URL = "jdbc:mysql://battle-tower.csr8tbdx5wbd.us-east-1.rds.amazonaws.com:3306/battletower";
    public static final String USER = "battletowerapp";
    public static final String PASS = "CatchAll151";
    public static Connection getConnection()
    {
        Connection conn = null;

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e)
            {
                LOGGER.log(WARNING, "Couldn't find the driver.");
            }
            conn = DriverManager.getConnection(URL, USER, PASS);
            LOGGER.log(INFO, "Connection Established to AWS MYSQL Database");
        } catch (SQLException e)
        {
            LOGGER.log(WARNING, "Rejected from AWS MYSQL Database");
            System.err.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                {
                    conn.close();
                }
                LOGGER.log(INFO, "Connection closed.");
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        return conn;
    }

    public static void main(String[] args)
    {
        Connection connection = Connector.getConnection();
    }
}