import java.util.Scanner;

class Course 
{
    private int courseID; 
    private String courseName;
    private int credits; 
    public Course(int courseID,String courseName, int credits)
    {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
    }
    public int getCourseID()
    {
        return courseID;
    }
    public String getCourseName()
    {
        return courseName;
    }
    public int getCredits()
    {
        return credits;
    }
    public String toString()
    {
        return "\nCourse ID : " + courseID + "\nCourse Name : " + courseName + "\nCredits : " + credits;
    }
}
class Enrollement
{
    private int studentCourse[][];
    private int count[];

    public Enrollement(int numStudents, int numCourses)
    {
        studentCourse = new int[numStudents][numCourses];
        count = new int[numStudents];
    }

    public void enroll(int studentID, int courseID)
    {
        if (count[studentID] <= studentCourse[studentID].length) 
        {
            studentCourse[studentID][count[studentID]] = courseID;
            count[studentID]++;
        } 
        else {
            System.out.println("Student " + studentID + " cannot enroll in more courses.");
        }
    }
    public void drop(int studentID, int courseID)
    {
        boolean found = false;
        for (int i = 0; i < count[studentID]; i++) 
        {
            if (studentCourse[studentID][i] == courseID) 
            {
                studentCourse[studentID][i] = studentCourse[studentID][count[studentID] - 1];
                count[studentID]--;
                found = true;
                System.out.println("Student " + studentID + " dropped course " + courseID);
                break;
            }
        }
    }
    public void getEnrolledCourses(int studentID, Course[] courseCatalog)
    {
        System.out.println("Courses enrolled by student " + studentID + ":");
        for (int i = 0; i < count[studentID]; i++)
        {
            int courseID = studentCourse[studentID][i];
            for (Course course : courseCatalog) 
            {
                if (course.getCourseID() == courseID) 
                {
                    System.out.println(course);
                    break;
                }
            }
        }
    }
}
public class CourseEnrollement 
{
    private static Course[] courseCatalog;
    private static Enrollement enrollment;
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of courses: ");
        int numCourses = sc.nextInt();
        courseCatalog = new Course[numCourses];

        for (int i = 0; i < numCourses; i++) 
        {
            System.out.print("Enter Course ID: ");
            int courseID = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Course Name: ");
            String couseName = sc.nextLine();
            System.out.print("Enter Course Credit: ");
            int credites = sc.nextInt();
            courseCatalog[i] = new Course(courseID,couseName,credites);
        }
      
        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        enrollment = new Enrollement(numStudents, numCourses);

        while (true) {
            System.out.println("\n1. Enroll Student");
            System.out.println("2. Drop Course");
            System.out.println("3. Get Enrolled Courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter Student ID: ");
                    int studentID = sc.nextInt();
                    System.out.print("Enter Course ID: ");
                    int courseID = sc.nextInt();
                    enrollment.enroll(studentID, courseID);
                    break;
                case 2:
                    System.out.print("\nEnter Student ID: ");
                    studentID = sc.nextInt();
                    System.out.print("Enter Course ID: ");
                    courseID = sc.nextInt();
                    enrollment.drop(studentID, courseID);
                    break;
                case 3:
                    System.out.print("\nEnter Student ID: ");
                    studentID = sc.nextInt();
                    enrollment.getEnrolledCourses(studentID, courseCatalog);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
