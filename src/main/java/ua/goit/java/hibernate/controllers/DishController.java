package ua.goit.java.hibernate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.hibernate.dao.DishDao;
import ua.goit.java.hibernate.model.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DishController {

    @Autowired
    private DishDao dishDao;

    public Dish prepareDish(String name, DishCategory category, Float price, Float weight, Measures measure) {
        Dish dish = new Dish();
        dish.setName(name);
        dish.setCategory(category);
        dish.setPrice(price);
        dish.setWeight(weight);
        dish.setMeasure(measure);
        return dish;
    }

    @Transactional
    public void createDishes() {
        Dish plov = prepareDish("Plov", DishCategory.MAIN, 5.00F, 0.250F, Measures.KG);
        Dish milk = prepareDish("Milk", DishCategory.MAIN, 1.00F, 0.150F, Measures.LITER);
        Dish salad = prepareDish("Salad", DishCategory.SALAD, 2.00F, 0.200F, Measures.KG);

        Set<Dish> dishes = new HashSet<>(dishDao.findAll());
        if (!dishes.contains(plov)) {
            dishDao.save(plov);
        }
        if (!dishes.contains(milk)) {
            dishDao.save(milk);
        }
        if (!dishes.contains(salad)) {
            dishDao.save(salad);
        }
    }

    @Transactional
    public void addNewDish(Dish dish) {
        Set<Dish> allDishes = new HashSet<>(dishDao.findAll());

        if (!allDishes.contains(dish)) {    // если такого еще нет в БД, то добавляем
            dishDao.save(dish);
        }
    }

    @Transactional
    public void removeDish(Dish dish) {
        dishDao.remove(dish);
    }
    @Transactional
    public List<Dish> getAllDishes() {
        return dishDao.findAll();
    }

    @Transactional
    public Dish getDishByName(String name) {
        return dishDao.findByName(name);
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
