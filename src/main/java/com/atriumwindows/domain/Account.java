package com.atriumwindows.domain;

/**
 * Created by nni on 1/27/2016.
 */
public class Account {

    private String accountId;
    private String email;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Account(String accountId, String email) {
        this.accountId = accountId;
        this.email = email;
    }

    public Account() {

    }

    //for testing


    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
