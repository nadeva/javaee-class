package fr.nadeva.javaee.cdi.notifier;

public interface Notifier {

    int EMAIL = 1;
    int SMS = 10;
    int POSTMAIL = 100;

    int sendNotification(String notificationMessage);
}
