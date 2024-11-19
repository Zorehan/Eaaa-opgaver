package opgave07.models.factories;

import opgave07.models.pizza.*;

public class ChicagoPizzaFactory extends SimplePizzaFactory {

    public ChicagoPizzaFactory()
    {

    }
    @Override
    public Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new ChicagoStylePepperoniPizza();
        } else if(type.equals("veggie"))
        {
            return new ChicagoStyleVeggiePizza();
        }
        else {
            return null;
        }
    }
}
