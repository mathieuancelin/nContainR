package com.ncontainr.api;

/**
 * Contract for a container.
 */
public interface Container {
    /**
     * Register a bean with its contract in the container.
     * ( bind an interface to its implementation.
     */
    <T> void register(Class<T> interf, Class<? extends T> impl);
    /**
     * Return an injected bean from the container
     */
    <T> T getBean(Class<T> clazz);
}
