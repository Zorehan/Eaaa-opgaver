package opgave07.models.factories;

import opgave07.models.pizza.NYStyleCheesePizza;
import opgave07.models.pizza.NYStylePepperoniPizza;
import opgave07.models.pizza.NYStyleVeggiePizza;
import opgave07.models.pizza.Pizza;

public class NYPizzaFactory extends SimplePizzaFactory{

    public NYPizzaFactory()
    {}

    @Override
    public Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new NYStylePepperoniPizza();
        } else if(type.equals("veggie"))
        {
            return new NYStyleVeggiePizza();
        }
        else {
            return null;
        }
    }
}
