package com.danis.ioc;

public interface IoC {

    <T> T resolve(String key, Object... args);

}
