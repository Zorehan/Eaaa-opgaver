package personcollection;

import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        PersonCollectionI col = new PersonCollectionLink();
        PersonCollectionI col2 = new PersonCollection();
        System.out.println(col.isEmpty());
        col2.add(new Person("Kasper"));
        col2.add(new Person("Jesper"));
        col2.add(new Person("Jens"));
        col2.add(new Person("Martin"));
        col2.add(new Person("Mikkel"));
        col.add(new Person("Kasper"));
        col.add(new Person("Jesper"));
        col.add(new Person("Jens"));
        col.add(new Person("Martin"));
        col.add(new Person("Mikkel"));
        System.out.println(col.isEmpty());
        System.out.println(col.toString());
        System.out.println(col.size());



        col.add(0,new Person("Thomas"));
        System.out.println(col.toString());
        System.out.println(col.size());
        col.remove(1);
        System.out.println(col.toString());
        System.out.println(col.size());

        col.add(5,new Person("Tom"));
        System.out.println(col.toString());
        System.out.println(col.size());

        col.remove(5);
        System.out.println(col.toString());
        System.out.println(col.size());

        for (int i = 0; i< col.size(); i++){
            System.out.println(col.get(i));
        }
        System.out.println(col.isEmpty() + "\n -------------------------------------ITERATOR 1 START----------------");

        Iterator<Person> iterator = ((PersonCollectionLink) col).iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            System.out.println(person);
            if (person.toString().equals("Jens")) {
                iterator.remove();
            }
        }

        System.out.println("EFTER ITERATOR 1 ER BRUGT");
        System.out.println(col.toString());
        System.out.println(col.size());

        System.out.println(col.isEmpty() + "\n --------------------ITERATOR 2 START------------------");

        Iterator<Person> iterator2 = ((PersonCollection) col2).iterator2();
        col2.add(new Person("Gerg"));
        while (iterator2.hasNext()) {
            Person person = iterator2.next();
            System.out.println(person);
            if (person.toString().equals("Mikkel")) {
                iterator2.remove();
            }
        }

        System.out.println("Efter iterator 2 er brugt ");
        System.out.println(col2.toString());


    }
}
