package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    private String book_id;
    private String tittle;
    private double price;
    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;

    public Book(){}
    public Book(String book_id, String tittle, double price, Author author2) {
        this.book_id = book_id;
        this.tittle = tittle;
        this.price = price;
        this.author = author2;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id='" + book_id + '\'' +
                ", tittle='" + tittle + '\'' +
                ", price=" + price +
                ", author=" + author +
                '}';
    }
}
