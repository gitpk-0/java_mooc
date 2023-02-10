public class Class {
    private Teacher teacher;
    private String course;

    public Class(Teacher teacher, String course) {
        this.teacher = teacher;
        this.course = course;
    }

    public void printInformation() {
        System.out.println(this.course + ", teacher: " + this.teacher);
    }
}


/*

// Sweet Class Diagram
// -------------------

// Chain elements like this
[Customer]<>-orders*>[Order]++-0..*>[LineItem]

// Add notes
[Order]-[note: Aggregate Root ala DDD]

// Add more detail
[Customer|+forname: string;+surname: string;-password: string|login(user,pass)]



[Class]1++-1>[Teacher]<*-++1[LearningInstitution]

[Class|-course: String;-teacher: Teacher|+Class: (Teacher,course);+printInformation(): void]

[Teacher|-name: String; |+Teacher: (name); +toString(): String]

[LearningInstitution|-teachers: ArrayList; |+LearningInstitution(); +addTeacher: void; +toString: String]

