package com.jcx.database;

import java.sql.*;

/**
 * Created by Jonathan on 10-Apr-15.
 */
public class FetchInformation
{
    public ResultSet getInformation(String sql, java.sql.Connection connection)
    {
        Statement statement;
        ResultSet resultSet = null;
        try
        {
            System.out.println("Fetching database information...");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            statement.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return resultSet;
    }
}
