package com.ncontainr.tests;

import com.ncontainr.NanoContainerBuilder;
import com.ncontainr.api.Container;
import com.ncontainr.api.aop.AOP;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertEquals;

public class ContainerTest {

    private static final String NAME = "Raoul";
    private static final String PHONE = "555-8765";
    private static final long PRICE = 900;
    private Container container;

    @Before
    public void bootstrapContainer() {
        container = NanoContainerBuilder.build(AOP.ENABLED);
        container.register(Customer.class, CustomerImpl.class);
        container.register(Logger.class, LoggerImpl.class);
        container.register(Account.class, BankAccount.class);
    }

    @Test
    public void testNonInjection() {
        Customer customer = new CustomerImpl();
        Bank bank = new Bank();
        assertTrue(customer.getLogger() == null);
        assertTrue(customer.getAccount() == null);
        assertTrue(bank.getLogger() == null);
    }

    @Test
    public void testFieldInjection() {
        Customer customer = container.getBean(Customer.class);
        customer.setName(NAME);
        customer.setPhone(PHONE);
        assertTrue(customer.getLogger() != null);
        assertEquals(customer.getMyName(), NameHelper.sayName(NAME, PHONE));
        customer.sayMyName();
    }

    @Test
    public void methodInjection() {
        Customer customer = container.getBean(Customer.class);
        assertTrue(customer.getAccount().getAmount() == BankAccount.AMOUNT);
        customer.getAccount().spend(PRICE);
        assertTrue(customer.getAccount().getAmount() == (BankAccount.AMOUNT - PRICE));
    }

    @Test
    public void constructorInjection() {
        Bank bank = container.getBean(Bank.class);
        assertTrue(bank.getLogger() != null);
        bank.log();
    }

    @Test
    public void AOPtest() {
        assertTrue(AOPMessages.getInstance().getBefore().size() == 2);
        assertTrue(AOPMessages.getInstance().getAfter().size() == 2);
    }
}
