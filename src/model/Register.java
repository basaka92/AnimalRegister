package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Register implements Serializable {
    private TreeMap<Integer, Animal> animals = new TreeMap<>();
    private ArrayList<Integer> deletedAnimalId = new ArrayList<>();
    void addAnimal(String name, LocalDate dateOfBirth, int type){
        switch (type) {
            case 1 -> {
                if (deletedAnimalId.isEmpty()){
                    this.animals.put(lastId(), new Dog(name, dateOfBirth));
                }else{
                    this.animals.put(deletedAnimalId.get(0), new Dog(name, dateOfBirth));
                    deletedAnimalId.remove(0);
                }
            }
            case 2 -> {
                if (deletedAnimalId.isEmpty()){
                    this.animals.put(lastId(), new Cat(name, dateOfBirth));
                }else{
                    this.animals.put(deletedAnimalId.get(0), new Cat(name, dateOfBirth));
                    deletedAnimalId.remove(0);
                }
            }
            case 3 -> {
                if (deletedAnimalId.isEmpty()){
                    this.animals.put(lastId(),new Hamster(name, dateOfBirth));
                }else{
                    this.animals.put(deletedAnimalId.get(0),new Hamster(name, dateOfBirth));
                    deletedAnimalId.remove(0);
                }
            }
            case 4 -> {
                if (deletedAnimalId.isEmpty()){
                    this.animals.put(lastId(),new Donkey(name, dateOfBirth));
                }else{
                    this.animals.put(deletedAnimalId.get(0),new Donkey(name, dateOfBirth));
                    deletedAnimalId.remove(0);
                }
            }
            case 5 -> {
                if (deletedAnimalId.isEmpty()){
                    this.animals.put(lastId(),new Camel(name, dateOfBirth));
                }else{
                    this.animals.put(deletedAnimalId.get(0),new Camel(name, dateOfBirth));
                    deletedAnimalId.remove(0);
                }
            }
            case 6 -> {
                if (deletedAnimalId.isEmpty()){
                    this.animals.put(lastId(),new Horse(name, dateOfBirth));
                }else{
                    this.animals.put(deletedAnimalId.get(0),new Horse(name, dateOfBirth));
                    deletedAnimalId.remove(0);
                }
            }
        }
    }
    void deleteAnimal(int id){
        this.animals.remove(id);
        deletedAnimalId.add(id);
        Collections.sort(deletedAnimalId);
    }
    private int lastId(){
        if (this.animals.isEmpty()){
            return 1;
        }
        return this.animals.lastKey() + 1;
    }
    private Animal getAnimalById(int id){
        return animals.get(id);
    }
    ArrayList<String> getCommands(int id){
      return getAnimalById(id).getCommands();
    }
    String viewAnimals(){
        Iterator<Map.Entry<Integer, Animal>> iterator = this.animals.entrySet().iterator();
        StringBuilder stringBuilder = new StringBuilder();
        boolean check = true;
        while(iterator.hasNext()){
            Map.Entry<Integer, Animal> tempAnimals = iterator.next();
            if (check){
                stringBuilder.append("Список животных:\n");
                check = false;
            }
            stringBuilder.append("""
                    |
                    |
                    ID:\s""").append(tempAnimals.getKey()).append("\n").append("Вид: ").append(tempAnimals.getValue().getKind()).append("\n").append("Имя: ").append(tempAnimals.getValue().getName()).append("\n").append("Дата рождения: ").append(tempAnimals.getValue().getDateOfBirth()).append("\n");
        }
        return  stringBuilder.toString();
    }
    void addCommand(int id, String command){
        this.getAnimalById(id).addCommand(command);
    }
    boolean checkAnimalId(int id){
        return animals.containsKey(id);
    }

}
