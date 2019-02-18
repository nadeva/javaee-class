package fr.nadeva;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.EJBException;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BookServiceIT {


    private BookService bookService;
    private EJBContainer container;

    @Before
    public void prepare() throws NamingException {
        Map<String, Object> properties = new HashMap<>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));
        container = javax.ejb.embeddable.EJBContainer.createEJBContainer(properties);

        bookService = (BookService) container.getContext().lookup("java:global/classes/BookService");
    }

    @Test
    public void createFindAndDelete() {


        Book book = new Book();
        book.setName("Passionate Programmer");

        assertNull("Id should be null", book.getId());

        book = bookService.persist(book);
        assertNotNull("Id should not be null", book.getId());

        final Long bookId = book.getId();
        Book bookFound = bookService.findById(bookId);
        assertEquals("Id should be equal", book.getId(), bookFound.getId());
        assertEquals("Name should be equal", book.getName(), bookFound.getName());

        bookService.delete(bookId);

        assertNull("FindById should find no results", bookService.findById(bookId));
        assertTrue("FindAll should be empty", bookService.findAll().isEmpty());
    }



    @After
    public void clean() {
        container.close();
    }

}
