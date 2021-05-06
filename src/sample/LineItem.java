/** LineItem is an object which stores the amount and type of pizza to be ordered. **/

package sample;
public class LineItem{


    private static final long serialVersionUID = 5723581601036010490L;
    private Pizza pOrder = null;
    private int numberPizza = 1;


    // requires: Pizza object
    // modifies: default pizza
    // effects: Constructor creates a default order of 1 pizza
    public LineItem(Pizza p) throws IllegalPizza{
        if(p == null){
            throw new IllegalPizza("null object submitted");
        }
        pOrder = p;
    }

    // requires: Pizza object
    // modifies: a default order
    // effects: Constructor creates an order of a certain amount and type of pizza
    public LineItem(int n, Pizza p) throws IllegalPizza{
        if (p == null){
            throw new IllegalPizza("null object submitted");
        }
        if (n<1){
            throw new IllegalPizza("Buy at least one pizza");
        }
        if (n>100){
            throw new IllegalPizza("You purchased too many pizza's");
        }
        pOrder = p;
        numberPizza = n;
    }

    // requires: Pizza object
    // effect: returns the type of pizza in an order
    public Pizza getPizza(){
        return pOrder;
    }

    // requires: int
    // effect: returns the number of pizzas in an order
    public int getNumber(){
        return numberPizza;
    }

    // requires: int
    // modifies: this
    // effect: sets number of pizzas to be ordered
    public void setNumber(int n) throws IllegalPizza{
        if(n>0 && n<101){
            numberPizza = n;
        }
        else{
            throw new IllegalPizza("incorrect number of pizzas");
        }
    }

    // requires: double
    // effect: returns total cost of an order
    public double getCost(){
        return pOrder.getCost()*numberPizza;
    }

    // requires: int
    // modifies: this
    // effect: returns correct string representation of an order
    @Override
    public String toString(){
        String s;
        if (numberPizza < 10){
            s =" "+numberPizza+" "+pOrder.toString();
        }
        else{
            s = numberPizza+" "+pOrder.toString();
        }
        return s;
    }
}
