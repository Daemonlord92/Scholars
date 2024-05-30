package org.blitmatthew.test;


//Builder Design Pattern Example
public class Account {
    private int id;
    private long accountNumber;
    private double balance;
    private double creditLimit;
    private String accountType;

    public Account() {}

    public Account(AccountBuilder accountBuilder){
        this.id = accountBuilder.id;
        this.accountNumber = accountBuilder.accountNumber;
        this.balance = accountBuilder.balance;
        this.creditLimit = accountBuilder.creditLimit;
        this.accountType = accountBuilder.accountType;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getId() {
        return id;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getAccountType() {
        return accountType;
    }

    public static class AccountBuilder {
        private int id;
        private long accountNumber;
        private double balance;
        private double creditLimit;
        private String accountType;

        public AccountBuilder(int id, long accountNumber, double balance) {
            this.id = id;
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public AccountBuilder creditLimit(double creditLimit) {
            this.creditLimit = creditLimit;
            return this;
        }

        public AccountBuilder accountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}
