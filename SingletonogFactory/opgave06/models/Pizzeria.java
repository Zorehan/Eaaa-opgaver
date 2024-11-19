package opgave06.models;

import opgave06.models.pizzas.CheesePizza;
import opgave06.models.pizzas.GreekPizza;
import opgave06.models.pizzas.PepperoniPizza;
import opgave06.models.pizzas.Pizza;

public class Pizzeria {

    PizzaFactory pizzaFactory = new PizzaFactory();

    public Pizza orderPizza(String type) {
        Pizza pizza = pizzaFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
