package com.hillel.dao.impl;

import com.hillel.dao.AuthorDao;
import com.hillel.model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Author author) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        session.persist(author);
        transaction.commit();
        session.close();
    }

    public List<Author> findAll() {
        Session session = this.sessionFactory.openSession();
        return session.createCriteria(Author.class).list();
    }

    public Author findById(Integer id) {
        Session session = this.sessionFactory.openSession();
        return (Author) session.get(Author.class, id);
    }

    public void delete(Author author) {
        ////////TODO:
    }

    public void update(Author author) {
        ////////TODO:
    }
}
