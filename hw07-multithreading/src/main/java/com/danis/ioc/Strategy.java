package com.danis.ioc;

interface Strategy {

    Object resolve(String key, Object... args);

}
