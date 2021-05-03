package sepractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchoolPortalTest {

        SchoolPortal myYu = new SchoolPortal();
        @Test
        public void createNewStudentTest() {
            Student ariel = new Student("Ariel","Wernick","arielwernick@gmail.com","wer945","3109458419",491851);
            myYu.createNewStudent("Ariel", "Wernick", "arielwernick@gmail.com", "wer945", "3109458419",491851);
            assertEquals(myYu.StudentLogIn("arielwernick@gmail.com","wer945").getIdNumber(),ariel.getIdNumber());

        }

        @Test
        public void createNewInstructorTest(){
            Instructor rabbi = new Instructor("Josephus","Rabinowitz","jrabin@mail.yu.edu","jrabbit613","3109998888",613613,"Computer Science");
            myYu.createNewInstructor("Josephus","Rabinowitz","jrabin@mail.yu.edu","jrabbit613","3109998888",613613,"Computer Science");
            assertEquals(myYu.InstructorLogIn("jrabin@mail.yu.edu","jrabbit613").getEmailAddress(),rabbi.getEmailAddress());

        }

        @Test
        public void studentLogINFailure(){
            assertNull(myYu.StudentLogIn("arielwernick@gmail.com","wer945").getIdNumber());
        }

    }
