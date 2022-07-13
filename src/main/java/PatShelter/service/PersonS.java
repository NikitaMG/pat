package PatShelter.service;

import PatShelter.model.Person;
import PatShelter.repository.PersonRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonS {

    private final PersonRep personRepository;

    @Autowired
    public PersonS(PersonRep personRepository) {
        this.personRepository = personRepository;
    }

    public Optional<Person> getPerson(Integer id) {
        return personRepository.findById(id);
    }

    public Person addPerson(Person person) {
        Person duplicate = personRepository.personIsExists(
                person.getPersonName(),
                person.getPersonSurname(),
                person.getPersonAge(),
                person.getGender()
        );
        if (duplicate == null) {
            personRepository.addPerson(
                    person.getPersonName(),
                    person.getPersonSurname(),
                    person.getPersonAge(),
                    person.getGender()
            );
            return personRepository.personIsExists(
                    person.getPersonName(),
                    person.getPersonSurname(),
                    person.getPersonAge(),
                    person.getGender()
            );
        }
        return null;
    }

    public Person updatePerson(Person person) {
        Person duplicate = personRepository.personIsExists(
                person.getPersonName(),
                person.getPersonSurname(),
                person.getPersonAge(),
                person.getGender()
        );
        if (duplicate == null) {
            personRepository.updatePerson(
                    person.getPersonName(),
                    person.getPersonSurname(),
                    person.getPersonAge(),
                    person.getGender(),
                    person.getPersonID()
            );
            return personRepository.findById(person.getPersonID()).orElse(null);
        }
        return null;
    }

    public Person removePerson(int id) {
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            personRepository.deleteById(id);
        }
        return person;
    }
}
