package pojos;

import java.util.ArrayList;

/**
 * To keep course and <arrayList>Assignments</arrayList>
 */
public class CourseAssignment {
    Course course;
    ArrayList<Assignment> assignments;

    public CourseAssignment(Course course, ArrayList<Assignment> assignments) {
        super();
        this.course = course;
        this.assignments = assignments;
    }

    public Course getCourse() {
        return course;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }
}
