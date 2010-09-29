package com.ncontainr.tests;

import javax.inject.Inject;

public class CustomerImpl implements Customer {

    private String name;

    private String phone;

    @Inject
    private Logger logger;

    private Account account;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public String getMyName() {
        return NameHelper.sayName(name, phone);
    }

    @Override
    public void sayMyName() {
        this.logger.log(NameHelper.sayName(name, phone));
    }

    public Account getAccount() {
        return account;
    }

    @Inject
    public void setAccount(Account account) {
        this.account = account;
    }

}
