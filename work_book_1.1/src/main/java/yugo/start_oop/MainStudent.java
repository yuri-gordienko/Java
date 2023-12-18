package yugo.start_oop;



public class MainStudent {

    public static void main(String[] args) {

        StudentService studentService = new StudentService();

        Student st1 = new Student();
        st1.setFullname("Yuri Gordienko");
        st1.setAge(36);
        st1.setId("1");
        studentService.create(st1);
        Student st2 = new Student();
        st2.setFullname("Kate Berdnikova");
        st2.setAge(33);
        st2.setId("2");
        studentService.create(st2);
        Student st3 = new Student();
        st3.setFullname("Artem Berdnikov");
        st3.setAge(35);
        st3.setId("3");
        System.out.println(" All students:");
        studentService.create(st3);

        Student[] all = studentService.allStudents();
        for (Student s : all) {
            if (s != null) {
                System.out.println(s);
            }
        }

        System.out.println("\n Get student by Id:");
        System.out.println(studentService.stById("1"));

//        System.out.println("\nUpdate:");
//        String id = "1";
//        Student student1 = studentService.stById(id);
//        student1.setFullname("Yuri Gordienko");
//        student1.setAge(37);
//        studentService.update(student1);
//        Student [] all2 = studentService.allStudents();
//        for (Student s : all2) {
//            if (s != null) {
//                System.out.println(s);
//            }
//        }

//        System.out.println("\n Deleted:");
//        studentService.delete("1");
//        Student [] all3 = studentService.allStudents();
//        for (Student s : all3) {
//            if (s != null) {
//                System.out.println(s);
//            }
//        }
    }
}
