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

    @GetMapping("/getAllBooks")
    public List<BookDTO> getAllBooks() {
        List<BookDTO> listOfBooksDTO = bookService.getAllBooks();
        return listOfBooksDTO;
    }

    @GetMapping("/getAllBorrowed/{isBorrowed}")
    public List<BookDTO> getAllBorrowed(@PathVariable boolean isBorrowed) {
        List<BookDTO> listOfAllBorrowedDTO = bookService.getAllBorrowed(isBorrowed);
        return listOfAllBorrowedDTO;
    }

    @GetMapping("/getAllByVolume/{nr_volume}")
    public List<BookDTO> getAllBooksByVolume(@PathVariable int nr_volume) {
        List<BookDTO> getAllByVolume = bookService.getAllByVolume(nr_volume);
        return getAllByVolume;
    }

    @GetMapping("/getBooksBorrowedTo/{name}")
    public List<BookDTO> getBooksBorrowedTo(@PathVariable String name) {
        List<BookDTO> getBooksBorrowedToDTO = bookService.getAllBooksBorrowedTo(name);
        return getBooksBorrowedToDTO;
    }

    @GetMapping("/getBooksByField/{field}")
    public List<BookDTO> getBooksByField(@PathVariable String field) {
        List<BookDTO> listOfBooksByFieldDTO = bookService.getBooksByField(field);

        return listOfBooksByFieldDTO;
    }

    @GetMapping("/getAllBooksByFieldUnBorrowed/{field}/{borrowed}")
    public List<BookDTO> getAllBooksByFieldUnBorrowed(@PathVariable String field, @PathVariable boolean borrowed) {
        List<BookDTO> listOfBooksDTOByFieldUnBorrowed = bookService.getBooksByFieldUnBorrowed(field, borrowed);

        return listOfBooksDTOByFieldUnBorrowed;
    }

    @GetMapping("/getBooksByAuthorBorrowed/{author}/{borrowed}")
    public List<BookDTO> getBooksByAuthorBorrowed(@PathVariable String author, @PathVariable boolean borrowed) {
        List<BookDTO> listOfBooksByAuthorBorrowedDTO = bookService.getBooksByAuthorBorrowed(author, borrowed);

        return listOfBooksByAuthorBorrowedDTO;
    }

    @DeleteMapping("/deleteBookByAuthor/{author}")
    public void deleteBookByAuthor(@PathVariable String author) {
        bookService.deleteBookByAuthor(author);
    }

    @DeleteMapping("/deleteBookByTitle/{title}")
    public void deleteBookByTitle(@PathVariable String title) {
        bookService.deleteBookByTitle(title);
    }

    @DeleteMapping("/deleteBookByTitleAuthorVolume/{title}/{author}/{volume}")
    public void deleteBookByTitleAuthorVolume(@PathVariable String title, @PathVariable String author, @PathVariable int volume) {
        bookService.deleteBookByTitleAuthorVolume(title, author, volume);
    }

    @GetMapping("/getBookAscendingByPages")
    public List<BookDTO> getBooksAscendingByPages(){
        List <BookDTO> listOfBooksAscendingByPages = bookService.getBooksAscendingByPages();

        return listOfBooksAscendingByPages;
    }
}