package com.ncontainr.tests;

import com.ncontainr.api.annotations.After;
import com.ncontainr.api.annotations.Before;
import com.ncontainr.api.aop.InvocationContext;
import javax.inject.Inject;

public class Interceptor {

    @Inject
    private InterceptorLogger logger;


    @Before
    public void before(InvocationContext ctx) {
        String message = "before " + ctx.getClass().getName()
            + "/" + ctx.getMethod().getName() + "()";
        logger.log(message);
        AOPMessages.getInstance().addBefore(message);
    }

    @After
    public void after(InvocationContext ctx) {
        String message = "after " + ctx.getClass().getName()
            + "/" + ctx.getMethod().getName() + "()";
        logger.log(message);
        AOPMessages.getInstance().addAfter(message);
    }
}
