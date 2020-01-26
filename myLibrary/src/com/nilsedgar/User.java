package com.nilsedgar;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    ArrayList<Book> borrowedBooks = new ArrayList<>();

    private String name;
    private String password;

    public User(String name, String password) {
        this.password = password;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
