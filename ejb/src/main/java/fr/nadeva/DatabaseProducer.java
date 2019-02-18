package fr.nadeva;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DatabaseProducer {

    @Produces
    @PersistenceContext(unitName = "examplePersistenceUnit")
    private EntityManager entityManager;

}
