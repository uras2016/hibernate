package ua.goit.java.hibernate.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.hibernate.dao.DishDao;
import ua.goit.java.hibernate.model.Dish;
import ua.goit.java.hibernate.model.Employee;

import java.util.List;

public class HDishDao implements DishDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);
    }

    @Override
    @Transactional
    public List<Dish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select d from Dish d").list();
    }

    @Override
    @Transactional
    public Dish findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Dish e where e.name like :name"); // :name - параметр, переданный в запрос
        query.setParameter("name", name);
        return (Dish) query.uniqueResult();
    }

    @Override
    @Transactional
    public void remove(Dish dish) {
            sessionFactory.getCurrentSession().delete(dish);
        }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
