package PatShelter.service;

import PatShelter.model.Person;
import PatShelter.repository.PersonRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonS {

    private final PersonRep personRepository;

    @Autowired
    public PersonS(PersonRep personRepository) {
        this.personRepository = personRepository;
    }

    public Person getPerson(int id) {
        return personRepository.getPerson(id);
    }

    public Person addPerson(Person person) {
        return personRepository.addPerson(person);
    }

    public Person updatePerson(Person person) {
        return personRepository.updatePerson(person);
    }

    public Person removePerson(int id) {
        return personRepository.removePerson(id);
    }
}
