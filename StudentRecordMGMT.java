import java.util.Scanner;
class Student
{
    private int studentID;
    private String name;
    private int age;
    private String department;
    public Student(int studentID,String name,int age,String department)
    {
        this.studentID=studentID;
        this.name=name;
        this.age=age;
        this.department=department;
    }
    public int getStudentID()
    {
        return studentID;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public String getDepartment()
    {
        return department;
    }
    public String toString()
    {
        return "\nID : " + studentID + "\nName : " + name + "\nAge : " + age + "\nDepartment : " + department+ "\n";
    }
}
class StudentRecordSystem
{
    private Student[] students;
    private int count=0;
    public StudentRecordSystem() 
    {
        students = new Student[20];
    }
   
    public void addStudent(Student student)
    {
        if (count < students.length) 
        {
            students[count] = student;
            count++;
        }
    }
    public Student getStudent(int studentID)
    {
        for (int i = 0; i < count; i++) 
        {
            if (students[i].getStudentID() == studentID) 
            {
                return students[i];
            }
        }
        return null;
    }
    public void displayAllStudents()
    {
        for (int i = 0; i < count; i++) 
        {
            System.out.println(students[i].toString());
        }
    }
}
public class StudentRecordMGMT
{
    public static void main(String[] args) {
        StudentRecordSystem sr = new StudentRecordSystem();
        Scanner sc= new Scanner(System.in);
        while (true) 
        {
            System.out.println("1. Add new Student");
            System.out.println("2. Search Student");
            System.out.println("3. Display all Students");
            System.out.println("4. Exit");
            System.out.println("Enter your choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID : ");
                    int studentID = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name : ");
                    String name = sc.nextLine();
                    System.out.print("Enter age : ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Department : ");
                    String department = sc.next();
                    Student student = new Student(studentID, name, age, department);
                    sr.addStudent(student);                
                    break;
                
                case 2:
                    System.out.print("Enter Student ID : ");
                    int ID = sc.nextInt();
                    System.out.println(sr.getStudent(ID));
                    break;

                case 3:
                    sr.displayAllStudents();
                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice.");
                    break;
            }
        }  
    }
}