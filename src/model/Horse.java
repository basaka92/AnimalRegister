package model;

import java.time.LocalDate;

class Horse extends PackAnimal{
    Horse(String name, LocalDate dateOfBirth){
        super(name, dateOfBirth);
        this.setKind("Лошадь");
    }
}
