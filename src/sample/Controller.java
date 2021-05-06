package sample;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.*;
import java.util.ArrayList;

public class Controller {

    //GUI Declarations/Fields
    @FXML
    public RadioButton rbSmall;
    @FXML
    public ToggleGroup Size;
    @FXML
    public RadioButton rbMedium;
    @FXML
    public RadioButton rbLarge;
    @FXML
    public RadioButton rbCheese;
    @FXML
    public ToggleGroup Type;
    @FXML
    public RadioButton rbPepperoni;
    @FXML
    public RadioButton rbVeggie;
    @FXML
    public TextField orderNumber;
    @FXML
    public TextField costTextP;
    @FXML
    public TextField costTextT;
    @FXML
    public Button saveOrder;
    @FXML
    public TextField orderText;
    @FXML
    public TextField totalCost;
    @FXML
    public Button saveAll;
    @FXML
    public ListView viewPizza;
    @FXML
    public ListView availableLists;

    //pizza variables
    private int type = 1;
    private String pSize = "Small";
    private int numOfPizza = 1;
    private static ArrayList<LineItem> orders = new ArrayList<>();

    // requires: int
    // modifies: this
    // effects: sets the pizza type
    private void setType(int t)
    {
        type = t;
    }

    // requires: string
    // modifies: this
    // effects: sets the size of the Pizza
    private void setSize(String s)
    {
        pSize = s;
    }

    // requires: int
    // modiefies: this
    // effects sets the number of Pizza
    private void setNumberOfPizza(int n)
    {
        numOfPizza = n;
    }

    // requires: Pizza object
    // modifies: this
    // effects: displays pizza
    private void displayPizza(){
        try{
            Pizza check = new Pizza(pSize,type);
            costTextT.setText("$"+String.format("%.2f", (check.getCost())*numOfPizza));
            costTextP.setText("$"+String.format("%.2f", (check.getCost())));
        }
        catch (IllegalPizza ip){
            System.out.println(ip.getMessage());
        }
    }

    // requires: double
    // modifies: this
    // effects: calculates total cost
    private double totalCost(){
        double totalCost = 0;
            for (LineItem order : orders) {
                totalCost += order.getCost();
            }
        return totalCost;
    }

    // requires: orders
    // modifies: orders.dat
    // effects: saves orders in orders.dat
    private static void writeOrders(){
        String outputFile = "Orders.dat";
        try (ObjectOutputStream binFileOut = new ObjectOutputStream(new FileOutputStream(outputFile))){
            binFileOut.writeObject(orders);
        }
        catch (FileNotFoundException err){
            System.out.println(err.getMessage());
        }
        catch (IOException err){
            System.out.println(err.getMessage());
        }
    }

    // requires: selected radiobutton (string)
    // modifies: displayPizza()
    // effects: sets the type of pizza
    @FXML
    void initialize(){
        Type.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) ->{
            if(((RadioButton)new_toggle).getId().equals("rbCheese")){
                setType(1);
                displayPizza();
            }
            if(((RadioButton)new_toggle).getId().equals("rbPepperoni")){
                setType(2);
                displayPizza();
            }
            if(((RadioButton)new_toggle).getId().equals("rbVeggie")){
                setType(3);
                displayPizza();
            }
        });

        // requires: selected radiobutton (string)
        // modifies: displayPizza()
        // effects: sets the size of pizza
    Size.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) ->{
        if(((RadioButton)new_toggle).getId().equals("rbSmall")){
            setSize("Small");
            displayPizza();
        }
        if(((RadioButton)new_toggle).getId().equals("rbMedium")){
            setSize("Medium");
            displayPizza();
        }
        if(((RadioButton)new_toggle).getId().equals("rbLarge")){
            setSize("Large");
            displayPizza();
        }
    });

        // requires: int
        // modifies: displayPizza()
        // effects: sets the number of pizzas ordered
    orderNumber.textProperty().addListener((observableValue, oldText, newText) ->{
        if (newText != null && !newText.isEmpty()){
            try{
                int aVal = Integer.parseInt(newText);
                if (aVal>100 || aVal<1){
                    ((StringProperty)observableValue).setValue(oldText);
                }
                else{
                    setNumberOfPizza(aVal);
                    displayPizza();
                }
            }
            catch (NumberFormatException e){
                ((StringProperty)observableValue).setValue(oldText);
            }
        }
    });

        // requires: Pizza object info
        // modifies: this
        // effects: adds orders
    saveOrder.setOnAction(event -> {
        try{
            Pizza p = new Pizza(pSize,type);
            LineItem i = new LineItem(numOfPizza,p);
            orders.add(i);
            orderText.setText(orderText.getText()+i.toString()+"\n");
            totalCost.setText("$"+String.format("%.2f", totalCost()));
        }
        catch (IllegalPizza ip){
            System.out.println(ip.getMessage());
        }
    });

        // requires: Pizza
        // modifies: saves orders to orders.dat
        // effects: orders.dat
    saveAll.setOnAction(event ->{
        writeOrders();
    });
    }


    // requires: string newList
    // modifies: file pizzaLists.txt
    // effects: check if name of new list is a duplicate of a pre-existing one
    public boolean compareLists(String orderText) throws IOException{
        FileReader fr = new FileReader("pizzaLists.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;

        while ((line = br.readLine()) != null){
            if(line.equals(orderText)){
                System.out.println("List name is duplicate");
                return true;
            }
        }
        return false;
    }

    // requires: orders
    // modifies: pizzas.txt
    // effects: writes an order to pizzas.txt
    public void saveToFile(ActionEvent actionEvent) throws IOException {
                for(LineItem l : orders) {
            l.getPizza().writeToFile(l.getNumber());
        }
    }

    // requires: string
    // modifies: listview (availablelists)
    // effects: gets and displays pizza order on the listview
    public void loadAll(ActionEvent actionEvent) throws IOException {
        System.out.println("Loading list");
        orders.getClass();

        System.out.println("Updating new load");
        FileReader fr = new FileReader("pizzas.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null){
            System.out.println("line is: " + line);
            availableLists.getItems().add(line);
        }
        br.close();
    }
}
