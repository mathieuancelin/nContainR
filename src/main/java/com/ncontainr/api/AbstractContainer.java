package com.ncontainr.api;

/**
 * Contract for used methods.
 */
public abstract class AbstractContainer implements Container {
    /**
     * Apply AOP on the created bean.
     */
    protected abstract <T> T applyAOP(Class<T> clazz, Object instance);
    /**
     * Perform setter injection on the created bean.
     */
    protected abstract <T> T injectMethods(Class<T> impl, Object instance) throws Exception;
    /**
     * Perform contructor injection on the target class.
     */
    protected abstract <T> T injectConstructors(Class clazz, Class impl) throws Exception;
    /**
     * Perform field injection on the created bean.
     */
    protected abstract <T> T injectFields(Class<T> impl, Object instance) throws Exception;
    /**
     * Called when object is finallized.
     */
    protected abstract void applyPreDestroy(Object instance) throws Exception;
    /**
     * Called when object is created.
     */
    protected abstract void applyPostConstruct(Object instance) throws Exception;
    /**
     * Called at shutdown time to stop managed bean instances.
     */
    public abstract void shutdownContainer();
}
