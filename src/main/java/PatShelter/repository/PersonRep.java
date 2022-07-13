package PatShelter.repository;

import PatShelter.model.Gender;
import PatShelter.model.Person;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRep {

    private final List<Person> personList = new ArrayList<>();

    public PersonRep() {
        int index;
        index = 0;
        personList.add(new Person(index, "Eugeniy", "Smit", 32, Gender.MALE));
        index = personList.size();
        personList.add(new Person(index, "Bob", "Bobenko", 12, Gender.MALE));
        index = personList.size();
        personList.add(new Person(index, "Kate", "Elwins", 18, Gender.FEMALE));
        index = personList.size();
        personList.add(new Person(index, "Ann", "Price", 19, Gender.FEMALE));
    }

    public Person getPerson(int id) {
        try {
            return personList.get(id);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Person addPerson(@NotNull Person person) {
        int index = getPerson(personList.size() - 1).getPersonID() + 1;
        person.setPersonID(index);
        personList.add(person);
        return getPerson(personList.size() - 1);
    }

    public Person updatePerson(@NotNull Person person) {
        int index = person.getPersonID();
        try {
            return personList.set(index, person);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Person removePerson(int id) {
        try {
            return personList.remove(id);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}