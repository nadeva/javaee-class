package fr.nadeva.javaee.cdi;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import fr.nadeva.javaee.cdi.model.User;

public class MainWithCDI {

    public static void main(String[] args) {

        User user = new User("Chuck", "chuck@norris.com");

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            UserService userService = container.select(UserService.class).get();

            int confirmationCode = userService.createUser(user);

            System.out.println("Confirmation Code is " + confirmationCode);
            System.out.println("Notification code is " + userService.getNotificationCode());

            userService.nothing();

        }

    }

}
