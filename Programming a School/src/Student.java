public class Student { // the "Student" class helps make new students
    /** Fields **/
    private String firstName;
    private String lastName;
    private int grade;
    static int studentId; // increases when a new student is made
    private int studentNums;

    /** Default Constructor **/
    Student(){
        firstName = "";
        lastName = "";
        grade = 0;
        studentId = studentNums;
        studentNums ++;
    }

    /** Constructor **/
    Student(String firstName, String lastName, int grade){ // enables us to create students outside of this class and assign different values to the fields
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.studentId = studentNums;
        studentNums ++;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getStudentNums() {
        return studentNums;
    }

    public void setStudentNums(int studentNums) {
        this.studentNums = studentNums;
    }

    /** Overrider **/
    public String toString(){ // this method overrides a method that already exists and prints the following line bellow when asked
        return "Name: " + this.firstName + " " + this.lastName + "\t" + "Grade: " + this.grade;
    }
}
