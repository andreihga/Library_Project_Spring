package sda.library.repository;

import org.springframework.stereotype.Repository;
import sda.library.config.DbInitializer;
import sda.library.entity.Book;

import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

@Repository
public class BookDAO {

    DbInitializer dbInitializer = new DbInitializer();


    public List<Book> getAllBooks() {

        dbInitializer.openSessionAndTransaction();
        List<Book> listOfBooks = new LinkedList<>();
        Query query = dbInitializer.session.createNamedQuery("getAllBooks");
        listOfBooks = query.getResultList();
        dbInitializer.closeSessionAndTransaction();

        return listOfBooks;
    }

    public List<Book> getAllBorrowed(boolean isBorrowed) {
        dbInitializer.openSessionAndTransaction();
        List<Book> listAllBorrowed = new LinkedList<>();
        Query query = dbInitializer.session.createNamedQuery("getAllBorrowed");
        query.setParameter("borrowed", isBorrowed);
        listAllBorrowed = query.getResultList();
        dbInitializer.closeSessionAndTransaction();

        return listAllBorrowed;
    }

    public List<Book> getAllByVolume(int nr_volume) {
        dbInitializer.openSessionAndTransaction();
        List<Book> listOfAllBooksByVolume = new LinkedList<>();
        Query query = dbInitializer.session.createNamedQuery("getAllByVolum");
        query.setParameter("volume", nr_volume);
        listOfAllBooksByVolume = query.getResultList();
        dbInitializer.closeSessionAndTransaction();

        return listOfAllBooksByVolume;
    }

    public List<Book> getAllBooksBorrowedTo(String name) {
        dbInitializer.openSessionAndTransaction();
        Query query = dbInitializer.session.createNamedQuery("getAllBookBorrowedTo");
        query.setParameter("borrowedTo", name);
        List<Book> listOfAllBooksBorrowedTo = query.getResultList();
        dbInitializer.closeSessionAndTransaction();

        return listOfAllBooksBorrowedTo;
    }

    public List<Book> getBooksByField(String field) {
        dbInitializer.openSessionAndTransaction();
        Query query = dbInitializer.session.createNamedQuery("getBooksByField");
        query.setParameter("field", field);
        List<Book> listOfBooksByField = query.getResultList();
        dbInitializer.closeSessionAndTransaction();

        return listOfBooksByField;
    }

    public List<Book> getBooksByFieldUnBorrowed(String field, boolean borrowed) {
        dbInitializer.openSessionAndTransaction();
        Query query = dbInitializer.session.createNamedQuery("getBooksByFieldUnBorrowed");
        query.setParameter("field", field);
        query.setParameter("borrowed", borrowed);
        List<Book> listOfBooksByFieldUnBorrowed = query.getResultList();
        dbInitializer.closeSessionAndTransaction();

        return listOfBooksByFieldUnBorrowed;
    }

    public List<Book> getBooksByAuthorBorrowed(String author, boolean borrowed) {
        dbInitializer.openSessionAndTransaction();
        Query query = dbInitializer.session.createNamedQuery("getBooksByAuthorBorrowed");
        query.setParameter("author", author);
        query.setParameter("borrowed", borrowed);
        List<Book> listOfBooksByAuthorBorrowed = query.getResultList();
        dbInitializer.closeSessionAndTransaction();

        return listOfBooksByAuthorBorrowed;
    }

    public void deleteBookByAuthor(String author) {
        dbInitializer.openSessionAndTransaction();
        Query query = dbInitializer.session.createNamedQuery("deleteBookByAuthor");
        query.setParameter("author", author);
        query.executeUpdate();
        dbInitializer.closeSessionAndTransaction();
    }

    public void deleteBookByTitle(String title) {
        dbInitializer.openSessionAndTransaction();
        Query query = dbInitializer.session.createNamedQuery("deleteBookByTitle");
        query.setParameter("title", title);
        query.executeUpdate();
        dbInitializer.closeSessionAndTransaction();
    }

    public void deleteBookByTitleAuthorVolume(String title, String author, int volume) {
        dbInitializer.openSessionAndTransaction();
        Query query = dbInitializer.session.createNamedQuery("deleteBookByTitleAuthorVolume");
        query.setParameter("title", title);
        query.setParameter("author", author);
        query.setParameter("volume", volume);
        query.executeUpdate();
        dbInitializer.closeSessionAndTransaction();
    }

    public List<Book> getBooksAscendingByPages(){
        dbInitializer.openSessionAndTransaction();
        Query query = dbInitializer.session.createNamedQuery("getBooksAscendingByPages");
        List<Book> listOfBooksAscendingByPages = query.getResultList();
        dbInitializer.closeSessionAndTransaction();

        return listOfBooksAscendingByPages;
    }
}
