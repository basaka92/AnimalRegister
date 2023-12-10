package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Service {
    private Register register;
    private FileHandler fileHandler = new FileHandler();

    public Service(){
        register = new Register();
    }
    public String viewAnimals(){
        return this.register.viewAnimals();
    }
    public void addAnimal(String name, LocalDate dateOfBirth, int type){
        this.register.addAnimal(name, dateOfBirth, type);
    }
    public void deleteAnimal(int id){
        this.register.deleteAnimal(id);
    }
    public void addCommand(int id, String command){
        register.addCommand(id, command);
    }
    public ArrayList<String> getCommands(int id){
      return register.getCommands(id);
    }
    public boolean loadRegister(){
        try{
            this.register = (Register) this.fileHandler.read("register.txt");
        }
        catch(FileNotFoundException | ClassNotFoundException | StreamCorruptedException e){
            this.saveRegister();
            this.loadRegister();
            return true;
        }
        catch (IOException e){
            return false;
        }
        return true;
    }
    public boolean saveRegister(){
        try{
            this.fileHandler.save(this.register, "register.txt");
        }
        catch (IOException e){
           return false;
        }
        return true;
    }
    public boolean checkAnimalId(int id){
        return register.checkAnimalId(id);
    }
    public LocalDate parseDate(String date){
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            return LocalDate.parse(date, formatter);
        }
        catch (DateTimeParseException e){
            return null;
        }
    }
}
