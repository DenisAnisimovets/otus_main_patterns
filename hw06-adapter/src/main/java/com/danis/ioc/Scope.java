package com.danis.ioc;

import java.util.function.Function;

public interface Scope {

    Object resolve(String key, Object... args);

    boolean addDependency(String key, Function<Object[], Object> strategy);
}
