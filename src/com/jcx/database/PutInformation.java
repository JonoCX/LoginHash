package com.jcx.database;

import com.jcx.main.User;

import java.sql.*;
import java.util.List;

/**
 * Created by Jonathan on 10-Apr-15.
 */
public class PutInformation
{
    public void putInformation(List<User> list, java.sql.Connection connection)
    {
        try
        {
            Statement statement = connection.createStatement();

            for (int i = 0; i < list.size(); i++)
            {
                statement.executeUpdate(
                        "INSERT INTO hash_login" + " VALUES ('" +
                         list.get(i).getUser() + "','" + list.get(i).getPassword() + "','"
                        + list.get(i).getHash_user() + "','" + list.get(i).getHash_password()
                        + "')"
                );
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
