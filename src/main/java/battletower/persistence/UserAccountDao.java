package battletower.persistence;


import battletower.utils.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Logger;

import static java.util.logging.Level.*;

public class UserAccountDao implements Dao<UserAccount> {

    private static final Logger LOGGER = Logger.getLogger(UserAccountDao.class.getName());

    public UserAccountDao()
    {
    }

    public UserAccount findById(Integer id)
    {
        Connection connection = null;

        try {
            connection = Connector.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM games");
            while(rs.next())
            {
                if(rs.getInt("account_id") == id)
                {
                    return null;
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                {
                    connection.close();
                }
                LOGGER.log(INFO, "Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public List findAll()
    {
        return null;
    }

    public UserAccount update(UserAccount dto)
    {
        return null;
    }

    public UserAccount create(UserAccount dto)
    {
        return null;
    }

    public void delete(Integer id) {

    }
}
