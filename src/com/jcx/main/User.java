package com.jcx.main;

/**
 * Created by Jonathan on 10-Apr-15.
 */
public class User
{
    private String user;
    private String password;
    private String hash_user;
    private String hash_password;

    public User(String user, String password, String hash_user, String hash_password)
    {
        this.user = user;
        this.password = password;
        this.hash_user = hash_user;
        this.hash_password = hash_password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHash_user() {
        return hash_user;
    }

    public void setHash_user(String hash_user) {
        this.hash_user = hash_user;
    }

    public String getHash_password() {
        return hash_password;
    }

    public void setHash_password(String hash_password) {
        this.hash_password = hash_password;
    }
}
