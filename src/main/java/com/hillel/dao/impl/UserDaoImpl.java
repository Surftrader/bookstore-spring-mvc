package com.hillel.dao.impl;

import com.hillel.dao.UserDao;
import com.hillel.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        session.close();
    }

    public List<User> findAll() {
        Session session = this.sessionFactory.openSession();
        return session.createCriteria(User.class).list();
    }

    public User findById(Integer id) {
        Session session = this.sessionFactory.openSession();
        return (User) session.get(User.class, id);
    }

    public void delete(User user) {
        ////////TODO:
    }

    public void update(User user) {
        ////////TODO:
    }
}
