package ua.goit.java.hibernate.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu {


    @Id
    @Column(name = "name")
    private String name;

    /*1. fetch-“join” = Disable the lazy loading, always load all the collections and entities.
      2. fetch-“select” (default) = Lazy load all the collections and entities.
      3. batch-size=”N” = Fetching up to ‘N’ collections or entities, *Not record*.
      4. fetch-“subselect” = Group its collection into a sub select statement.*/
    @OneToMany
    @Fetch(FetchMode.JOIN)
    @JoinTable(
            name = "menu_list",
            joinColumns = @JoinColumn(name = "menu"),
            inverseJoinColumns = @JoinColumn (name = "dish_id")
    )
    private List<Dish> dishes;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        StringBuilder dishesList = new StringBuilder();

        for (Dish dish: dishes) {
            dishesList.append(dish.getName() + ", ");
        }

        return "Menu{" +
                "name='" + name + '\'' +
                ", dishes=" + "\"" + dishesList + "\"" +
                '}';
    }
}
