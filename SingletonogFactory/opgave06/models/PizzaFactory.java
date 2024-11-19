package opgave06.models;

import opgave06.models.pizzas.CheesePizza;
import opgave06.models.pizzas.GreekPizza;
import opgave06.models.pizzas.PepperoniPizza;
import opgave06.models.pizzas.Pizza;

public class PizzaFactory {

    public PizzaFactory()
    {

    }

    public Pizza createPizza(String type)
    {
        Pizza pizza;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if(type.equals("greek")) {
            pizza = new GreekPizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else {
            return null;
        }
        return null;
    }
}
