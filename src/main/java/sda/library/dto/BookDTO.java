package sda.library.dto;

import java.util.Objects;

public class BookDTO {
    String title;
    String author;
    int nr_pages;
    int volume;
    boolean borrowed;
    String borrowed_to;
    String field;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDTO bookDTO = (BookDTO) o;
        return nr_pages == bookDTO.nr_pages &&
                volume == bookDTO.volume &&
                borrowed == bookDTO.borrowed &&
                Objects.equals(title, bookDTO.title) &&
                Objects.equals(author, bookDTO.author) &&
                Objects.equals(borrowed_to, bookDTO.borrowed_to) &&
                Objects.equals(field, bookDTO.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, nr_pages, volume, borrowed, borrowed_to, field);
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", nr_pages=" + nr_pages +
                ", volume=" + volume +
                ", borrowed=" + borrowed +
                ", borrowed_to='" + borrowed_to + '\'' +
                ", field='" + field + '\'' +
                '}';
    }

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
