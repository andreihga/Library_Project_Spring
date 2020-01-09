package sda.library.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sda.library.dto.BookDTO;
import sda.library.entity.Book;
import sda.library.service.BookService;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/")
public class BookController {

    @Autowired
    BookService bookService;

    //gets all books
    @GetMapping("/getAllBooks")
    public List<BookDTO> getAllBooks() {
        List<BookDTO> listOfBooksDTO = bookService.getAllBooks();
        return listOfBooksDTO;
    }

    //gets all books depending if they are borrowed or not
    @GetMapping("/getAllBorrowed/{isBorrowed}")
    public List<BookDTO> getAllBorrowed(@PathVariable boolean isBorrowed) {
        List<BookDTO> listOfAllBorrowedDTO = bookService.getAllBorrowed(isBorrowed);
        return listOfAllBorrowedDTO;
    }

    //gets all the books depending on the number of the volume
    @GetMapping("/getAllByVolume/{nr_volume}")
    public List<BookDTO> getAllBooksByVolume(@PathVariable int nr_volume) {
        List<BookDTO> getAllByVolume = bookService.getAllByVolume(nr_volume);
        return getAllByVolume;
    }

    //gets all the books depending on the name of the person who borrowed them
    @GetMapping("/getBooksBorrowedTo/{name}")
    public List<BookDTO> getBooksBorrowedTo(@PathVariable String name) {
        List<BookDTO> getBooksBorrowedToDTO = bookService.getAllBooksBorrowedTo(name);
        return getBooksBorrowedToDTO;
    }

    //gets all the books by category name
    @GetMapping("/getBooksByField/{field}")
    public List<BookDTO> getBooksByField(@PathVariable String field) {
        List<BookDTO> listOfBooksByFieldDTO = bookService.getBooksByField(field);

        return listOfBooksByFieldDTO;
    }

    //gets all the books depening on their category and if they are borrowed or not
    @GetMapping("/getAllBooksByFieldUnBorrowed/{field}/{borrowed}")
    public List<BookDTO> getAllBooksByFieldUnBorrowed(@PathVariable String field, @PathVariable boolean borrowed) {
        List<BookDTO> listOfBooksDTOByFieldUnBorrowed = bookService.getBooksByFieldUnBorrowed(field, borrowed);

        return listOfBooksDTOByFieldUnBorrowed;
    }

    //gets all the books depending on the author's name and if they are borrowed or not
    @GetMapping("/getBooksByAuthorBorrowed/{author}/{borrowed}")
    public List<BookDTO> getBooksByAuthorBorrowed(@PathVariable String author, @PathVariable boolean borrowed) {
        List<BookDTO> listOfBooksByAuthorBorrowedDTO = bookService.getBooksByAuthorBorrowed(author, borrowed);

        return listOfBooksByAuthorBorrowedDTO;
    }

    //deletes book by it's author
    @DeleteMapping("/deleteBookByAuthor/{author}")
    public void deleteBookByAuthor(@PathVariable String author) {
        bookService.deleteBookByAuthor(author);
    }

    //deletes the book by it's title name
    @DeleteMapping("/deleteBookByTitle/{title}")
    public void deleteBookByTitle(@PathVariable String title) {
        bookService.deleteBookByTitle(title);
    }

    //deletes the book by it's title, author and volume
    @DeleteMapping("/deleteBookByTitleAuthorVolume/{title}/{author}/{volume}")
    public void deleteBookByTitleAuthorVolume(@PathVariable String title, @PathVariable String author, @PathVariable int volume) {
        bookService.deleteBookByTitleAuthorVolume(title, author, volume);
    }

    //returns all books ordered by the number of the pages
    @GetMapping("/getBookAscendingByPages")
    public List<BookDTO> getBooksAscendingByPages() {
        List<BookDTO> listOfBooksAscendingByPages = bookService.getBooksAscendingByPages();

        return listOfBooksAscendingByPages;
    }
}