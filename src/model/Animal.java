package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

abstract class Animal implements Serializable {
    private String kind;
    private String name;
    private LocalDate dateOfBirth;
    private ArrayList<String> commands;

    Animal(String name, LocalDate dateOfBirth){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
    void setKind(String kind){
        this.kind = kind;
    }
    String getKind(){
        return kind;
    }
    String getName(){
        return this.name;
    }
    LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }
    ArrayList<String> getCommands(){
        if (this.commands == null){
            return null;
        }
        return this.commands;
    }
    void addCommand(String command){
        if (this.commands == null){
            commands = new ArrayList<>();
        }
        this.commands.add(command);
    }
}
