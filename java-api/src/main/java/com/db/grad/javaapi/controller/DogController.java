package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@RestController
public class DogController {
    private DogService dogsService;

    @Autowired
    public DogController(DogService ds)
    {
        dogsService = ds;
    }

    @GetMapping("/status")
    public String statusCheck() {
    return "Hello world";
    }

    //return all the dogs in the database
    @GetMapping("/dogs")
    public List<Dog> getAllDogs() {
        return dogsService.getAllDogs();
    }

    //return the number of dogs in the database
    @GetMapping("/numDogs")
    public int getNumDogs() {
        return dogsService.getAllDogs().size();
    }

    //    Does not work??
    @GetMapping("/dogs/name/{name}")
    public ResponseEntity <Dog> getDogByName(@PathVariable(value = "name") String name) {
//        return dogsService.getDogByName(name);
        Dog d =  dogsService.getDogByName(name);
        return ResponseEntity.ok().body(d);
    }

//    Does not work??
    @GetMapping("/dogs/id/{id}")
    public Dog getDogById(@PathVariable(value = "id") long id) {
        return dogsService.getDogById(id);
    }
    //    @PostMapping("/dogs")
    //    @PutMapping("/dogs/{id}")
    //    DeleteMapping("/dogs/{id}")
}
