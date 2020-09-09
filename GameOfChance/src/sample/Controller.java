package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    public Label rollOne;
    public Label rollTwo;
    public Label points;
    public Button buttonMore;
    public Button buttonLess;
    int pts = 10;

    public void guessMore(ActionEvent actionEvent) {
        // fields
        int diceOne;
        int diceTwo;
        // creates random number from 1-10 per roll
        diceOne = (int) (Math.random() * 10);
        diceTwo = (int) (Math.random() * 10);
        // changes labels to a number created from the each roll
        rollOne.setText(String.valueOf(diceOne));
        rollTwo.setText(String.valueOf(diceTwo));
        // if first roll > second roll subtract a point, then show the updated amt of points
        if(diceOne>diceTwo){
            pts --;
            points.setText(String.valueOf(pts));
        }
        // if first roll < second roll add a point, then show the updated amt of points
        else if(diceOne<diceTwo){
            pts++;
            points.setText(String.valueOf(pts));
        }
        // if the rolls are tied, subtract a point, then show the updated amt of points
        else if(diceOne==diceTwo) {
            pts--;
            points.setText(String.valueOf(pts));
        }
        // if something else happens, show and error
        else{
            points.setText("ERROR1 TRY AGAIN");
        }
    }

    public void guessLess(ActionEvent actionEvent) {
        // fields
        int diceOne;
        int diceTwo;
        // creates random number from 1-10 per roll
        diceOne = (int) (Math.random() * 10);
        diceTwo = (int) (Math.random() * 10);
        // changes labels to a number created from the each roll
        rollOne.setText(String.valueOf(diceOne));
        rollTwo.setText(String.valueOf(diceTwo));
        // if first roll > second roll subtract a point, then show the updated amt of points
        if(diceOne>diceTwo){
            pts++;
            points.setText(String.valueOf(pts));
        }
        // if first roll < second roll add a point, then show the updated amt of points
        else if(diceOne<diceTwo){
            pts--;
            points.setText(String.valueOf(pts));
        }
        // if the rolls are tied, subtract a point, then show the updated amt of points
        else if(diceOne==diceTwo) {
            pts--;
            points.setText(String.valueOf(pts));
        }
        // if something else happens, show and error
        else{
            points.setText("ERROR1 TRY AGAIN");
        }
    }
}
