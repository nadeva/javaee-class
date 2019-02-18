package fr.nadeva.javaee.cdi.notifier;

public class EmailNotifier implements Notifier {

    @Override
    public int sendNotification(String notificationMessage) {
        System.out.println("Sending by email the following message [" + notificationMessage + "]");
        return Notifier.EMAIL;
    }

}
