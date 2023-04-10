package com.danis.ioc;

public interface Strategy {
    Object resolve(String key, Object... args);
}
