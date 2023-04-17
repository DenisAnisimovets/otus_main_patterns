package com.danis.model;

public interface UObject {
    Object getProperty(String key);

    void setProperty(String key, Object value);
}
