package ua.goit.java.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.java.hibernate.controllers.DishController;
import ua.goit.java.hibernate.controllers.EmployeeController;
import ua.goit.java.hibernate.controllers.MenuController;
import ua.goit.java.hibernate.controllers.OrderController;

import java.util.ArrayList;
import java.util.List;

public class Main {
    @Autowired
    private EmployeeController employeeController;
    @Autowired
    private DishController dishController;
    @Autowired
    private OrderController orderController;
    @Autowired
    private MenuController menuController;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context-annotation.xml", "hibernate-context.xml");
            Main main = applicationContext.getBean(Main.class); // регистрируем меин метод
            main.start();

    }

    private void start() {

        /*System.out.println("------------------Employee-----------------------------------");

        employeeController.createEmployees();
        employeeController.addNewEmployee(employeeController.bornEmployee("Sasha","Beliy", 7777777, Position.MANAGER, 99999999.0F, "2001-10-01"));
        System.out.println("Find by name 'Sasha': " + employeeController.getEmployeesByName("Sasha"));
        System.out.println("All employees : ");employeeController.getAllEmployees().forEach(System.out::println);
//        employeeController.removeEmployee(employeeController.getEmployeesByName("Sasha"));
        System.out.println("--------------------Dishes---------------------------------");
        dishController.createDishes();
        dishController.addNewDish(dishController.prepareDish("Cake", DishCategory.DESSERT, 8.00F, 1.0F, Measures.PIECE));
        System.out.println("Find by name 'Cake': " + dishController.getDishByName("Cake"));
        System.out.println("All dishes : ");dishController.getAllDishes().forEach(System.out::println);
//        dishController.removeDish(dishController.getDishByName("Cake"));
        System.out.println("--------------------Menu---------------------------------");

        menuController.createMenus();

        List<Dish> desertDishes = new ArrayList<>();
        desertDishes.add(dishController.getDishByName("Cake"));
        menuController.addNewMenu(menuController.prepareMenu("Deserts", desertDishes));

        menuController.addDish(dishController.getDishByName("Milk"), menuController.findMenuByName("Deserts"));
        System.out.println(menuController.findMenuByName("Deserts"));
        menuController.findAllMenu().forEach(System.out::println);
//        menuController.deleteDish(dishController.getDishByName("Milk"), menuController.findMenuByName("Deserts"));
//        menuController.deleteMenu(menuController.findMenuByName("Deserts"));
        System.out.println("----------------------Orders-------------------------------");
*/
//        orderController.addOrders();
        List<String> dishesForSasha = new ArrayList<>();
        dishesForSasha.add("Salad");
        orderController.addNewOrder(orderController.createOrder("Sasha",dishesForSasha,1));
        orderController.findAllOrders().forEach(System.out::println);



















//        dishController.createDish();
//        List<String> dishes = new ArrayList<>();
//        dishes.add("Plov");
//        dishes.add("Salad");
//        orderController.createOrder("Ivan", dishes, 1);
//
//
//        List<String> dishes2 = new ArrayList<>();
//        dishes2.add("Salad");
//        dishes2.add("Milk");
//        orderController.createOrder("Peter", dishes2, 2);

//
//        employeeController.getAllEmployees().forEach(System.out::println);
//        dishController.getAllDishes().forEach(System.out::println);
//        orderController.getAllOrders().forEach(System.out::println);
//        orderController.printAllOrders();
//
//
//        System.out.println(dishController.getDishByName("Plov"));
//        System.out.println(employeeController.getEmployeesByName("Ivan"));
//        Menu menu = new Menu();
//        menu.setName("Zastolye");
//        menu.setDishes(dishController.getAllDishes());
//        menuController.createMenu(menu);
//        menuController.deleteDish(dishController.getDishByName("Salad"), menuController.findMenuByName("Zastolye"));
//        menuController.addDish(dishController.getDishByName("Salad"), menuController.findMenuByName("Zastolye"));
//        System.out.println(menuController.findMenuByName("Zastolye").toString());
    }


    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }
}
