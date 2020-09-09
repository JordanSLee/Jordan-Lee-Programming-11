package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    /** Fields **/
    public TextField nameInput;
    public TextField ageInput;
    public TextField passionInput;
    public TextField personalityInput;
    public TextField traitsInput;
    public Label outputName;
    public Label outputAge;
    public Label outputPassion;
    public Label outputPersonality;
    public Label outputTraits;
    public Button buttonRemoveFriend;
    public ListView<Friends> viewFriends = new ListView<>();

    /** Method to build friend **/
    public void buildFriend(ActionEvent actionEvent) {
        String name = nameInput.getText();
        int age = Integer.parseInt(ageInput.getText());
        String passion = passionInput.getText();
        String  personality = personalityInput.getText();
        String traits = traitsInput.getText();

        Friends newFriends = new Friends(name,age,passion,personality,traits);
        viewFriends.getItems().add(newFriends);

        nameInput.clear();
        ageInput.clear();
        passionInput.clear();
        personalityInput.clear();
        traitsInput.clear();
    }

    /** Method to Remove a Friend **/
    public void removeFriend(ActionEvent actionEvent) {
        Friends newFriends;
        newFriends = viewFriends.getSelectionModel().getSelectedItem();
        viewFriends.getItems().remove(newFriends);

        outputName.setText("");
        outputAge.setText("");
        outputPassion.setText("");
        outputPersonality.setText("");
        outputTraits.setText("");
        buttonRemoveFriend.setDisable(true);
        buttonRemoveFriend.setVisible(false);
    }

    /** Method That Displays a Selected Friend **/
    public void displayFriend(MouseEvent mouseEvent) {
        Friends newFriends;
        newFriends = viewFriends.getSelectionModel().getSelectedItem();
        outputName.setText(newFriends.getName());
        outputAge.setText(Integer.toString(newFriends.getAge()));
        outputPassion.setText(newFriends.getPassion());
        outputPersonality.setText(newFriends.getPersonality());
        outputTraits.setText(newFriends.getTraits());
        buttonRemoveFriend.setDisable(false);
        buttonRemoveFriend.setVisible(true);
    }
}
