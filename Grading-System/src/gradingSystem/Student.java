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

    @Override
    public String toString(){
        return this.name + " : " + this.score;
    }
}
