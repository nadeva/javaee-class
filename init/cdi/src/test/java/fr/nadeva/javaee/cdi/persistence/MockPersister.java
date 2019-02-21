package fr.nadeva.javaee.cdi.persistence;

import fr.nadeva.javaee.cdi.model.User;


public class MockPersister implements Persister {

    @Override
    public int persist(User userToPersist) {
        //TODO
        return -1;
    }


}
