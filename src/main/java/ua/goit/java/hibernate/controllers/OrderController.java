package ua.goit.java.hibernate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.hibernate.dao.DishDao;
import ua.goit.java.hibernate.dao.EmployeeDao;
import ua.goit.java.hibernate.dao.OrderDao;
import ua.goit.java.hibernate.model.Dish;
import ua.goit.java.hibernate.model.Orders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DishDao dishDao;
    @Autowired
    private OrderDao orderDao;

    @Transactional
    public void createOrder(String waiterName, List<String> dishes, int tableNumber){

        Orders order = new Orders();
        order.setWaiter(employeeDao.findByName(waiterName));
        order.setDishes(createDishes(dishes));
        order.setTableNumber(tableNumber);
        order.setOrderDate(new Date());

        orderDao.save(order);
    }

@Transactional
    public List<Orders> getAllOrders(){
        return orderDao.findAllOrders();
    }

@Transactional
    public void printAllOrders() {
        getAllOrders().forEach(System.out::println);

    }

    private List<Dish> createDishes(List<String> dishes) {

        List<Dish> result = new ArrayList<>();
        for (String dishName : dishes) {
            result.add(dishDao.findByName(dishName));
        }

        return result;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
