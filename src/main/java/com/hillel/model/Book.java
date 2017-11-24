package com.hillel.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "book_name")
    private String bookName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    //////////////////////////////
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "items",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private List<Author> authors;
    //////////////////////////////

    public Book() {
    }

    public Book(Integer id, String bookName) {
        this.id = id;
        this.bookName = bookName;
    }

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Book(String bookName, List<Author> authors) {
        this.bookName = bookName;
        this.authors = authors;
    }

    public Book(String bookName, List<Author> authors, User user) {
        this.bookName = bookName;
        this.authors = authors;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Author> getAuthors() {

        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    /////////////////////
    public static List<Author> stringToList(Author author) {
        String[] list = author.getAuthorName().split(",");
        return (List<Author>) new ArrayList(Arrays.asList(list));
    }

    public static String listToString(List<Author> list) {
        StringBuilder sb  = new StringBuilder();
        for (Author a: list) {
            sb.append(a.getAuthorName());
            sb.append("\n");
        }
        return sb.toString();
    }
    /////////////////////
}
