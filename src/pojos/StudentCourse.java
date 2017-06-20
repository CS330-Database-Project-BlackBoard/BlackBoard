package pojos;


import java.util.ArrayList;

public class StudentCourse {
    private Course course;
    private ArrayList<Student> students;

    public StudentCourse(Course course, ArrayList<Student> students) {
        super();
        this.course = course;
        this.students = students;
    }

    public Course getCourse() {
        return course;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
