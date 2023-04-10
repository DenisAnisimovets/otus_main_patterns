package com.danis.adapter;

import com.danis.domain.UObject;

public interface AdapterGenerator {
    <T> T resolve(Class<T> interfaceType, UObject uObject);
}
