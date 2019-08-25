package com.facundolinlaud.navent.cache;

public interface Memcached {
    void set(String key, Object value);

    Object get(String key);

    void delete(String key);

    boolean has(String key);
}
