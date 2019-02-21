package fr.nadeva.javaee.cdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import fr.nadeva.javaee.cdi.interceptor.BigBrowser;
import fr.nadeva.javaee.cdi.model.User;
import fr.nadeva.javaee.cdi.notifier.Notifier;
import fr.nadeva.javaee.cdi.persistence.Persister;
import fr.nadeva.javaee.cdi.qualifier.PhoneNotification;

@BigBrowser
public class UserService {

    @Inject
//    @PhoneNotification
    private Notifier notifier;

    @Inject
    private Persister persister;

    private int notificationCode;

    @Inject
    private String myInjectedString;

    @Inject
    private int myInjectedInt;

    @Inject
    private Event<String> stringEvent;

//    @Inject
//    public void setPersister(Persister persister) {
//        this.persister = persister;
//    }

//    @Inject
//    public UserService(Persister persister) {
//        this.persister = persister;
//    }

    public int createUser(User newUser) {

        System.out.println("myInjectedString " + myInjectedString);
        System.out.println("myInjectedInt " + myInjectedInt);
        System.out.println("Beginning method createUser");

        int confirmationCode = this.persister.persist(newUser);

        notificationCode = this.notifier.sendNotification("User " + newUser.toString() + " created");
        System.out.println("Notification Code " + notificationCode);

        System.out.println("Ending method createUser");
        stringEvent.fire("Fire event!");

        return confirmationCode;
    }


    public String getMyInjectedString() {
        return myInjectedString;
    }

    public int getMyInjectedInt() {
        return myInjectedInt;
    }

    public int getNotificationCode() {
        return notificationCode;
    }

    public void nothing() {
    }

    public void notifyString(String value) {
        System.out.println("Fire");
        stringEvent.fireAsync(value);

        stringEvent.fire(value);
        System.out.println("OK finishing");
    }

    @PostConstruct
    private void construct() {
        System.out.println("Post Construct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Pre Destroy");
    }

    @AroundInvoke
    private Object intercept(InvocationContext ic) throws Exception {
        System.out.println("Around Invoke " + ic.getMethod().getName());
        return ic.proceed();
    }


}
