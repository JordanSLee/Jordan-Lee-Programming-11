import java.util.ArrayList;

public class School { // The "School" class helps add, delete and show students and teachers through the the methods stored in it
    /** Array Lists **/
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList courses = new ArrayList<>();

    /** Fields **/
    private String schoolName;
    private String schoolSpirit;
    private String schoolLocation;

    /** Default Constructor **/
    School(){
        schoolName = "";
        schoolSpirit = "";
        schoolLocation = "";
    }

    /** Constructor **/
    School(String schoolName, String schoolSpirit, String schoolLocation){ // enables us to create schools outside of this class and assign different values to the fields
        this.schoolName = schoolName;
        this.schoolSpirit = schoolSpirit;
        this.schoolLocation = schoolLocation;
    }

    /** Getters and Setters **/
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolSpirit() {
        return schoolSpirit;
    }

    public void setSchoolSpirit(String schoolSpirit) {
        this.schoolSpirit = schoolSpirit;
    }

    public String getSchoolLocation() {
        return schoolLocation;
    }

    public void setSchoolLocation(String schoolLocation) {
        this.schoolLocation = schoolLocation;
    }


    /** Adding and Subtracting Teachers **/

    public void addTeacher(String firstName, String lastName, String subject){ // creates a new teacher in the "Teacher" class and adds it when asked
        Teacher newTeacher = (new Teacher(firstName, lastName, subject));
        teachers.add(newTeacher);
    }
    public void removeTeacher(int location) { //removes a teacher from an integer location which needs to be within the size of the arrayList
        if(location > teachers.size()){ // if not within the size of the arrayList, proceed to the next step
            System.out.println("ERROR1"); // print "ERROR1"
        }
        else{ // if within the size of the arrayList, proceed to the next step
            System.out.println("Removing teacher: " + teachers.get(location)); // print "Removing teacher: (the teacher)"
            teachers.remove(location); // removes the teacher from the integer location

        }
    }
    /** Showing arrayLists of Teachers and Students **/
    public void toString(String name){ // for showing teachers when the correct input string is used
        if(name.equals("Teachers")) {
            for (int i = 0; i < teachers.size(); i++) { // this for loop goes through the entire teachers arrayList and print out each one
                System.out.println(teachers.get(i));
            }
        }
        else if(name.equals("Students")){ // for showing students when the correct input string is used
            for (int i = 0; i < students.size(); i++) { // this for loop goes through the entire students arrayList and print out each one
                System.out.println(students.get(i));
            }
        }
        else if(name.equals("School")){ // for showing schools when the correct input string is used
            System.out.println(this.schoolName + "\t" + this.schoolSpirit + "\t" + this.schoolLocation); // prints the school
        }
        else{ // if something else is inputed, it will print "ERROR3"
            System.out.println("ERROR3");
        }
    }

    /** Adding and Subtracting Students **/

    public void addStudent(String firstName, String lastName, int grade){ // creates a new student in the "Student" class and adds it when asked
        Student newStudent = (new Student(firstName, lastName, grade));
        students.add(newStudent);
    }
    public void removeStudent(int location){ // removes a student from an integer location which needs to be within the size of the arrayList
        if(location > students.size()){ // if not within the size of the arrayList, proceed to the next step
            System.out.println("ERROR2");// print "ERROR2"
        }
        else{ // if within the size of the arrayList, proceed to the next step
            System.out.println("Removing student: " + students.get(location)); // print "Removing student: (the student)"
            students.remove(location); // removes the student from the integer location

        }
    }
}
