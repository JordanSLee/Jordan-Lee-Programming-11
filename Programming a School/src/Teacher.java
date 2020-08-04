public class Teacher { // the "Teacher" class helps make new teachers
    /** Fields **/
    private String firstName;
    private String lastName;
    private String subject;

    /** Default Constructor **/
    Teacher(){
        firstName = "";
        lastName = "";
        subject = "";
    }

    /** Constructor **/
    Teacher(String firstName, String lastName, String subject){ // enables us to create teachers outside of this class and assign different values to the fields
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    /** Getters and Setters **/
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /** Overrider **/
    public String toString(){ // this method overrides a method that already exists and prints the following line bellow when asked
        return "Name: " + this.firstName + " " + this.lastName + "\t" + "Subject: " + this.subject;
    }
}
