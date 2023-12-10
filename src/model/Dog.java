package model;

import java.time.LocalDate;

class Dog extends Pet{
    Dog(String name, LocalDate dateOfBirth){
        super(name, dateOfBirth);
        this.setKind("Собака");
    }
}
