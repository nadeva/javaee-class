package fr.nadeva.javaee.cdi.persistence;

import fr.nadeva.javaee.cdi.model.User;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.interceptor.Interceptor;

@Alternative
@Priority(Interceptor.Priority.APPLICATION)
public class MockPersister implements Persister {

    @Override
    public int persist(User userToPersist) {
        System.out.println("NO PERSISTING, this is a test!");
        return Persister.KO;
    }


}
