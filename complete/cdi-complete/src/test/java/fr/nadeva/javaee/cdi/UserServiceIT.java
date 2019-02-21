package fr.nadeva.javaee.cdi;

import fr.nadeva.javaee.cdi.model.User;
import fr.nadeva.javaee.cdi.persistence.Persister;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import static org.junit.Assert.assertEquals;

public class UserServiceIT {

    @Test
    public void createUser() {
        int confirmationCode = persistUser();
        assertEquals(Persister.KO, confirmationCode);
    }

    private int persistUser() {
        User user = new User("Chuck", "chuck@norris.com");

        try(SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            UserService userService = container.select(UserService.class).get();

            int confirmationCode = userService.createUser(user);

            userService.notifyString("coooool");

            assertEquals(userService.getMyInjectedInt(), 7);
            assertEquals(userService.getMyInjectedString(), "hello");
            return confirmationCode;

        }


    }

}