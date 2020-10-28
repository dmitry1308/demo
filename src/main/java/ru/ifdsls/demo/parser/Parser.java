package ru.ifdsls.demo.parser;

import java.io.FileNotFoundException;

public interface Parser<T,V> {
    T parse(V path) throws FileNotFoundException;
}
