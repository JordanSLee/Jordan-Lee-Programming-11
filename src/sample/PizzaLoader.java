package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PizzaLoader {
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Pizza> pizzaList = new ArrayList<>();

    // requires: String
    // modifies: this corresponding file with name
    // effects: reads element in selected file, then returns arraylist of each element place
    public static ArrayList<Pizza> viewPizza(String fileName) throws IOException {
        pizzaList.clear();
        System.out.println("Creating Pizza");
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String pizzaString = "";

        while ((line = br.readLine()) != null) {
            if (!line.equals(";")) {
                pizzaString += line;
                System.out.println(line);
            } else {
                parsePizza(pizzaString);
                pizzaString = "";
                System.out.println("Special line: " + line);
            }
        }
        return pizzaList;
    }

    // requires: string element
    // modifies: this
    // effects: separates name, age, passion, personality, traits
    public static void parsePizza(String element) {
        int startIndex = 0;
        int endIndex = 0;
        int locationCounter = 0;

        System.out.println("Element is: " + element);

        ArrayList<Integer> location = new ArrayList<>();

        ArrayList<String> conversionList = new ArrayList<>();

        for (int i = 0; i < element.length(); i++) {
            if (element.substring(i, i + 1).equals(",")) {
                System.out.println("Adding: " + i);
                location.add(i);
            }
        }
        for (int i = 0; i < element.length(); i++) {
            if (i == location.get(0)) {
                conversionList.add(element.substring(0, i));
            }
            if (locationCounter > 3) {
                System.out.println("Breaking from loop");
                break;
            }
            if (element.substring(i, i + 1).equals(",")) {
                System.out.println("Location counter: " + locationCounter + " getting location: " + location.get(locationCounter));
                System.out.println("Found comma");

                startIndex = location.get(locationCounter);
                endIndex = location.get(locationCounter + 1);

                conversionList.add(element.substring(startIndex + 1, endIndex));

                locationCounter++;
            }
        }
        for (String n : conversionList) {
            System.out.println("Printing conversion list");
            System.out.println(n);
        }
        pizzaList.add(new Pizza(conversionList.get(0),Integer.parseInt(conversionList.get(1)),Integer.parseInt(conversionList.get(3))));
    }
}
