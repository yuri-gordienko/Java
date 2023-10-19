package ua.com.alevel;

public class ConditionalsIfSwich {

    //    Conditionals Rules
//    if (condition) {
//         block of code to be executed if the condition is true
//    }
//----------------------------------------------------------------------------------------
//    if (condition) {
//         block of code to be executed if the condition is true
//    } else {
//         block of code to be executed if the condition is false
//    }
//example
//    int time = 20;
//    if (time < 18) {
//        System.out.println("Good day.");
//    } else {
//        System.out.println("Good evening.");
//    }

//    Ternary Operator
//    It can be used to replace multiple lines of code with a single line, and is most often used to replace simple if else statements:
//    SyntaxGet your own Java Server
//            variable = (condition) ? expressionTrue :  expressionFalse;
//    Example
//    int time = 20;
//    String result = (time < 18) ? "Good day." : "Good evening.";
//    System.out.println(result);
//----------------------------------------------------------------------------------------------
//    if (condition1) {
//         block of code to be executed if condition1 is true
//    } else if (condition2) {
//         block of code to be executed if the condition1 is false and condition2 is true
//    } else {
//         block of code to be executed if the condition1 is false and condition2 is false
//    }
//    example
//    int time = 22;
//    if (time < 10) {
//        System.out.println("Good morning.");
//    } else if (time < 18) {
//        System.out.println("Good day.");
//    } else {
//        System.out.println("Good evening.");
//    }
// Outputs "Good evening."
//---------------------------------------------------------------------------------------------------------
//    ConditionalsIfSwich
//    The 'default' Keyword
//    The default keyword specifies some code to run if there is no case match:
//
//    Example
//    int day = 4;
//    switch (day) {
//        case 6:
//            System.out.println("Today is Saturday");
//            break;
//        case 7:
//            System.out.println("Today is Sunday");
//            break;
//        default:
//            System.out.println("Looking forward to the Weekend");
//    }
// Outputs "Looking forward to the Weekend"
//---------------------------------------------------------------------------------------------------------


    public static void main(String[] args) {

//        int age = 17;
//
//        if (age >= 18) {
//            System.out.println("you are adult person");
//        } else {
//            System.out.println("you are not adult person");
//        }

//_____________________________________________________________________
//        int money = 60;
//        int age = 19;
//
//
//        int costProducts = 50;
//        int ageAllowed = 18;
//
//        boolean isEnoughMoney = costProducts <= money;
//        boolean canBuyByAge = age >= ageAllowed;
//
//        boolean canBuyByTwoRules = isEnoughMoney && canBuyByAge;
//
//        System.out.println(isEnoughMoney);
//        System.out.println(canBuyByAge);
//        System.out.println(canBuyByTwoRules);

//________________________________________________________________________________
//        int cashMoney = 20;
//        int cardMoney = 90;
//
//        int products = 50;
//
//        boolean isEnoughCashMoney = products <= cashMoney;
//        boolean isEnoughCardMoney = products <= cardMoney;
//
//        boolean canBuy = isEnoughCashMoney || isEnoughCardMoney;
//
//        System.out.println(canBuy);
//    }

//    ________________________________________________________________________________
//        int twoDaysCost = 50; // dys 1-2
//        int fiveDaysCoct = 40; // days 3-5
//        int tenDaysCost = 30;  // days
//
//        int twoDaysRent = getPriceRent(2); // 2*50
//        int fiveDaysRent = getPriceRent(5); // 2*50 + 3*40
//        int tenDaysRent = getPriceRent(10); // 6-10 2*50 + 3*40 + 5*30
//
//        System.out.println(twoDaysRent);
//        System.out.println(fiveDaysRent);
//        System.out.println(tenDaysRent);
//
//    }

//    public static int getPriceRent(int holiday) {
//        if (holiday <= 2) {
//            return holiday * 50;
//        } else {
//        int daysLeft = holiday - 2;
//        if (holiday <= 5) {
//            return daysLeft * 40 + 2 * 50;
//        } else {
//            daysLeft = holiday - 5;
//            return daysLeft * 30 + 2 * 50 + 3 * 40;
//            }
//        }
//    }

//    public static int getPriceRent(int holiday) {
//        if (holiday <= 2) {
//            return holiday * 50;
//        }
//        int daysLeft = holiday - 2;
//        if (holiday <= 5) {
//            return daysLeft * 40 + 2 * 50;
//        }
//        daysLeft = holiday - 5;
//        return daysLeft * 30 + 2 * 50 + 3 * 40;
//    }

//    _____________________________________________________________________________________________
//    Ternary operators
//     int age = 17;
//     String message = age >= 18 ? "Adult" : "Chield";
//        System.out.println(message);
//_____________________________________________________________________________________________


//        public static void main (String[]args){
//            System.out.println(getResult(10, -5));
//        }
//
//        public static double getResult ( double a, double b){
//
//
//            double num1 = a + b;
//            double num2 = a - b;
//            double num3 = a * b;
//            double num4 = a / b;
//
//            if (num1 > num2 && num1 > num3 && num1 > num4) {
//                return num1;
//            }
//            if (num2 > num1 && num2 > num3 && num2 > num4) {
//                return num2;
//            }
//            if (num3 > num1 && num3 > num2 && num3 > num4) {
//                return num3;
//            } else {
//                return num4;
//            }
//        }
//____________________________________________________________________________________________________________

    }
}
