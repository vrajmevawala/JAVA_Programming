import java.util.Scanner;

class Student
{
    private int studentID;
    private String name;
    public Student(int studentID, String name)
    {
        this.studentID = studentID;
        this.name = name;
    }
    public int getStudentID()
    {
        return studentID;
    }
    public String getName()
    {
        return name;
    }
}
class Grade
{
    private int studentID;
    private int courseID;
    private char grade;
    public Grade(int studentID, int courseID, char grade)
    {
        this.studentID = studentID;
        this.courseID = courseID;
        this.grade = grade;
    }
    public int getStudentID()
    {
        return studentID;
    }
    public int getCourseID()
    {
        return courseID;
    }
    public char getGrade()
    {
        return grade;
    }
}
class GradingSystem
{
    private Student students[];
    private Grade grades[];
    private int courseCredits[];
    private int studentCount;
    private int gradeCount;
    public GradingSystem(int numStudents, int numCourses)
    {
        students = new Student[numStudents];
        grades = new Grade[numStudents * numCourses];
        courseCredits = new int[numCourses];
        studentCount = 0;
        gradeCount = 0;
    }
    public void addStudent(Student stud)
    {
        if (studentCount < students.length) 
        {
            students[studentCount] = stud;
            studentCount++;
        } 
        else 
            System.out.println("Cannot add more students.");
    }
    public void addGrade(Grade grade)
    {
        if (gradeCount < grades.length) 
        {
            grades[gradeCount] = grade;
            gradeCount++;
        } 
        else 
            System.out.println("Cannot add more grades.");
    }
    public void addCourseCredits(int courseID , int credits)
    {
        if (courseID < courseCredits.length) 
        {
            courseCredits[courseID] = credits;
        } 
        else 
            System.out.println("Invalid course ID.");
    }
    public double calculateGPA(int studentID)
    {
        int totalPoints = 0;
        int totalCredits = 0;

        for (int i = 0; i < gradeCount; i++) {
            if (grades[i].getStudentID() == studentID) 
            {
                int courseId = grades[i].getCourseID();
                int credit = courseCredits[courseId];
                totalPoints += gradeToPoint(grades[i].getGrade()) * credit;
                totalCredits += credit;
            }
        }
        if (totalCredits == 0 ) 
            return 0;
        else
            return (double) totalPoints / totalCredits;
    }
    public int gradeToPoint(char grade)
    {
        switch (grade) 
        {
            case 'A':
                return 10;
            case 'B':
                return 9;
            case 'C':
                return 8;
            case 'D':
                return 6;
            case 'F':
                return 0;
            default:
                return 0;
        }
    }
    public void printGradeReport(int studentID) 
    {
        for (int i = 0; i < studentCount; i++) 
        {
            Student student = students[i];
            if (student.getStudentID() == studentID) 
            {
                System.out.println("Grade Report for " + student.getName() + ":");
                for (int j = 0; j < gradeCount; j++) 
                {
                    Grade grade = grades[j];
                    if (grade.getStudentID() == studentID) 
                    {
                        System.out.println("Course ID: " + grade.getCourseID() + "  Grade: " + grade.getGrade());
                    }
                }
                System.out.println("GPA: " + calculateGPA(studentID));
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
public class GradingSystemMGMT {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        GradingSystem gradingsystem = new GradingSystem(100, 10); 

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. Add Course Credits");
            System.out.println("4. Calculate GPA");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int studentID = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    Student student = new Student(studentID,name);
                    gradingsystem.addStudent(student);
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    int stuID = sc.nextInt();
                    System.out.print("Enter Course ID: ");
                    int courseID = sc.nextInt();
                    System.out.print("Enter Grade (A/B/C/D/F): ");
                    char gra = sc.next().charAt(0);
                    Grade grade = new Grade(stuID, courseID, gra);
                    gradingsystem.addGrade(grade);
                    break;
                case 3:
                    System.out.print("Enter Course ID: ");
                    int courseId = sc.nextInt();
                    System.out.print("Enter Course Credits: ");
                    int credits = sc.nextInt();
                    gradingsystem.addCourseCredits(courseId, credits);
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    int studID = sc.nextInt();
                    gradingsystem.printGradeReport(studID);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
