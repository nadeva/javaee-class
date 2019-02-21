package fr.nadeva.javaee.cdi.notifier;

import fr.nadeva.javaee.cdi.qualifier.Media;
import fr.nadeva.javaee.cdi.qualifier.NotificationMedia;

import javax.enterprise.inject.Default;

public class EmailNotifier implements Notifier {

    @Override
    public int sendNotification(String notificationMessage) {
        System.out.println("Sending by email the following message [" + notificationMessage + "]");
        return Notifier.EMAIL;
    }

}
