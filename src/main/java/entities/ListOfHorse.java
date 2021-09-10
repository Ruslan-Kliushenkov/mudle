package entities;

import java.util.ArrayList;
import java.util.List;

public class ListOfHorse {

    private static List<Horse> listOfHorse = new ArrayList<>();

    public static void addToList(String name){
        Horse horse = new Horse(name);
        listOfHorse.add(horse);
    }

    public static void clearTheList(){
        listOfHorse.clear();
    }

    public static List<Horse> getListOfHorse() {
        return listOfHorse;
    }
}
