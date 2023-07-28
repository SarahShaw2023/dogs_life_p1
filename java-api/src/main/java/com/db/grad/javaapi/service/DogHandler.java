package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

import java.util.List;

public class DogHandler {
    private DogsRepository itsDogsRepo;
    public DogHandler(DogsRepository itsDogsRepo) {
        this.itsDogsRepo = itsDogsRepo;
    }

    public void addDog(Dog theDog) {
        itsDogsRepo.save(theDog);
    }

    public long getNoOfDogs() {
        return itsDogsRepo.count();
    }

    public Dog getDogByName(String name) {

        List<Dog> dogs = itsDogsRepo.findByName(new Dog(name));

        return dogs.size() == 1 ? dogs.get(0) : null;
    }

    public Dog getDogById(int id) {
        return itsDogsRepo.findById(id);

    }

    public long updateDogDetails(Dog dog) {
        return itsDogsRepo.save(dog);
    }
}
