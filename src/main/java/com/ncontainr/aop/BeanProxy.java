package com.ncontainr.aop;

import com.ncontainr.api.Container;
import com.ncontainr.api.annotations.Before;
import com.ncontainr.api.annotations.Intercept;
import com.ncontainr.api.annotations.After;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BeanProxy implements InvocationHandler {

    private Object instance;

    private Container container;

    public BeanProxy(Object instance, Container container) {
        this.instance = instance;
        this.container = container;
    }

    /**
     * Invocation of a method on an intercepted bean.
     * 
     * @param proxy the actual proxy
     * @param method the invoked method
     * @param args arguments of the invocation
     * @return the result of the invocation
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method realMethod = instance.getClass().getMethod(method.getName(),
                method.getParameterTypes());
        boolean interceptable = realMethod.isAnnotationPresent(Intercept.class);
        Class interceptor = null;
        Object interceptorInstance = null;
        if (interceptable) {
            // before actual invocation on the target bean.
            interceptor = realMethod.getAnnotation(Intercept.class).value();
            interceptorInstance = container.getBean(interceptor);//interceptor.newInstance();
            for (Method meth : interceptor.getDeclaredMethods()) {
                if (meth.isAnnotationPresent(Before.class)) {
                    ProxyContext context = new ProxyContext(instance, realMethod, args);
                    meth.invoke(interceptorInstance, context);
                }
            }
        }
        try {
            // invocation on the target bean.
            return method.invoke(instance, args);
        } finally {
            // after actual invocation on the target bean.
            if (interceptable) {
                for (Method meth : interceptor.getDeclaredMethods()) {
                    if (meth.isAnnotationPresent(After.class)) {
                        ProxyContext context = new ProxyContext(instance, realMethod, args);
                        meth.invoke(interceptorInstance, context);
                    }
                }
            }
        }
    }
}
