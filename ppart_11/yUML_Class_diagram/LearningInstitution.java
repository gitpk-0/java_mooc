import java.util.ArrayList;

public class LearningInstitution {
    private ArrayList<Teacher> teachers;

    public LearningInstitution() {
        this.teachers = new ArrayList<>();
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public String toString() {
        return "Number of teachers in the learning institution: " + this.teachers.size();
    }
}