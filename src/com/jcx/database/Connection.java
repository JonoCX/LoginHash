package com.jcx.database;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Jonathan on 10-Apr-15.
 */
public class Connection
{
    private String databaseURL;
    private String user;
    private String password;

    private java.sql.Connection connection;

    public Connection(String databaseURL, String user, String password)
    {
        if (databaseURL.isEmpty() || user.isEmpty() || password.isEmpty())
        {
            throw new IllegalArgumentException("Parameter passed to the method is empty");
        }
        else
        {
            if (databaseURL == null || user == null || password == null)
            {
                throw new IllegalArgumentException("Parameters cannot be null values");
            }
            else
            {
                this.databaseURL = databaseURL;
                this.user = user;
                this.password = password;
                connection = createConnection();
            }
        }
    }

    private java.sql.Connection createConnection()
    {
        java.sql.Connection conn = null;
        try
        {
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(databaseURL, user, password);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return conn;
    }


    public void close(java.sql.Connection connection)
            throws SQLException
    {
        if (connection != null)
        {
            connection.close();
        }
    }

    public java.sql.Connection getConnection()
    {
        return connection;
    }
}
