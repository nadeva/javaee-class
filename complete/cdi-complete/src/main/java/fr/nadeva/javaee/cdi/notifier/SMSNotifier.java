package fr.nadeva.javaee.cdi.notifier;

import fr.nadeva.javaee.cdi.qualifier.PhoneNotification;

@PhoneNotification
public class SMSNotifier implements Notifier {

    public int sendNotification(String notificationMessage) {
        System.out.println("Sending by SMS the following message [" + notificationMessage + "]");
        return Notifier.SMS;
    }
}