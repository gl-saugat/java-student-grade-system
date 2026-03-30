package gradingSystem;

public class Main {
    public static void main(String[] args) {
        Management management = new Management();

        management.addStudent("Saugat", 45);
        management.addStudent("Saugat2", 65);
        management.addStudent("Saugat23", 98);

        management.listAllStudents();

        management.topStudent();

        management.averageGrade();

        management.passedStudents();
    }
}