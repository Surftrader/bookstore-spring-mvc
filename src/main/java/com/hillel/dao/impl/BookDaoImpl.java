package com.hillel.dao.impl;

import com.hillel.dao.BookDao;
import com.hillel.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Book book) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(book);
        transaction.commit();
        session.close();
    }

    public List<Book> findAll() {
        Session session = this.sessionFactory.openSession();
        return session.createCriteria(Book.class).list();
    }

    public Book findById(Integer id) {
        Session session = this.sessionFactory.openSession();
        return (Book) session.get(Book.class, id);
    }

    public void delete(Book book) {
        ////////TODO:
    }

    public void update(Book book) {
        ////////TODO:
    }
}
