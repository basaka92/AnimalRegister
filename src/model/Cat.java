package model;

import java.time.LocalDate;

class Cat extends Pet{
    Cat(String name, LocalDate dateOfBirth){
        super(name, dateOfBirth);
        this.setKind("Кошка");
    }
}
