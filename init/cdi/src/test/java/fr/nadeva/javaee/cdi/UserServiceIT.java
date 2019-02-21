package fr.nadeva.javaee.cdi;

import org.junit.Test;

public class UserServiceIT {

    @Test
    public void createUser() {
        int confirmationCode = persistUser();
//        assertEquals(Persister.KO, confirmationCode);
    }

    private int persistUser() {

        //TODO
        int confirmationCode = -2;
        return confirmationCode;
    }

}