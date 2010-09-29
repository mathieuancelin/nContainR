package com.ncontainr.api.aop;

import java.lang.reflect.Method;

public interface InvocationContext {

    Object getTarget();

    Method getMethod();

    Object[] getParameters();

    void setParameters(Object[] params);
}
