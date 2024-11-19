package opgave07;

import opgave07.models.Pizzeria;
import opgave07.models.factories.ChicagoPizzaFactory;
import opgave07.models.factories.NYPizzaFactory;
import opgave07.models.factories.SimplePizzaFactory;

public class Opgave07 {
    public static void main(String[] args) {
        NYPizzaFactory nyPizzaFactory = new NYPizzaFactory();
        ChicagoPizzaFactory chicagoPizzaFactory = new ChicagoPizzaFactory();
        Pizzeria nyPizzeria = new Pizzeria(nyPizzaFactory);
        Pizzeria chicagoPizzeria = new Pizzeria(chicagoPizzaFactory);
        nyPizzeria.orderPizza("cheese");
        chicagoPizzeria.orderPizza("cheese");
    }

}
