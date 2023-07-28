package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        d1.setName("Spot");
        d.addDog(d1);

        // act
        Dog dog = d.getDogByName("Spot");

        // assert
        assertEquals(d1, dog);
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

    /*
    //getDogById (2 cases)
    @Test
    public void () {

    }

    //updateDogDetails (1 case)
    @Test
    public void () {

    }

    //removeDog (1 case)
    @Test
    public void () {

    }
    */
}
