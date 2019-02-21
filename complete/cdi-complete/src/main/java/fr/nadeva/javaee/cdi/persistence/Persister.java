package fr.nadeva.javaee.cdi.persistence;

import fr.nadeva.javaee.cdi.model.User;

public interface Persister {

    int OK = 1;
    int KO = 0;

    int persist(User userToPersist);
}
