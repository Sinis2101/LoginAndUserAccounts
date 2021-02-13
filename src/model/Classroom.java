package model;

import java.util.ArrayList;

public class Classroom {

    private ArrayList<UserAccount> userAccounts;

    public Classroom() {
        userAccounts = new ArrayList<UserAccount>();
    }


    public void addUser(UserAccount user) {
        userAccounts.add(user);
    }

    public ArrayList<UserAccount> getUserAccounts() {
        return userAccounts;
    }
}
