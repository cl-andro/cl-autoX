package com.clauto.lazy;

/**
 * Lazy initializer.
 *
 * @param <T> Type of the value
 */
public interface LazyInitializer<T> {

    T invoke();
}
