package ua.goit.java.hibernate.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ua.goit.java.hibernate.dao.OrderDao;
import ua.goit.java.hibernate.model.Orders;

import java.util.List;

public class HOrderDao implements OrderDao{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(Orders order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public List<Orders> findAllOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Orders o").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
