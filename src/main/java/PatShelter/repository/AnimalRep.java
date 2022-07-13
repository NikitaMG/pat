package PatShelter.repository;

import PatShelter.model.Animal;
import PatShelter.model.Gender;
import PatShelter.model.Species;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRep extends CrudRepository<Animal, Integer> {

    @Modifying
    @Query("INSERT INTO public.animal(species, animal_gender, animal_age, animal_name) " +
            "VALUES (:1::species, :2::gender, :3, :4)")
     void addAnimal(
            @Param("1") Species species,
            @Param("2") Gender gender,
            @Param("3") int age,
            @Param("4") String name
    );

    @Query("SELECT * FROM animal WHERE species = :1::species AND animal_gender = :2::gender " +
            "AND animal_age = :3 AND animal_name ILIKE :4")
    Animal animalIsExists(
            @Param("1") Species species,
            @Param("2") Gender gender,
            @Param("3") int age,
            @Param("4") String name
    );


    @Modifying
    @Query("UPDATE animal SET species = :1::species, animal_gender = :2::gender, animal_age = :3, " +
            "animal_name = :4 WHERE animal_id = :5")
    void updateAnimal(
            @Param("1") Species species,
            @Param("2") Gender gender,
            @Param("3") int age,
            @Param("4") String name,
            @Param("5") Integer animalID
    );
}