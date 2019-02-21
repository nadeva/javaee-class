package fr.nadeva.javaee.cdi;

import java.util.Properties;

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

    public UserServiceNoCDI(String propertiesFilePath) throws Exception {
        Properties properties = new Properties();
        properties.load(ClassLoader.class.getResourceAsStream(propertiesFilePath));
        String notifierClass = properties.getProperty("notifier.class");
        String persisterClass = properties.getProperty("persister.class");
        notifier = (Notifier) Class.forName(notifierClass).newInstance();
        persister = (Persister) Class.forName(persisterClass).newInstance();
    }

    public void createUser(User newUser) {

        System.out.println("Beginning method createUser");

        this.persister.persist(newUser);
        this.notifier.sendNotification("User " + newUser.toString() + " created");

        System.out.println("Ending method createUser");

    }

}
