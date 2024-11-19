package opgave07.models;

import opgave07.models.factories.SimplePizzaFactory;
import opgave07.models.pizza.Pizza;

public class Pizzeria {
    SimplePizzaFactory pizzaFactory;

    public Pizzeria(SimplePizzaFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = pizzaFactory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
