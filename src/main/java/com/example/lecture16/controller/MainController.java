package com.example.lecture16.controller;

import com.example.lecture16.model.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class MainController {
    private static final List<Animal> animals = new ArrayList<>();

    @PostMapping("/create-animal")
    public Animal CreateAnimal(@RequestBody Animal animal) {
        animals.add(animal);
        return animal;

    }

    @DeleteMapping("/delete-animal/{animalIndex}")
    public void DeleteAnimal(@PathVariable("animalIndex") Integer index) {
        if (index < animals.size() && index > -1) {
            animals.remove((int)index);
        }
    }

    @PutMapping("update-animal/{animalIndex}")
    public Animal UpdateAnimal(@PathVariable("animalIndex") Integer index, @RequestBody Animal animal) {
        if (index<animals.size() && index>-1) {
            Animal OldAnimal = animals.get(index);
            OldAnimal.setName(animal.getName());
            OldAnimal.setAge(animal.getAge());
            OldAnimal.setType(animal.getType());
        }
        return animal;
    }

    @GetMapping("/get-animal/{animalIndex}")
    public Animal GetAnimal (@PathVariable("animalIndex") Integer animalIndex){
        return animals.get(animalIndex);
    }

    @GetMapping("/get-animal/")
    public List<Animal> getAnimal(){
        return animals;
    }






}
