package model;

import java.time.LocalDate;

class Hamster extends Pet{
    Hamster(String name, LocalDate dateOfBirth){
        super(name, dateOfBirth);
        this.setKind("Хомяк");
    }
}
