package sepractice;

import java.util.HashSet;
import java.util.Set;

public class SchoolPortal {

 /*
 schoolPortal: schoolPortal Attributes

schoolDataBase:
A)listOfUsers
B)listOfCourses
C)ListOfInstructors
D)ListOfStudents
 Login:
 A)add course
 B)drop course
 E)look up list of classes
 D) look up specific class



  */

 Set<Patron> listOfUsers = new HashSet<>();
 Set<Instructor> listOfInstructors = new HashSet<>();
 Set<Student> listOfStudents = new HashSet<>();
 Set<Administator> listOfAdmins = new HashSet<>();
 Set<Course> courseList = new HashSet<>();
 Patron user = null;

 public SchoolPortal(){

 }

 public static void main(String[] args) {

 }
//user creation methods:
 public String createNewStudent(String firstName, String lastName, String emailAddress, String password, String phoneNumber, long idNumber ){
     Student newStudent = new Student(firstName,lastName,emailAddress,password,phoneNumber,idNumber);
     listOfUsers.add(newStudent);
     listOfStudents.add(newStudent);
     String toReturn = newStudent.getIdNumber();
     return toReturn;
 }

 public String createNewInstructor(String firstName, String lastName, String emailAddress, String password, String phoneNumber, long idNumber, String department){
     Instructor newInstructor = new Instructor(firstName,lastName,emailAddress,password,phoneNumber, idNumber, department);
     listOfUsers.add(newInstructor);
     listOfInstructors.add(newInstructor);
     String toReturn = newInstructor.getIdNumber();
     return toReturn;
 }

 public String createNewAdmin(String firstName, String lastName, String emailAddress, String password, String phoneNumber, long idNumber){
     Administator newAdmin = new Administator(firstName, lastName,emailAddress,password,phoneNumber,idNumber);
     listOfUsers.add(newAdmin);
     listOfAdmins.add(newAdmin);
     String toReturn = newAdmin.getIdNumber();
     return toReturn;
 }

 //end of User creation methods
    //patron login method
 public Patron StudentLogIn(String emailAddress, String password){
     for(Student student :listOfStudents){
         if(student.getEmailAddress() == emailAddress && student.getPassword() == password){
             user = student;
             System.out.println("welcome back Student: "+ user.getFirstName()+" "+user.getLastName()+"\r\n banner #: "+user.getIdNumber());
             return student;
         }
     }
     System.out.println("login failed");
     return null;
 }

    public Patron InstructorLogIn(String emailAddress, String password){
        for(Instructor instructor :listOfInstructors){
            if(instructor.getEmailAddress() == emailAddress && instructor.getPassword() == password){
                user = instructor;
                System.out.println("welcome back Instructor: "+ user.getFirstName()+" "+user.getLastName());
                return instructor;
            }
        }
        System.out.println("login failed");
        return null;
    }


    public Patron AdminLogIn(String emailAddress, String password){

     return null;
    }



    //student course management methods

 public void addCourseToStudent(Student student, Set<Course> courses){
     //check if course has prereq filled
     //check if course has coreq in same registration list
     //allow student to add course
     for(Course course: courses) {

         student.addCourse(course);
     }

 }

 public void dropCourseToStudent(Student student, Course course){
     //if student is null throw an illegalSArgumentException
     if(student == null){
         throw new IllegalArgumentException();
     }

     //if student does not contain course, return "Student is not taking this course"  (question - would one throw an error in this situation?)
     for(Course checker : student.getCourses()){
         if(checker == course){
             student.dropCourse(course);
             break;
         }
     }

 }

 //method for instructors and students to see courses which they are taking
 public String getListOfCoursesofPatron (){
     Set<Course> courses = new HashSet();
     String returnString = "";
     if(user instanceof Student){
          courses = ((Student) user).getCourses();
     }
     if(user instanceof Instructor){
          courses = ((Instructor) user).getCourseList();
     }
     for(Course course : courses){
         returnString += "course name: "+course.getTitle()+" course crn "+ course.getCRN();
     }
     return returnString;
 }

 public String getStudentTranscript(){
     return null;
 }

 public String getStudentGradeLevel(){
     return null;
 }




 //administrator course creation
    public void createCourse(String title, Instructor instructor, int courseSize, int creditsAmount, int timesOfMeeting, Set<Course> preReq, Set<Course> coRequisites, String attribute){
        Course newCourse = new Course(title,instructor, courseSize,creditsAmount,timesOfMeeting,preReq,coRequisites,attribute);
        courseList.add(newCourse);
 }

    public void courseDeletion(){

    }


  //search course catalog
    public String findCourse(String crn){
        return null;
    }

    public String allCoursesOffered(){
        return null;
    }


}