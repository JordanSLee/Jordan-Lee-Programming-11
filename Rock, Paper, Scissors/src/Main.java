import java.awt.datatransfer.StringSelection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //My stuff//
        String userInput;// stores the users input (r, p or s)
        Boolean properAnswer;// determines the input the code accepts
        int dice;// is the randomly generated number
        String computerInput;// stores the input the computer generates. (0, 1 or 2)
        String results;// stores the outcome of both inputs (Draw!, You Win!, or You Lose!)
        String userWord;// stores the user input as a word rather than a letter.

        System.out.println("Choose r (rock), p (paper), or s (scissors)?");// prints the options that can be chosen

        Scanner scan = new Scanner(System.in);// allows the user to input an answer.
        userInput = scan.next();// scans users input storing it under "userInput".
        properAnswer = (userInput.equals("r")||userInput.equals("p")||userInput.equals("s"));// tells code to only recognize "r, s or p".
        if(!properAnswer){// if code is not "r, s or p", proceed to next step
            System.out.println("Invalid selection please play again.");// prints the message when the above criteria is fullfilled

        }
        else{
            dice = (int) (Math.random()*3);/*generates a random number between 0-0.99 and then multiplies it by three
            , but it is read as 0, 1 or 2 as it can't read decimal places*/
            if (dice == 0){// if dice equals 0, follow the next step
                computerInput = "rock";// 0 is now stored as "rock"
            }
            else if (dice == 1){// if dice equals 1, follow the next step
                computerInput = "paper";// 1 is now stored as "paper"
            }
            else if (dice == 2){// if dice equals 2, follow the next step
                computerInput = "scissors";// 2 is now stored as "scissors"
            }
            else{// if the dice produces an number that is not 0, 1 or 2, proceed to the next step
                computerInput = "ERROR1";// if the random number is something else, it is stored as "ERROR1", notifying the user that an error has occured.
            }
            if (userInput.equals("r")&&computerInput.equals("rock")){// if user input is "r" and computer input is "rock", follow the next step.
                results = "Draw!";// assign the result as "Draw!"
            }
            else if (userInput.equals("r")&&computerInput.equals("scissors")){// if user input is "r" and computer input is "scissors", follow the next step.
                results = "You Win!";// assign the result as "You Win!"
            }
            else if (userInput.equals("r")&&computerInput.equals("paper")){// if user input is "r" and computer input is "paper", follow the next step.
                results = "You Lose!";// assign the result as "You Lose!"
            }
            else if (userInput.equals("p")&&computerInput.equals("paper")){// if user input is "p" and computer input is "paper", follow the next step.
                results = "Draw!";// assign the result as "Draw!"
            }
            else if (userInput.equals("p")&&computerInput.equals("rock")){// if user input is "p" and computer input is "rock", follow the next step.
                results = "You Win!";// assign the result as "You Win!"
            }
            else if (userInput.equals("p")&&computerInput.equals("scissors")){// if user input is "p" and computer input is "scissors", follow the next step.
                results = "You Lose!";// assign the result as "You Lose!"
            }
            else if (userInput.equals("s")&&computerInput.equals("scissors")){// if user input is "s" and computer input is "scissors", follow the next step.
                results = "Draw!";// assign the result as "Draw!"
            }
            else if (userInput.equals("s")&&computerInput.equals("rock")){// if user input is "s" and computer input is "rock", follow the next step.
                results = "You Lose!";// assign the result as "You Lose!"
            }
            else if (userInput.equals("s")&&computerInput.equals("paper")){// if user input is "s" and computer input is "paper", follow the next step.
                results = "You Win!";// assign the result as "You Win!"
            }
            else{// tells code that if any other inputs are made, follow the next action.
                results = "ERROR2";// states the result as "Error2", notifying the user that an error has occurred.
            }
            System.out.println(results);// prints the results

            if (userInput.equals("r")){// if user's input is "r", follow the next action.
                userWord = "rock";// assign "userWord" to "rock".
            }
            else if (userInput.equals("p")){// if user's input is "p", follow the next action.
                userWord = "paper";// assign "userWord" to "paper".
            }
            else if (userInput.equals("s")){// if user's input is "s", follow the next action.
                userWord = "scissors";// assign "userWord" to "scissors".
            }
            else{ // if users input is not "s, p or r", follow the next action.
                userWord = "ERROR3";// stores any other outcomes as "ERROR3"
            }
            System.out.println("Computer Choice: " + computerInput + "\tPlayer Choice: " + userWord);// shows computers and user's inputs, depending on what "computerInput" and "userWord" are.
        }


    }
}
