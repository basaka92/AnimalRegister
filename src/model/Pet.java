package model;

import java.time.LocalDate;

abstract class Pet extends Animal{
    Pet(String name, LocalDate dateOfBirth){
        super(name, dateOfBirth);
    }
}
