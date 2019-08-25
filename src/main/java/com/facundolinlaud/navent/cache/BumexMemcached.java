package com.facundolinlaud.navent.cache;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BumexMemcached implements Memcached {
    @Override
    public void set(String key, Object value) {

    }

    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public void delete(String key) {

    }

    @Override
    public boolean has(String key) {
        return false;
    }
}
