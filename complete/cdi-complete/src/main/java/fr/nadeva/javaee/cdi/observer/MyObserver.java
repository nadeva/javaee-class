package fr.nadeva.javaee.cdi.observer;

import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;


public class MyObserver {
    public void readEvent(@Observes String value) throws InterruptedException {
        System.out.println("Observer is notified: " + value);
        Thread.sleep(1000);
        System.out.println("Observer is done being notified");
    }

    public void readEventAsync(@ObservesAsync String value) throws InterruptedException {
        System.out.println("Observer async is notified: " + value);
        Thread.sleep(4000);
        System.out.println("Observer async is done being notified");
    }
}
