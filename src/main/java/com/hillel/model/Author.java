package com.hillel.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "author_name")
    private String authorName;

    //////////////////////////////
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "authors")
    private List<Book> books;
    //////////////////////////////

    public Author() {
    }

    public Author(String authorName) {
        this.authorName = authorName;
    }

    public Author(Integer id, String authorName) {
        this.id = id;
        this.authorName = authorName;
    }

    public Author(String authorName, List<Book> books) {
        this.authorName = authorName;
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", books=" + books +
                '}';
    }

    /////////////////////
    public List<Author> stringToList() {
        String[] list = authorName.split(",");
        return (List<Author>) new ArrayList(Arrays.asList(list));
    }
    /////////////////////


}
