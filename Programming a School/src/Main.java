public class Main { // This class actually runs the code
    public static void main(String[] args) {

        School firstSchool = new School("Richmond High","Medium","Richmond, BC"); // creates a new school
        firstSchool.toString("School"); // prints the school
        System.out.println(" "); // adds a space/empty line

        // the following code adds 10 students to the "Students" arrayList
        firstSchool.addStudent("Jesse","Cheung", 9);
        firstSchool.addStudent("Leo","Smith", 12);
        firstSchool.addStudent("Abigail","Wong", 11);
        firstSchool.addStudent("Samantha","Park", 10);
        firstSchool.addStudent("Vincent","Zhao", 9);
        firstSchool.addStudent("Rachel","Leung", 12);
        firstSchool.addStudent("Matthias","Thompson", 10);
        firstSchool.addStudent("Braden","Li", 11);
        firstSchool.addStudent("Joyce","Liu", 9);
        firstSchool.addStudent("Riley","Kim", 12);

        // the following code adds 3 teachers to the "Teachers" arrayList
        firstSchool.addTeacher("Lewis","Yang","Physics");
        firstSchool.addTeacher("Sarah","Chan","Social Studies");
        firstSchool.addTeacher("David","Williams","Pre calculus");


        firstSchool.toString("Students"); // prints the "Students" arrayList
        System.out.println(" "); // adds a space/empty line

        firstSchool.toString("Teachers"); // prints the "Teachers" arrayList
        System.out.println(" "); // adds a space/empty line


        firstSchool.removeStudent(1); // removes a student from the arrayList at index 1
        firstSchool.removeStudent(2); // removes a student from the arrayList at index 2
        System.out.println(" "); // adds a space/empty line

        firstSchool.removeTeacher(1); // removes a teacher from the arrayList at index 1
        System.out.println(" "); // adds a space/empty line


        firstSchool.toString("Students"); // prints the "Students" arrayList
        System.out.println(" "); // adds a space/empty line

        firstSchool.toString("Teachers"); // prints the "Teachers" arrayList
    }
}
