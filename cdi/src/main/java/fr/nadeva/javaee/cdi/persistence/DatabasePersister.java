package fr.nadeva.javaee.cdi.persistence;

import fr.nadeva.javaee.cdi.model.User;

public class DatabasePersister implements Persister {

    @Override
    public int persist(User userToPersist) {
        System.out.println("Persisting in database user: " + userToPersist.toString());
        return Persister.OK;
    }


}
