package fr.nadeva;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.*;

public class BookIT {


    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("examplePersistenceUnit");
    private EntityManager entityManager;
    private EntityTransaction transaction;

    @Before
    public void initEntityManager() throws Exception {
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    @After
    public void closeEntityManager() throws Exception {
        if (entityManager != null) {
            entityManager.close();
        }
    }

    @Test
    public void createBook() throws Exception {
        String tableNameToCheck = "BOOK";
        String columnNameToCheck = "AUTHOR";

        List<String> tableList = DatabaseUtils.listTables();


        assertTrue(tableList.contains(tableNameToCheck));
        List<String> columnList = DatabaseUtils.listColumnsFromTable(tableNameToCheck);
        assertTrue(columnList.contains(columnNameToCheck));


        Book book = new Book();

        book.setName("Passionate Programmer");
        book.setAuthor("Chad Fowler");

        assertNull("ID should be null", book.getId());

        // Persists the book to the database
        transaction.begin();
        entityManager.persist(book);
        transaction.commit();
        assertNotNull("ID should not be null", book.getId());

        // Retrieves all the books from the database
        List<Book> books = entityManager.createNamedQuery("findAllBooks", Book.class).getResultList();
        assertEquals("1 book should be found", 1, books.size());

        Book bookFromEntityManager = books.get(0);

        assertEquals("Books should be the same", book, bookFromEntityManager);

        List<Book> booksFromJDBCConnection = DatabaseUtils.listBook(tableNameToCheck);
        assertEquals("1 book should be found", 1, booksFromJDBCConnection.size());

        Book bookFromDatabase = books.get(0);

        assertEquals("Books should be the same", book, bookFromDatabase);
    }


}
