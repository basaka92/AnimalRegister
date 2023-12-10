package presenter;

import model.Service;
import view.View;

import java.time.LocalDate;
import java.util.ArrayList;

public class Presenter {
    private Service service = new Service();
    private View view;
    public Presenter(View view){
       this.view = view;
    }
    public String viewAnimals(){
        return this.service.viewAnimals();
    }
    public void addAnimal(String name, LocalDate dateOfBirth, int type){
        this.service.addAnimal(name, dateOfBirth, type);
    }
    public void deleteAnimal(int id){
        this.service.deleteAnimal(id);
    }
    public void addCommand(int id, String command){
        this.service.addCommand(id, command);
    }
    public ArrayList<String> getCommands(int id){
        return this.service.getCommands(id);
    }
    public boolean loadRegister() {
        return this.service.loadRegister();
    }
    public boolean saveRegister(){
        return this.service.saveRegister();
    }
    public boolean checkAnimalId(int id){
        return service.checkAnimalId(id);
    }
    public LocalDate parseDate(String date){
        return service.parseDate(date);
    }
}
