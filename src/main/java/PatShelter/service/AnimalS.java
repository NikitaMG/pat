package PatShelter.service;

import PatShelter.model.Animal;
import PatShelter.repository.AnimalRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnimalS {

    private final AnimalRep animalRepository;

    @Autowired
    public AnimalS(AnimalRep animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Optional<Animal> getAnimal(Integer id) {
        return animalRepository.findById(id);
    }

    public Animal addAnimal(Animal animal) {
        Animal duplicate = animalRepository.animalIsExists(
                animal.getSpecies(),
                animal.getAnimalGender(),
                animal.getAnimalAge(),
                animal.getAnimalName()
        );
        if (duplicate == null) {
            animalRepository.addAnimal(
                    animal.getSpecies(),
                    animal.getAnimalGender(),
                    animal.getAnimalAge(),
                    animal.getAnimalName()
            );
            return animalRepository.animalIsExists(
                    animal.getSpecies(),
                    animal.getAnimalGender(),
                    animal.getAnimalAge(),
                    animal.getAnimalName()
            );
        }
        return null;
    }

    public Animal updateAnimal(Animal animal) {
        Animal duplicate = animalRepository.animalIsExists(
                animal.getSpecies(),
                animal.getAnimalGender(),
                animal.getAnimalAge(),
                animal.getAnimalName()
        );
        if (duplicate == null) {
            animalRepository.updateAnimal(
                    animal.getSpecies(),
                    animal.getAnimalGender(),
                    animal.getAnimalAge(),
                    animal.getAnimalName(),
                    animal.getAnimalID());
            return animalRepository.findById(animal.getAnimalID()).orElse(null);
        }
        return null;
    }

    public Animal removeAnimal(Integer id) {
        Animal animal = animalRepository.findById(id).orElse(null);
        if (animal != null) {
            animalRepository.deleteById(id);
        }
        return animal;
    }
}
