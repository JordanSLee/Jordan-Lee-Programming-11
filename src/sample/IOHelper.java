/** This class is an input, output utility class **/

package sample;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IOHelper {

    private static Scanner screenInput = new Scanner(System.in);

    // requires: string
    // modifies: this
    // effects: prompts user for a string, returns user input
    public static String getString(String Prompt){
        System.out.println(Prompt);
        return screenInput.nextLine();
    }

    // requires: int
    // modifies: this
    // effect: continuously prompts user for a valid integer, returns said integer
    public static int getInt(int i, String Prompt, int m){
        System.out.println(Prompt);
        int orderNumber = -100;
        try{
            orderNumber = screenInput.nextInt();
            screenInput.nextLine();
        }
        catch (InputMismatchException e){
            String a = screenInput.nextLine();
            System.out.println(a+" is not an integer!");
        }
        while(orderNumber>m||orderNumber<i){
            try{
                System.out.println("ERROR Try again");
                orderNumber = screenInput.nextInt();
                screenInput.nextLine();
            }
            catch (InputMismatchException e){
                String a = screenInput.nextLine();
                System.out.println(a+" is not an integer!");
            }
        }
        return orderNumber;
    }

    // requires: int
    // modifies: this
    // effect: continuosly prompts user for valid integer and returns said integer
    public static int getInt(int i, String Prompt){
        int orderSize = 0;
        System.out.println(Prompt);
        try{
            orderSize = screenInput.nextInt();
            screenInput.nextLine();
        }
        catch (InputMismatchException e){
            String a = screenInput.nextLine();
            System.out.println(a+" is not an integer!");
        }
        while(orderSize<i||orderSize>100){
            try{
                System.out.println("ERROR Try again");
                orderSize = screenInput.nextInt();
                screenInput.nextLine();
            }
            catch (InputMismatchException e){
                String a = screenInput.nextLine();
                System.out.println(a+" is not an integer!");
            }
        }
        return orderSize;
    }
}
