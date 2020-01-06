package sda.library.entity;





import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "getAllBooks",query = "select b from Book b"),
        @NamedQuery(name = "getAllBorrowed", query = "select b from Book b where borrowed = :borrowed"),
        @NamedQuery(name = "getAllByVolum", query = "select b from Book b where volume = :volume"),
        @NamedQuery(name = "getAllBookBorrowedTo", query = "select b from Book b where borrowed_to = :borrowedTo"),
        @NamedQuery(name = "getBooksByField", query = "select b from Book b where field = :field"),
        @NamedQuery(name = "getBooksByFieldUnBorrowed", query = "select b from Book b where field = :field and borrowed = :borrowed"),
        @NamedQuery(name = "getBooksByAuthorBorrowed", query = "select b from Book b where author = :author and borrowed = :borrowed"),
        @NamedQuery(name = "deleteBookByAuthor", query = "delete from Book where author = :author"),
        @NamedQuery(name = "deleteBookByTitle",query = "delete from Book where title = :title"),
        @NamedQuery(name = "deleteBookByTitleAuthorVolume", query = "delete from Book where title = :title and author = :author and volume = :volume"),
        @NamedQuery(name = "getBooksAscendingByPages", query = "select b from Book b order by nr_pages")
})

@Entity
@Table(name = "library")

public class Book {

    @Id
    int id;
    @Column(name = "title")
    String title;
    @Column(name = "author")
    String author;
    @Column(name = "nr_pages")
    int nr_pages;
    @Column(name = "volume")
    int volume;
    @Column(name = "borrowed")
    boolean borrowed;
    @Column(name = "borrowed_to")
    String borrowed_to;
    @Column(name = "field")
    String field;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNr_pages() {
        return nr_pages;
    }

    public void setNr_pages(int nr_pages) {
        this.nr_pages = nr_pages;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public String getBorrowed_to() {
        return borrowed_to;
    }

    public void setBorrowed_to(String borrowed_to) {
        this.borrowed_to = borrowed_to;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
