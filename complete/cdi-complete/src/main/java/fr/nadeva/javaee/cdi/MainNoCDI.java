package fr.nadeva.javaee.cdi;

import fr.nadeva.javaee.cdi.model.User;
import fr.nadeva.javaee.cdi.notifier.EmailNotifier;
import fr.nadeva.javaee.cdi.persistence.DatabasePersister;

public class MainNoCDI {

    public static void main(String[] args) throws Exception {

        User user = new User("Chuck", "chuck@norris.com");

//        createUserWithNoInjection(user);
//        createUserWithInjectionFromTheConstructor(user);
//
//
//        createUserWithInjectionFromPropertiesFile(user);

        createUserWithCDI(user);
    }


    private static void createUserWithNoInjection(User user) {
        System.out.println("With no Injection");

        UserServiceNoCDI userService = new UserServiceNoCDI();
        userService.createUser(user);
        System.out.println("-----------------");
    }

    private static void createUserWithInjectionFromTheConstructor(User user) {
        System.out.println("With Injection from the constructor");

        UserServiceNoCDI userServiceWithIOC = new UserServiceNoCDI(new EmailNotifier(), new DatabasePersister());
        userServiceWithIOC.createUser(user);
        System.out.println("-----------------");
    }


    private static void createUserWithInjectionFromPropertiesFile(User user) throws Exception {
        System.out.println("With Properties file");
        UserServiceNoCDI userService = new UserServiceNoCDI("/injection.properties");
        userService.createUser(user);
    }

    private static void createUserWithCDI(User user) {
        System.out.println("With Injection using @Inject");

        UserService userServiceWithIOCInjected = new UserService();
        userServiceWithIOCInjected.createUser(user);
    }


}
