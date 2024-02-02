package org.example.jmx;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.CloseableThreadContext;

import java.util.UUID;

public class MyMBeanImpl implements MyMBean {
    private static final Logger logger = Logger.getLogger(MyMBeanImpl.class);

    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int value) {
        counter = value;
        logCounterInfo();
    }

    public void incrementCounter() {
        counter++;
        logCounterInfo();
    }

    private void logCounterInfo() {
        try (final CloseableThreadContext.Instance ctc = CloseableThreadContext.push("Uuid", UUID.randomUUID().toString())) {

            logger.trace("This is trace : " + counter);
            logger.debug("This is debug : " + counter);
            logger.info("This is info : " + counter);
            logger.warn("This is warn : " + counter);
            logger.error("This is error : " + counter);
            logger.fatal("This is fatal : " + counter);

        }
    }

    public void traceLogLevel() {
        LogManager.getRootLogger().setLevel(Level.TRACE);
        logger.info("Log level is trace now");
    }

    public void debugLogLevel() {
        LogManager.getRootLogger().setLevel(Level.DEBUG);
        logger.info("Log level is debug now");
    }

    public void infoLogLevel() {
        LogManager.getRootLogger().setLevel(Level.INFO);
        logger.info("Log level is info now");
    }
}
