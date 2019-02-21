package fr.nadeva.javaee.cdi.producer;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class MyProducer {

    @Produces
    private int myInt = 7;

    @Produces
    public String produceString(InjectionPoint injectionPoint) {
        System.out.println("Calling class " + injectionPoint.getMember().getDeclaringClass().getName());
        System.out.println("Point in class " + injectionPoint.getMember().getName());
        return "hello";
    }

}
