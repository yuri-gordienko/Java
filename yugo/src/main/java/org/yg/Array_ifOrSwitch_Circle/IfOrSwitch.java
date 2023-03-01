package org.yg.Array_ifOrSwitch_Circle;
public class IfOrSwitch {

    public void test() {

        Man st = new Man();
        st.setAge(st.age);


        System.out.println(st.fullName());
        System.out.println(st.age);

  /*      if (st.age < 18) {
            System.out.println("Man is not valid");}
        else if (st.age > 50) {
            System.out.println("Man is not valid");

        } else {
                System.out.println("Man is valid");
            }
*/
        switch (st.age) {
            case 15, 17, 19 -> System.out.println("Index no chet");
            case 14, 16, 20, 22 -> System.out.println("Index is chet");



        }

    }

}

