import java.util.HashSet;
import java.util.Set;

public class PersonAdmin {

    private static PersonAdmin instance;
    private Set<Person> personSet = new HashSet<>();

    private PersonAdmin()
    {

    }

    public static PersonAdmin getInstance()
    {
        if(instance == null)
        {
            instance = new PersonAdmin();
        }
        return instance;
    }

    public void addPerson(Person person)
    {
        personSet.add(person);
    }

    public Set<Person> getPersonSet()
    {
        return personSet;
    }

    public void deletePerson(Person person)
    {
        personSet.remove(person);
    }
}
