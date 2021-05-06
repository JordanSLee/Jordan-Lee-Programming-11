package sample;

public class IllegalPizza extends Exception{

    private static final long serialID = -5935590159508055457L;

    public IllegalPizza(){
        super("ERROR1");
    }

    public IllegalPizza(String message){
        super(message);
    }
}
