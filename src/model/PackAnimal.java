package model;

import java.time.LocalDate;

abstract class PackAnimal extends Animal{
    PackAnimal(String name, LocalDate dateOfBirth){
        super(name, dateOfBirth);
    }
}
