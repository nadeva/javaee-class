package fr.nadeva.javaee.cdi.notifier;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

@Decorator
@Priority(Interceptor.Priority.APPLICATION)
public class PostMailNotifier implements Notifier {

    @Inject
    @Delegate
    Notifier notifier;

    @Override
    public int sendNotification(String notificationMessage) {
        System.out.println("Sending by post mail the following message [" + notificationMessage + "]");
        return Notifier.POSTMAIL + notifier.sendNotification(notificationMessage);
    }
}
