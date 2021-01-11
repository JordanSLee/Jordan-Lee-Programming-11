package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

    /** Fields **/
public class Friends {
    private String name;
    private int age;
    private  String passion;
    private String personality;
    private String traits;

    /** Constructor **/
    Friends(String name, int age, String passion, String personality, String traits){
        this.name = name;
        this.age = age;
        this.passion = passion;
        this.personality = personality;
        this.traits = traits;
    }

        // requires: string file (name of file being written to)
        // modifies: this, file
        // effects: writes name, age, passion, personality, traits to indicated file
    public void writeToFile(String fileName) throws IOException{
        System.out.println("Writing: " + fileName);
        FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name + ",\r");
        bw.write(Integer.toString(age) + ",\r");
        bw.write(passion + ",\r");

        bw.write(personality + ",\r");
        bw.write(traits + ",\r");
        bw.write(";\r");

        bw.close();
    }
    /** Getters and Setters **/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassion() {
        return passion;
    }

    public void setPassion(String passion) {
        this.passion = passion;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getTraits() {
        return traits;
    }

    public void setTraits(String traits) {
        this.traits = traits;
    }

    /** toString method **/
    public String toString(){
        return name;
    }
}
