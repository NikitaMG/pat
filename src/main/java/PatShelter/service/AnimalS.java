package PatShelter.service;

import PatShelter.model.Animal;
import PatShelter.repository.AnimalRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalS {

    private final AnimalRep animalRepository;

    @Autowired
    public AnimalS(AnimalRep animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal getAnimal(int id) {
        return animalRepository.getAnimal(id);
    }

    public Animal addAnimal(Animal animal) {
        return animalRepository.addAnimal(animal);
    }

    public Animal updateAnimal(Animal animal) {
        return animalRepository.updateAnimal(animal);
    }

    public Animal removeAnimal(int id) {
        return animalRepository.removeAnimal(id);
    }
}
