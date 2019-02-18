package fr.nadeva.javaee.cdi;

import fr.nadeva.javaee.cdi.model.User;
import fr.nadeva.javaee.cdi.notifier.EmailNotifier;
import fr.nadeva.javaee.cdi.notifier.Notifier;
import fr.nadeva.javaee.cdi.persistence.DatabasePersister;
import fr.nadeva.javaee.cdi.persistence.Persister;

/**
 * @author Olivier Truong
 */
public class UserServiceNoCDI {


    private Notifier notifier;

    private Persister persister;

    public UserServiceNoCDI() {
        notifier = new EmailNotifier();
        persister = new DatabasePersister();
    }

    public UserServiceNoCDI(Notifier userNotifier, Persister userPersister) {
        notifier = userNotifier;
        persister = userPersister;
    }

    //TODO
    public UserServiceNoCDI(String propertiesFilePath) throws Exception {
    }

    public void createUser(User newUser) {

        System.out.println("Beginning method createUser");

        this.persister.persist(newUser);
        this.notifier.sendNotification("User " + newUser.toString() + " created");

        System.out.println("Ending method createUser");

    }

}
