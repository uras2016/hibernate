package ua.goit.java.hibernate.dao;

import ua.goit.java.hibernate.model.Orders;

import java.util.List;

public interface OrderDao {

    void save(Orders order);

    List<Orders> findAllOrders();
}
