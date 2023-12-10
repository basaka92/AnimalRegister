package view;

import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class View {
    private Presenter presenter = new Presenter(this);
    private Scanner sc = new Scanner(System.in);
    private boolean working = true;
    public void runConsoleApp(){
        while(this.working){
            System.out.println("Введите команду (введите help для отображения списка доступных команд меню):");
            String command = sc.next();
            System.out.println();
            switch (command) {
                case "view" -> this.viewAnimals();
                case "add" -> this.addAnimal();
                case "delete" -> this.deleteAnimal();
                case "c_view" -> this.viewCommands();
                case "c_add" -> this.addCommand();
                case "help" -> this.getHelp();
                case "exit" -> this.exit();
                default -> System.out.println("Такой команды нет!\n");
            }
        }
    }
    private void getHelp(){
        System.out.println("""
                Список доступных команд меню:
                view - просмотр реестра животных
                add - добавление нового животного в реестр
                delete - удаление животного из реестра
                с_view - просмотр команд, которым обучено животное
                с_add - обучить животное новой команде
                help - просмотр списка команд меню
                exit - завершение работы программы
                """);
    }
    private void viewAnimals(){
        this.loadRegister();
        if (this.presenter.viewAnimals().isEmpty()){
            System.out.println("Реестр пуст! Добавьте в него животных. \n");
        }else{
            System.out.println(this.presenter.viewAnimals());
        }
        this.saveRegister();
    }
    private void addAnimal(){
        this.loadRegister();
        int type = 1;
        boolean check = false;
        while (!check) {
            System.out.println("Введите цифру из списка, соответствующую типу животного, которое хотите добавить.\n1)Собака\n2)Кот\n3)Хомяк\n4)Осёл\n5)Верблюд\n6)Лошадь\n");
            if (sc.hasNextInt()){
                type = sc.nextInt();
                if (type<1 || type>6){
                    System.out.println("\nТакой цифры нет в списке! Попробуйте ввод снова.\n");
                }else{
                    check = true;
                }
            }else{
                System.out.println("\nВведены данные некорректного типа! Попробуйте ввод снова.\n");
                sc.next();
            }
        }
        String name = "";
        System.out.println("Введите имя животного:");
        while (name.isEmpty()){
                name = sc.nextLine();
        }
        System.out.println();
        String date = "";
        check = false;
        while (!check){
            System.out.println("Введите дату рождения (в формате дд/мм/гггг): ");
            date = sc.nextLine();
            if (presenter.parseDate(date) == null){
                System.out.println("\nОшибка в ведённых данных! Попробуйте ввод снова.\n");

            }else{
                check = true;
            }
        }
        LocalDate dateOfBirth = presenter.parseDate(date);
        System.out.println();
        this.presenter.addAnimal(name, dateOfBirth, type);
        this.saveRegister();
    }
    private void deleteAnimal(){
        this.loadRegister();
        if (this.presenter.viewAnimals().isEmpty()){
            System.out.println("Реестр пуст! Добавьте в него животных. \n");
        }else{
            int id;
            boolean check = false;
            while (!check)
            {
                System.out.println("Введите ID животного (целое положительное число), которое хотите удалить из реестра:");
                if (sc.hasNextInt()){
                    id = sc.nextInt();
                    if(!this.presenter.checkAnimalId(id)){
                        System.out.println("\nЖивотного с таким ID нет в реестре! Попробуйте ввод снова.\n");
                    }else{
                        this.presenter.deleteAnimal(id);
                        this.saveRegister();
                        check = true;
                    }
                }else{
                    System.out.println("\nВведены данные некорректного типа! Попробуйте ввод снова.\n");
                    sc.next();
                }
            }
            System.out.println();
            this.saveRegister();
        }
        }
    private void viewCommands(){
        this.loadRegister();
        if (this.presenter.viewAnimals().isEmpty()){
            System.out.println("Реестр пуст! Добавьте в него животных. \n");
        }else {
            boolean check = false;
            int id = -1;
            while (!check)
            {
                System.out.println("Введите ID животного, команды которого хотите увидеть:");
                if (sc.hasNextInt()){
                    id = sc.nextInt();
                    if(!this.presenter.checkAnimalId(id)){
                        System.out.println("\nЖивотного с таким ID нет в реестре! Попробуйте ввод снова.\n");
                    }else{
                        check = true;
                    }
                }else{
                    System.out.println("\nВведены данные некорректного типа! Попробуйте ввод снова.\n");
                    sc.next();
                }
            }
            System.out.println();
            if (presenter.getCommands(id) != null){
                for (int i = 1; i<= presenter.getCommands(id).size(); i++){
                    System.out.println(i + ")" + presenter.getCommands(id).get(i-1));
                }

            }else{
                System.out.println("Данное животное ещё не обучено ни одной команде.");
            }
            System.out.println();
        }
        this.saveRegister();
    }
    private void addCommand(){
        this.loadRegister();
        if (this.presenter.viewAnimals().isEmpty()){
            System.out.println("Реестр пуст! Добавьте в него животных. \n");
        }else{
            boolean check = false;
            int id = -1;
            while (!check)
            {
                System.out.println("Введите ID животного, которое хотите обучить новой команде:");
                if (sc.hasNextInt()){
                    id = sc.nextInt();
                    if(!this.presenter.checkAnimalId(id)){
                        System.out.println("\nЖивотного с таким ID нет в реестре! Попробуйте ввод снова.\n");
                    }else{
                        check = true;
                    }
                }else{
                    System.out.println("\nВведены данные некорректного типа! Попробуйте ввод снова.\n");
                    sc.next();
                }
            }
            System.out.println();
            System.out.println("Введите команду, которой хотите обучить животное:");
            String command = "";
            while (command.isEmpty()){
                command = sc.nextLine();
            }
            presenter.addCommand(id, command);
            System.out.println();
            this.saveRegister();
        }
    }
    private void loadRegister(){
        if (!this.presenter.loadRegister()){
            System.out.println("Ошибка чтения файла рееестра!\n");
        }
    }
    private void saveRegister()  {
        if (!this.presenter.saveRegister()){
            System.out.println("Ошибка сохранения файла рееестра!\n");
        }
    }
    private void exit(){
        this.working = false;
    }
}
