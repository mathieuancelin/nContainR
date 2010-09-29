package com.ncontainr.tests;

public class BankAccount implements Account {

    public static final long AMOUNT = 10000;

    private long amount = AMOUNT;

    @Override
    public long spend(long price) {
        this.amount -= price;
        return this.amount;
    }

    @Override
    public long getAmount() {
        return amount;
    }

}
