package gradingSystem;

public class Student {
    private String name;
    private double score;

    public Student(String name, double scores){
        this.name = name;
        this.score = scores;
    }

    public String getName(){
        return this.name;
    }
    public double getScore(){
        return this.score;
    }

    public Grades assignGrade(){
        double marks = this.getScore();
        if (marks >= 90) return Grades.A;
        else if (marks >= 80) return Grades.B;
        else if (marks >= 70) return Grades.C;
        else if (marks >= 50) return Grades.D;
        else return Grades.FAIL;
    }


    @Override
    public String toString(){
        return this.name + " : " + this.score;
    }
}
