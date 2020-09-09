package sample;

    /** Fields **/
public class Friends {
    private String name;
    private String passion;
    private String personality;
    private String traits;
    private int age;

    /** Constructor **/
    Friends(String name, int age, String passion, String personality, String traits){
        this.name = name;
        this.age = age;
        this.passion = passion;
        this.personality = personality;
        this.traits = traits;
    }


    /** Getters and Setters **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /** To String Method **/
    public String toString(){
        return name;
    }
}
