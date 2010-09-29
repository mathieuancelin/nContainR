package com.ncontainr;

import com.ncontainr.api.Container;
import com.ncontainr.api.aop.AOP;

/**
 * Builder utility class to create containers. 
 */
public class NanoContainerBuilder {
    /**
     * Build a new Container.
     * @param state if AOP is enabled of not.
     * @return a brand new Container.
     */
    public static Container build(AOP state) {
        if (state.equals(AOP.ENABLED)) {
            return new NanoContainer(true);
        } else {
            return new NanoContainer(false);
        }
    }
}
