package org.blitmatthew;

import java.util.List;

public class BankSystem {
    private float checkingAccount;
    private float savingAccount;

    public BankSystem() {
        this.checkingAccount = 5000f;
        this.savingAccount = 5000f;
    }

    public void withdraw(float amount, String from, String to) {
        switch (from.toLowerCase()) {
            case "checking":
                checkingAccount -= amount;
                break;
            case "saving":
                savingAccount -= amount;
                break;
        }
        switch (to.toLowerCase()) {
            case "checking":
                checkingAccount += amount;
                break;
            case "saving":
                savingAccount  += amount;
                break;
        }
    }

    public float getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(float checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public float getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(float savingAccount) {
        this.savingAccount = savingAccount;
    }
}
