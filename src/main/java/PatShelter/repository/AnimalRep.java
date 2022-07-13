package PatShelter.repository;

import PatShelter.model.Animal;
import PatShelter.model.Gender;
import PatShelter.model.Species;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalRep {

    private List<Animal> animalList = new ArrayList<>();

    public AnimalRep() {
        int index;
        index = animalList.size();
        animalList.add(new Animal(index, Species.CAT, Gender.MALE, 1, "Dopi"));
        index = animalList.size();
        animalList.add(new Animal(index, Species.CAT, Gender.FEMALE, 2, "Manya"));
        index = animalList.size();
        animalList.add(new Animal(index, Species.CAT, Gender.MALE, 3, "Dublin"));
        index = animalList.size();
        animalList.add(new Animal(index, Species.CAT, Gender.FEMALE, 4, "Misty"));
        index = animalList.size();
        animalList.add(new Animal(index, Species.DOG, Gender.MALE, 5, "Bobik"));
        index = animalList.size();
        animalList.add(new Animal(index, Species.DOG, Gender.FEMALE, 6, "Marta"));
        index = animalList.size();
        animalList.add(new Animal(index, Species.DOG, Gender.MALE, 7, "Poko"));
        index = animalList.size();
        animalList.add(new Animal(index, Species.DOG, Gender.FEMALE, 8, "Milka"));
    }

    public Animal getAnimal(int id) {
        try {
            return animalList.get(id);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Animal addAnimal(@NotNull Animal animal) {
        int index = getAnimal(animalList.size() - 1).getAnimalID() + 1;
        animal.setAnimalID(index);
        animalList.add(animal);
        return getAnimal(animalList.size() - 1);
    }

    public Animal updateAnimal(@NotNull Animal animal) {
        int index = animal.getAnimalID();
        try {
            return animalList.set(index, animal);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Animal removeAnimal(int id) {
        try {
            return animalList.remove(id);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}