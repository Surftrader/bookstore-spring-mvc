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

    private Session session = this.sessionFactory.openSession();
    private Transaction transaction = session.getTransaction();

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Author author) {
        session.persist(author);
        transaction.commit();
        session.close();
    }

    public List<Author> findAll() {
        return session.createCriteria(Author.class).list();
     //   return session.createCriteria(Author.class, "select a from author a").list();
    }

    public Author findById(Integer id) {
        return (Author) session.get(Author.class, id);
    }

    public void delete(Author author) {
        //TODO:
        session.delete(author);
        transaction.commit();
        session.close();
    }

    public void update(Author author) {
        //TODO:
        session.merge(author);
        transaction.commit();
        session.close();
    }
}
