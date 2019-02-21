package fr.nadeva.javaee.cdi;

import javax.inject.Inject;

import fr.nadeva.javaee.cdi.model.User;
import fr.nadeva.javaee.cdi.notifier.Notifier;
import fr.nadeva.javaee.cdi.persistence.Persister;


public class UserService {

    @Inject
    private Notifier notifier;

    @Inject
    private Persister persister;

    private int notificationCode;

    public UserService() {
        //default constructor
    }

    public int createUser(User newUser) {

        System.out.println("Beginning method createUser");

        int confirmationCode = this.persister.persist(newUser);

        notificationCode = this.notifier.sendNotification("User " + newUser.toString() + " created");
        System.out.println("Notification Code " + notificationCode);

        System.out.println("Ending method createUser");

        return confirmationCode;
    }

    public int getNotificationCode() {
        return notificationCode;
    }

    public void nothing() {

    }


}
