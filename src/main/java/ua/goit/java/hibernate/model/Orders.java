package ua.goit.java.hibernate.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @ManyToOne          /*много ордеров у одного емплоии*/
    @JoinColumn(name = "employee_id")   /*в колонку employee_id будем заносить айдишники емплоии*/
    private Employee waiter;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)             /* нужна третья таблица    в несколько ордеров могут входить много диш, несколько диш могут входить в разные ордеры*/
    @JoinTable(
            name = "dish_to_order",     /*имя третей таблицы*/
            joinColumns = @JoinColumn(name = "order_id"),    /*сюда запишет наш id*/
            inverseJoinColumns = @JoinColumn(name = "dish_id")  /*сюда запишет id связи*/

    )
    private List<Dish> dishes;   /*у этого листа будет одинаковый  id ордера*/
    @Column(name = "table_number")
    private int tableNumber;
    @Column(name = "order_date")
    private Date orderDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getWaiter() {
        return waiter;
    }

    public void setWaiter(Employee waiter) {
        this.waiter = waiter;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", waiter=" + waiter +
                ", dishes=" + dishes +
                ", tableNumber=" + tableNumber +
                ", orderDate=" + orderDate +
                '}';
    }
}
