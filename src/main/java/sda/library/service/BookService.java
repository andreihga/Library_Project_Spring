package sda.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.library.dto.BookDTO;
import sda.library.entity.Book;
import sda.library.repository.BookDAO;

import java.util.LinkedList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDAO bookDAO;

    public List<BookDTO> getAllBooks(){
        List<BookDTO> listOfBooksDTO = new LinkedList<>();
        List<Book> listOfBooks = bookDAO.getAllBooks();

        return getBookDTOS(listOfBooks, listOfBooksDTO);
    }

    public List<BookDTO> getAllBorrowed (boolean isBorrowed){
        List<Book> listOfAllBorrowed = bookDAO.getAllBorrowed(isBorrowed);
        List<BookDTO> listOfAllBorrowedDTO = new LinkedList<>();

        return getBookDTOS(listOfAllBorrowed, listOfAllBorrowedDTO);
    }

    public List<BookDTO> getAllByVolume(int nr_volume){
        List<Book> listOfAllBooksByVolume = bookDAO.getAllByVolume(nr_volume);
        List<BookDTO> listOfAllBooksByVolumeDTO = new LinkedList<>();
        getBookDTOS(listOfAllBooksByVolume, listOfAllBooksByVolumeDTO);

        return listOfAllBooksByVolumeDTO;
    }

    public List<BookDTO> getAllBooksBorrowedTo(String name){

        List<Book> listOfBooksBorrowedTo = bookDAO.getAllBooksBorrowedTo(name);
        List<BookDTO> listOfBooksBorrowedToDTO = new LinkedList<>();

        getBookDTOS(listOfBooksBorrowedTo,listOfBooksBorrowedToDTO);

        return listOfBooksBorrowedToDTO;

    }

    public List<BookDTO> getBooksByField(String field){
        List<Book> listOfBooksByField = bookDAO.getBooksByField(field);
        List<BookDTO> listOfBooksByFieldDTO = new LinkedList<>();

        getBookDTOS(listOfBooksByField,listOfBooksByFieldDTO);

        return listOfBooksByFieldDTO;
    }

    public List<BookDTO> getBooksByFieldUnBorrowed(String field, boolean borrowed){
        List<Book> listOfBooksByFieldUnBorrowed = bookDAO.getBooksByFieldUnBorrowed(field,borrowed);
        List<BookDTO> listOfBooksByFieldUnBorrowedDTO = new LinkedList<>();

        getBookDTOS(listOfBooksByFieldUnBorrowed,listOfBooksByFieldUnBorrowedDTO);

        return listOfBooksByFieldUnBorrowedDTO;
    }

    public List<BookDTO> getBooksByAuthorBorrowed(String author, boolean borrowed){
        List<Book> listOfBookByAuthorBorrowed = bookDAO.getBooksByAuthorBorrowed(author,borrowed);
        List<BookDTO> listOfBooksByAuthorBorrowedDTO = new LinkedList<>();
        getBookDTOS(listOfBookByAuthorBorrowed,listOfBooksByAuthorBorrowedDTO);

        return listOfBooksByAuthorBorrowedDTO;
    }

    public void deleteBookByAuthor(String author){
        bookDAO.deleteBookByAuthor(author);
    }

    public void deleteBookByTitle(String title){
        bookDAO.deleteBookByTitle(title);
    }

    public void deleteBookByTitleAuthorVolume(String title, String author, int volume){
        bookDAO.deleteBookByTitleAuthorVolume(title,author,volume);
    }

    public List<BookDTO> getBooksAscendingByPages(){
        List<Book> listOfBooksAscendingByPages = bookDAO.getBooksAscendingByPages();
        List<BookDTO> listOfBooksAscendingByPagesDTO = new LinkedList<>();
        getBookDTOS(listOfBooksAscendingByPages,listOfBooksAscendingByPagesDTO);

        return listOfBooksAscendingByPagesDTO;
    }

    private List<BookDTO> getBookDTOS(List<Book> listOfAllBorrowed, List<BookDTO> listOfAllBorrowedDTO) {
        for (Book b:listOfAllBorrowed) {
            BookDTO bookDTO = new BookDTO();

            bookDTO.setTitle(b.getTitle());
            bookDTO.setAuthor(b.getAuthor());
            bookDTO.setNr_pages(b.getNr_pages());
            bookDTO.setVolume(b.getVolume());
            bookDTO.setBorrowed(b.isBorrowed());
            bookDTO.setBorrowed_to(b.getBorrowed_to());
            bookDTO.setField(b.getField());

            listOfAllBorrowedDTO.add(bookDTO);
        }
        return listOfAllBorrowedDTO;
    }



}
