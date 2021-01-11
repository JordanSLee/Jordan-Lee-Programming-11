package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.ArrayList;

public class Controller {
    /** Fields **/
    public TextField listName;
    public ListView availableLists;
    public Button buttonLoadLists;
    public Button buttonRemoveList;
    public Button buttonViewList;
    public Label errorLabel;
    public TextField nameInput;
    public TextField ageInput;
    public TextField passionInput;
    public TextField personalityInput;
    public TextField traitsInput;
    public Button buildFriendButton;
    public Button saveToFileButton;
    public Label saveToFileLabel;
    public ListView<Friends> viewFriends = new ListView<>();
    public Label outputName;
    public Label outputAge;
    public Label outputPassion;
    public Label outputPersonality;
    public Label outputTraits;
    public Button buttonRemoveFriend;

    // build friend method
    public void buildFriend(ActionEvent actionEvent) {
        viewFriends.getItems().clear();
        String name = nameInput.getText();
        int age = Integer.parseInt(ageInput.getText());
        String passion = passionInput.getText();
        String personality = personalityInput.getText();
        String traits = traitsInput.getText();

        Friends newFriends = new Friends (name,age,passion,personality,traits);
        viewFriends.getItems().add(newFriends);

        nameInput.clear();
        ageInput.clear();
        passionInput.clear();
        personalityInput.clear();
        traitsInput.clear();

        saveToFileButton.setVisible(true);
        buildFriendButton.setVisible(false);
        saveToFileLabel.setText("Please select a list and press save");
        saveToFileButton.setDisable(true);

        nameInput.setDisable(true);
        ageInput.setDisable(true);
        passionInput.setDisable(true);
        personalityInput.setDisable(true);
        traitsInput.setDisable(true);
    }

    // display friend method
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

    // remove friend method
    public void removeFriend(ActionEvent actionEvent) throws IOException {
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

        ObservableList<Friends> friendLists = viewFriends.getItems();
        int size = friendLists.size();
        Object listName = availableLists.getSelectionModel().getSelectedItem();

        // clear file
        FileWriter fileWrite = new FileWriter(listName+".txt",false);
        BufferedWriter bufferedWrite = new BufferedWriter(fileWrite);
        bufferedWrite.write("");
        bufferedWrite.close();

        System.out.println("saving to file: " + listName);
        for(Friends i : friendLists){
            System.out.println("Writing: " + i);
            i.writeToFile(listName + ".txt");
        }
    }

    public void makeList(ActionEvent actionEvent) throws IOException {
        viewFriends.getItems().clear();

        String newItem = (listName.getText());
        if(newItem.equals("")){
            System.out.println("Input new list is nothing");
            errorLabel.setText("ERROR: Input is nothing");
        }
        else if(compareLists(newItem)){
            System.out.println("Compare list item true");
            errorLabel.setText("ERROR: list already in set");
        }
        else{
            System.out.println("Compare list false");
            availableLists.getItems().add(newItem);
            listName.clear();
            FileWriter newFile = new FileWriter(newItem +".txt");
            BufferedWriter bw = new BufferedWriter(newFile);
            bw.close();

            System.out.println("Writing to friendLists.txt");
            FileWriter fwFriends = new FileWriter("friendLists.txt", true);
            BufferedWriter bwFriends = new BufferedWriter(fwFriends);
            bwFriends.write((String) newItem + "\r");
            bwFriends.close();
            errorLabel.setText("");
        }
    }

    public void saveToFile(ActionEvent actionEvent) throws IOException{
        saveToFileLabel.setText("");
        System.out.println("Running saving to file");
        ObservableList<Friends> friendLists = viewFriends.getItems();
        int size = friendLists.size();
        Object listName = availableLists.getSelectionModel().getSelectedItem();
        System.out.println("Saving to file: "+ listName);

        for(Friends i : friendLists){
            System.out.println("Writing: " + i);
            i.writeToFile(listName + ".txt");
        }
        viewFriends.getItems().clear();

        saveToFileButton.setVisible(false);
        buildFriendButton.setDisable(false);
        buildFriendButton.setVisible(true);
        nameInput.setDisable(false);
        ageInput.setDisable(false);
        passionInput.setDisable(false);
        personalityInput.setDisable(false);
        traitsInput.setDisable(false);
    }

