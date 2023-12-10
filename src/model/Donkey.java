package model;

import java.time.LocalDate;

class Donkey extends PackAnimal{
    Donkey(String name, LocalDate dateOfBirth){
        super(name, dateOfBirth);
        this.setKind("Осёл");
    }
}
