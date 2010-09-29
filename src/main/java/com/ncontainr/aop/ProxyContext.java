package com.ncontainr.aop;

import com.ncontainr.api.aop.InvocationContext;
import java.lang.reflect.Method;

public class ProxyContext implements InvocationContext{

    private Object bean;

    private Method method;

    private Object[] args;

    public ProxyContext(Object bean,
            Method method, Object[] args) {
        this.bean = bean;
        this.method = method;
        this.args = args;
    }

    @Override
    public final Method getMethod() {
        return method;
    }

    @Override
    public final Object getTarget() {
        return bean;
    }
    @Override
    public final Object[] getParameters() {
        return args;
    }

    @Override
    public final void setParameters(Object[] params) {
        this.args = params;
    }
}

