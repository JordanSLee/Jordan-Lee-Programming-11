package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FriendLoader {
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Friends> friends = new ArrayList<>();

    // requires: string
    // modifies: this, corresponding file with name
    // effecrs: reads elements in selected file, then returns the Arraylist of each element place
    public static ArrayList viewFriends(String fileName) throws IOException{
        friends.clear();
        System.out.println("Creating Friend");
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String friendsString = "";

        while ((line=br.readLine()) != null){
            if(!line.equals(";")){
                friendsString +=line;
                System.out.println(line);
            }
            else{
                parseFriend(friendsString);
                friendsString = "";
                System.out.println("Special line: " + line);
            }
        }
        return friends;
    }
    // requires: string element
    // modifies: this
    // effects: separates name, age, passion, personality, traits
    public static void parseFriend(String element){
        int startIndex = 0;
        int endIndex = 0;
        int locationCounter = 0;

        System.out.println("Element is: " + element);
        // stores location of comma
        ArrayList<Integer> location = new ArrayList<>();
        // stores the name, age, passion, personality and traits
        ArrayList<String> conversionList = new ArrayList<>();

        for(int i = 0; i < element.length(); i++) {
            if (element.substring(i,i+1).equals(",")) {
                System.out.println("Adding: " + i);
                location.add(i);
            }
        }
        for(int i = 0; i < element.length(); i++) {
            if (i == location.get(0)) {
                conversionList.add(element.substring(0,i));
            }
            if (locationCounter > 3) {
                System.out.println("Breaking from loop");
                break;
            }
            if (element.substring(i,i+1).equals(",")) {
                System.out.println("location counter: " + locationCounter + " getting location: " + location.get(locationCounter));
                System.out.println("Found comma");

                startIndex = location.get(locationCounter);
                endIndex = location.get(locationCounter + 1);

                conversionList.add(element.substring(startIndex + 1, endIndex));

                locationCounter++;
            }
        }
        for(String n: conversionList){
            System.out.println("Printing conversion list");
            System.out.println(n);
        }
            friends.add(new Friends(conversionList.get(0),Integer.parseInt(conversionList.get(1)),conversionList.get(2),conversionList.get(3),conversionList.get(4)));
    }
}
