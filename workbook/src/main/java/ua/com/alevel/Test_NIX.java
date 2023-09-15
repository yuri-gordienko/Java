package ua.com.alevel;

//public class Test_NIX {

//    public static void main(String[] args){

//        String s = "Java";
//        s.concat(" SE 6");
//        s.replace('6', '7');
//        System.out.print(s);
//
//        int a[] = {1, 2, 053, 4};
//        int b [][] = {{1, 2, 4}, {2, 2, 1}, {0, 43, 2}};
//        System.out.println(a[3] == b[0][2]);
//        System.out.println(" " + (a[2] == b[2][1]));

//        String s = "JaVa";
//        s.concat(" SE 6");
//        s = s.toLowerCase();
//        System.out.print(s);
//         // How many?

//        int i = 10;
//        int n = ++i % 5;
//        System.out.println(i + " " + n);

//    }
// }

//------------------------------------------------------------------------------------------------------

    public class Test_NIX {

       public static void main(String[] args) {
        Person p1 = new Person("Yuri", 22);
        Test_NIX testNix = new Test_NIX();
        Person p2 = testNix.change(p1);

        System.out.println(p2.pid + " " + p2.name + " " + p2.age);
        System.out.println(p1.pid + " " + p1.name + " " + p1.age);
    }

        private Person change(Object o) {
            Person p2 = (Person) o;
            p2.age = 25;
            return p2;
        }
    }

    class Person {
        Person (String s, int i){
            ++ pid;
            name = s;
            age = i;
        }
        static int pid;
        int age;
        String name;
    }























