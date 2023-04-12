package org.example;

public class User {
    private int id;
    private String username;
    private String password;
    private int tokens;

    public User(){

    }
    public User(int id, String username, String password, int tokens) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.tokens = tokens;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tokens=" + tokens +
                '}';
    }
}