    public void loadList(ActionEvent actionEvent) throws IOException {
        System.out.println("Loading list");
        viewFriends.getItems().clear();

        System.out.println("Updating new load");
        FileReader fr = new FileReader("friendLists.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null){
            System.out.println("line is: " + line);
            availableLists.getItems().add(line);
        }
        br.close();
        buttonLoadLists.setVisible(false);
        buttonViewList.setVisible(true);
        buttonViewList.setDisable(true);
    }

    public void selectedFriendList(MouseEvent mouseEvent) {
        buttonViewList.setDisable(false);
        buttonRemoveList.setDisable(false);
        saveToFileButton.setDisable(false);
    }

    public void removeList(ActionEvent actionEvent) throws IOException {
        File inputFile = new File ("friendLists.txt");
        File tempFile = new File ("tempFile.txt");

        Object locate = availableLists.getSelectionModel().getSelectedItem();
        availableLists.getItems().remove(locate);
        System.out.println("Removing this: " + locate);

        FileReader fr = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(fr);
        String line;

        // writes a temp. file to copy later
        FileWriter fileWrite = new FileWriter(tempFile);
        BufferedWriter bufferedWrite = new BufferedWriter(fileWrite);

        while((line = br.readLine()) != null){
            System.out.println("line located: " + line + " located: " + locate);
            // when line is located, it can be removed from list
            if(line.equals(locate)){
                System.out.println("line located: " + line + " located: " + locate);
                System.out.println("line is: " + line);
                availableLists.getItems().remove(line);

                // removes file from folder
                File file = new File (line + ".txt");
                System.out.println(file.delete());
            }
            else{
                // else write the file back into the list
                System.out.println("Wrote: " + line);
                bufferedWrite.write(line + "\r");
            }
        }
        br.close();
        bufferedWrite.close();
        copyFile();

        outputName.setText("");
        outputAge.setText("");
        outputPassion.setText("");
        outputPersonality.setText("");
        outputTraits.setText("");
        buttonRemoveFriend.setDisable(true);
        buttonRemoveFriend.setVisible(false);
    }

    // requires: string newList
    // modifies: file friendLists.txt
    // effects: check if name of new list is a duplicate of a pre-existing one
    public boolean compareLists(String listName) throws IOException{
        FileReader fr = new FileReader("friendLists.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;

        while ((line = br.readLine()) != null){
            if(line.equals(listName)){
                System.out.println("List name is duplicate");
                return true;
            }
        }
        return false;
    }

    // modifies: friendLists + tempFiles
    // effects: reads tempFile.txt and copies info to friendLists.txt
    public void copyFile() throws IOException{
        FileWriter fwrite = new FileWriter("friendLists.txt");
        BufferedWriter bwrite = new BufferedWriter(fwrite);

        FileReader frtemp = new FileReader("tempFile.txt");
        BufferedReader brtemp = new BufferedReader(frtemp);

        String line;

        while ((line = brtemp.readLine()) != null) {
            bwrite.write(line + "\r");
        }
        bwrite.close();
    }

    public void viewList(ActionEvent actionEvent) throws IOException {
        viewFriends.getItems().clear();
        outputName.setText("");
        outputAge.setText("");
        outputPassion.setText("");
        outputPersonality.setText("");
        outputTraits.setText("");
        buttonRemoveFriend.setDisable(true);
        buttonRemoveFriend.setVisible(false);

        System.out.println("viewing friends running");
        System.out.println("searching through: " + availableLists.getSelectionModel().getSelectedItem() + ".txt");
        ArrayList<Friends> friends = FriendLoader.viewFriends(availableLists.getSelectionModel().getSelectedItem() + ".txt");
        viewFriends.getItems().clear();

        for (Friends f : friends){
            System.out.println(f);
            viewFriends.getItems().add(f);
        }
    }
}


