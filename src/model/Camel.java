package model;

import java.time.LocalDate;

class Camel extends PackAnimal{

    Camel(String name, LocalDate dateOfBirth){
        super(name, dateOfBirth);
        this.setKind("Верблюд");
    }
}
