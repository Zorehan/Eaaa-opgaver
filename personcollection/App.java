package personcollection;

public class App {
    public static void main(String[] args) {
        PersonCollectionI col = new PersonCollectionLink();
        System.out.println(col.isEmpty());
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
        System.out.println(col.isEmpty());

    }
}
