package org.example;

import org.example.jmx.MyMBean;
import org.example.jmx.MyMBeanImpl;

import javax.management.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, IOException {
        // Створення MBean-сервера
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        // Створення об'єкта MBean
        StandardMBean mbean = new StandardMBean(new MyMBeanImpl(), MyMBean.class);

        // Створення ObjectName для реєстрації MBean
        ObjectName mbeanName = new ObjectName("com.example:type=MyMBean");

        // Реєстрація MBean в MBean-сервері
        mbs.registerMBean(mbean, mbeanName);

        // Запуск програми
        System.out.println("Press Enter to terminate...");
        System.in.read();

        // Зупинка програми
    }
}
