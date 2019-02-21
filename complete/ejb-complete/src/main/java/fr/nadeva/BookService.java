package fr.nadeva;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Stateless
public class BookService {

    @Inject
    private EntityManager entityManager;
    
    public Book persist(Book book) {
        entityManager.persist(book);
        return book;
    }

    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public void delete(Long id) {
        entityManager.remove(entityManager.find(Book.class, id));
    }

    public List<Book> findAll() {
        return entityManager.createNamedQuery("findAllBooks", Book.class).getResultList();
    }


}
