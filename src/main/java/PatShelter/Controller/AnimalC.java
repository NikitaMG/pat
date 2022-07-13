package PatShelter.Controller;

import PatShelter.model.Animal;
import PatShelter.service.AnimalS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
@RestController()
@RequestMapping("/animal")
public class AnimalC {
    private final AnimalS animalService;
    @Autowired
    public AnimalC(AnimalS animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable int id) {
        Animal animal = animalService.getAnimal(id).orElse(null);
        if (animal == null) {
            throw new ResponseStatusException (HttpStatus.NOT_FOUND);
        }
        return animal;
    }
    @PostMapping
    public Animal updateAnimal(@RequestBody Animal animal){
        Animal animal1 = animalService.updateAnimal(animal);
        if (animal1 == null) {
            throw new ResponseStatusException (HttpStatus.BAD_REQUEST);
        }
        return animal1;
    }

    @PutMapping
    public Animal addAnimal(@RequestBody Animal animal){
        animal = animalService.addAnimal(animal);
        if (animal == null) {
            throw new ResponseStatusException (HttpStatus.BAD_REQUEST);
        }
        return animal;
    }

    @DeleteMapping("/{id}")
    public Animal removeAnimal(@PathVariable int id) {
        Animal animal = animalService.removeAnimal(id);
        if (animal == null) {
            throw new ResponseStatusException (HttpStatus.NOT_FOUND);
        }
        return animal;
    }

}
