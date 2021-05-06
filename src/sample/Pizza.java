/** Pizza.java is an object which stores info (size and type) on a pizza to be ordered. **/

package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Pizza implements java.io.Serializable {
    //fields
    private static final long serialID = 5789335549554632519L;
    private String size;
    private int type = 1;
    private double cost = 0;

    /** Constructor **/
    public Pizza(String size, int type, double cost){
        this.size = size;
        this.type = type;
        this.cost = cost;
    }

    /** Getters and Setters **/
    public static long getSerialID() {
        return serialID;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    // Constructor creates a default pizza with a specific size and uses pizzaCost() method to determine cost of total pizza
    public Pizza(String s) throws IllegalPizza {
        if (s == null) {
            throw new IllegalPizza("null answer submitted");
        }
        size = s;
        type = 1;
        if (!s.equalsIgnoreCase("small") && !s.equalsIgnoreCase("medium") && !s.equalsIgnoreCase("large")) {
            throw new IllegalPizza("Non Applicable Size" + s);
        }
        cost = pizzaCost(s, 1);
    }

    // Constructor creates a pizza with a desired size and type.
    // Utilizes pizzaCost() method to calculate totoal cost of pizza
    public Pizza(String s, int t) throws IllegalPizza{
        if (s == null){
            throw new IllegalPizza("null object submitted");
        }
        if(!s.equalsIgnoreCase("small")&&!s.equalsIgnoreCase("medium")&&!s.equalsIgnoreCase("large")||t<1||t>3){
            throw new IllegalPizza("ERROR WRONG PIZZA SIZE: "+ s);
        }
        size = s;
        type = t;
        cost = pizzaCost(s, t);
    }

    // requires: double
    // modifies: this
    // effects: retrieves cost of a pizza
    public double getCost() {
        return cost;
    }

    // requires: integers
    // modifies: this
    // effects Overrides the toString() method and gives the string representation of a pizza
    public String toString() {
        String t;
        String pizzaString = "";
        t = numberString(type);

        if (type == 0) {
            pizzaString = size.toLowerCase() + " pizza, " + t + " type, Cost: $" + String.format("%.2f", cost);
        }
        if (type != 0) {
            pizzaString = size.toLowerCase() + " pizza, " + t + " type, Cost: $" + String.format("%.2f", cost);
        }
        return pizzaString;
    }

    // requires: all attributes of Pizza
    // modifies: this
    // effect: compares pizza objects, checking for equality
    @Override
    public boolean equals(Object p){
        if(p instanceof Pizza){
            if (((Pizza)p).size.equalsIgnoreCase(size)&&((Pizza)p).cost == this.cost && ((Pizza)p).type == this.type){
                return true;
            }
        }
        return false;
    }

    // requires: Pizza object
    // modifies: this
    // effect: creates a deep copy of a pizza
    @Override
    public Pizza clone() {
        Pizza pCopy = null;
        try {
            pCopy = new Pizza(this.size,this.type);
        } catch (IllegalPizza i) {
            System.out.println("ERROR2");
        }
        return pCopy;
    }

    // requires: int
    // modifies: this
    // effect: returns desired string representation of a number
    private String numberString(int i) {
        String s = "";
        if (i == 1) {
            s = " cheese ";
        }
        if (i == 2) {
            s = " pepperoni ";
        }
        if (i == 3) {
            s = " veggie ";
        }
        return s;
    }

    // requires: String, int
    // modifies: this
    // effect: calculates total cost of pizza
    private double pizzaCost(String s, int t) {
        if (s.equalsIgnoreCase("small")) {
            cost = 8.00 + 1.50 * (t - 1);
        }
        if (s.equalsIgnoreCase("medium")) {
            cost = 10.00 + 1.50 * (t - 1);
        }
        if (s.equalsIgnoreCase("large")) {
            cost = 12.00 + 1.50 * (t - 1);
        }
        return cost;
    }
        // requires: Pizza order
        // modiefies: .txt file
        // effects: writes to a text file
        public void writeToFile(int numberPizza) throws IOException{
        FileWriter fw = new FileWriter("pizzas.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(size+",\r");
        bw.write(numberString(type)+",\r");
        bw.write("Per pizza: $"+Double.toString(cost)+",\r");
        bw.write("Total pizzas: "+numberPizza+"\r");
        bw.close();
    }
}

