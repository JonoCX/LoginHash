package com.jcx.main;

import com.jcx.database.Connection;
import com.jcx.database.PutInformation;
import com.jcx.security.Hash;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jonathan on 10-Apr-15.
 */
public class Operation
{

    public static void main(String[] args)
    {
        java.sql.Connection conn = null;
        Statement statement = null;
        PutInformation put = new PutInformation();
        Hash hash = new Hash();

        String database = "jdbc:mysql://localhost/hash_login";
        String user = "jonathan";
        String password = "password";

        Connection connection = new Connection(database, user, password);
        conn = connection.getConnection();


        String user = "jonathan";
        String password = "password";


    }

    private List<User> getInput()
    {
        List<User> data = new ArrayList<User>();
        Scanner scanner = new Scanner(System.in);
        String user, password, hash_user, hash_password;



        return data;
    }

    private void print(ResultSet resultSet)
    {
        try
        {
            while (resultSet.next())
            {
                String user = resultSet.getString("user");
                String password = resultSet.getString("password");
                System.out.println("User: " + user + " | Password: " + password);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private void printHash(ResultSet resultSet)
    {
        try
        {
            while (resultSet.next())
            {
                String user = resultSet.getString("hash_user");
                String password = resultSet.getString("hash_password");
                System.out.println("Hash User: " + user + "  | Hash Password: " + password);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
