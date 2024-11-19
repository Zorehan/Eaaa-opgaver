public class UseClass {

private static final Counter counter = Counter.getInstance();
private static final PersonAdmin personAdmin = PersonAdmin.getInstance();

    public static void main(String[] args)
    {
        System.out.println(counter.getValue());
        counter.count();
        System.out.println(counter.getValue());
        counter.times2();
        System.out.println(counter.getValue());
        counter.zero();
        System.out.println(counter.getValue());


        Person person1 = new Person("Bob", 15, "bobsmail@bob.com");
        personAdmin.addPerson(person1);
        System.out.println(personAdmin.getPersonSet().toString());
        personAdmin.deletePerson(person1);
        System.out.println(personAdmin.getPersonSet().toString());
    }
}
