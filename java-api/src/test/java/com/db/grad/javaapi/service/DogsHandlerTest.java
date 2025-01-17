package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DogsHandlerTest {
    private DogsRepository itsDogsRepo = new DogsRepositoryStub();

    @BeforeEach
    public void makeSureRepoIsEmpty() {
        itsDogsRepo.deleteAll();
    }
    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one() {
        //Arrange
        DogHandler d = new DogHandler(itsDogsRepo);

        Dog theDog = new Dog();
        theDog.setName("Bruno");
        d.addDog(theDog);

        int expectedResult = 1;

        //Act
        long actualResult = d.getNoOfDogs();

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void add_several_dogs_return_number_of_dogs_match_number_added() {

        // arrange
        DogHandler d = new DogHandler(itsDogsRepo);

        Dog d1 = new Dog();
        d1.setName("Bruno");
        d.addDog(d1);

        Dog d2 = new Dog();
        d2.setName("Fido");
        d.addDog(d2);

        Dog d3 = new Dog();
        d3.setName("Fido");
        d.addDog(d3);

        int expectedResult = 3;

        //Act
        long actualResult = d.getNoOfDogs();

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    //getDogByName (3 cases)
    @Test
    public void get_dog_name_dog_does_not_exist() {

        // arrange
        DogHandler d = new DogHandler(itsDogsRepo);

        Dog d1 = new Dog();
        d1.setName("Bruno");
        d.addDog(d1);

        // act
        Dog dog = d.getDogByName("Spot");

        // assert
        assertEquals(null, dog);
    }

    @Test
    public void get_dog_name_one_dog_exists() {

        // arrange
        DogHandler d = new DogHandler(itsDogsRepo);

        Dog d1 = new Dog();
        d1.setName("Fido");
        d.addDog(d1);

        Dog d2 = new Dog();
        d2.setName("Spot");
        d.addDog(d2);

        Dog d3 = new Dog();
        d3.setName("Beethoven");
        d.addDog(d3);

        // act
        Dog dog = d.getDogByName("Spot");

        // assert
        assertEquals(d2, dog);
    }

    @Test
    public void get_dog_name_multiple_dogs_exist() {

        // arrange
        DogHandler d = new DogHandler(itsDogsRepo);

        Dog spot1 = new Dog();
        spot1.setName("Spot");
        d.addDog(spot1);

        Dog spot2 = new Dog();
        spot2.setName("Spot");
        d.addDog(spot2);

        Dog spot3 = new Dog();
        spot3.setName("Spot");
        d.addDog(spot3);

        // act
        Dog dog = d.getDogByName("Spot");

        // assert
        assertEquals(null, dog);
    }


    //getDogById (2 cases)
    @Test
    public void check_if_dog_null_get_dog_id() {
        // arrange
        DogHandler d = new DogHandler(itsDogsRepo);

        Dog spot1 = new Dog();
        spot1.setId(5);
        d.addDog(spot1);

        // act
        Dog dog = d.getDogById(6);

        // assert
        assertEquals(null, dog);

    }
    @Test
    public void check_if_dog_exist_get_id() {
        // arrange
        DogHandler d = new DogHandler(itsDogsRepo);

        Dog spot1 = new Dog();
        d.addDog(spot1);

        // act
        Dog dog = d.getDogById(1);

        // assert
        assertEquals(spot1, dog);

    }

    @Test
    public void update_dog_details() {

        // arrange

        DogHandler d = new DogHandler(itsDogsRepo);

        //dog is dog1 (added to make sure it remains unchanged)
        Dog dog = new Dog();
        dog.setName("Spot");
        d.addDog(dog);

        //importantDog is dog2 (the only one that should have name updated)
        Dog importantDog = new Dog();
        importantDog.setName("Fido");
        d.addDog(importantDog);

        long expected = importantDog.getId();

        //"dog" is dog3 (added to make sure it remains unchanged)
        dog = new Dog();
        dog.setName("Chelsea");
        d.addDog(dog);

        // act
        //dog2 should only be changed, as indicated by the return value of the changed dog
        importantDog.setName("Charlie");
        long actual = d.updateDogDetails(importantDog);

        // assert
        //Ensure target dog's id (dog2) and changed dog's id matches
        assertEquals(expected, actual);
        //TODO: Maybe also verify dog2's name also actually updated
    }

    //removeDog (1 case)
    @Test
    public void remove_dog_where_dog_does_not_exist() {

        DogHandler d = new DogHandler(itsDogsRepo);

        assertFalse(d.removeDog(1));
    }
    @Test
    public void remove_dog_where_dog_does_exists() {

        DogHandler d = new DogHandler(itsDogsRepo);
        d.addDog(new Dog());

        assertTrue(d.removeDog(1));
        assertFalse(d.removeDog(1));
    }
}
