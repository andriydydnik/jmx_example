package org.example.jmx;

public interface MyMBean {
    // Атрибути
    int getCounter();

    void setCounter(int value);

    // Операції
    void incrementCounter();

    void traceLogLevel();
    void debugLogLevel();
    void infoLogLevel();
}
