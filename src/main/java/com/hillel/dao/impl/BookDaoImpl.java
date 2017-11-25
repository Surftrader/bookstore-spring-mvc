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

    private Session session = sessionFactory.openSession();
    private Transaction transaction = session.beginTransaction();

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Book book) {
        session.persist(book);
        transaction.commit();
        session.close();
    }

    public List<Book> findAll() {
        return session.createCriteria(Book.class).list();
  //      return session.createCriteria(Book.class, "select b from book b").list();
    }

    public Book findById(Integer id) {
        return (Book) session.get(Book.class, id);
    }

    public void delete(Book book) {
        //TODO:
        session.delete(book);
        transaction.commit();
        session.close();
    }

    public void update(Book book) {
        //TODO:
        session.merge(book);
        transaction.commit();
        session.close();
    }
}
