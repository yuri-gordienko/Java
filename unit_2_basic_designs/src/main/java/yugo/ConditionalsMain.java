package yugo;

public class ConditionalsMain {

    public static void main(String[] args) {

    }


    public static String getDriverLicense(int age) {
//        if (age >= 16) {
//            return "You can get a license";
//        } else {
//            return "You can't get a license";
//        }

        //    Умовний (тернарний) оператор
        String message = (age >= 16) ? "You can get a license" : "You can't get a license";
        System.out.println(message);
        return message;
    }


//    Сума податку залежить від розміру доходу:
//    до 1000 грн включно - податок 2% від доходу;
//    від 1000 грн до 10000 грн включно - податок 3% від доходу;
//    понад 10000 грн - податок 5% від доходу.
    public static double calculateTaxes(double income) {
        if (income <= 1000) {
            return income * 0.02;
        } else if (income <= 10000) {
            return income * 0.03;
        } else {
            return income * 0.05;
        }
    }


//    Усі офіціанти люблять чайові! Один із них поділився з нами секретним рейтингом залежно від залишеної суми amount:
//    terrible, якщо amount дорівнює 0 грн;
//    poor, якщо amount від 0 до 10 грн включно;
//    good, якщо amount від 10 до 20 грн включно;
//    great, якщо amount від 20 до 50 грн включно;
//    excellent, якщо amount більше 50 грн.
    public static String getTipsRating(int amount) {
        if (amount == 0) {
            return "terrible";
        } else if (amount > 0 && amount <= 10) {
            return "poor";
        } else if (amount > 10 && amount <= 20) {
            return "good";
        } else if (amount > 20 && amount <= 50) {
            return "great";
        } else {
            return "excellent";
        }
    }

//    Метод має прийняти два числа: a та b. Далі він порівняє результати виконання операцій між числами
//    та поверне найбільший із типом double:
//    a + b
//    a - b
//    a * b
//    a / b
//    Наприклад, якщо a = 10 та b = -5, то:
//    a + b = 5.0
//    a - b = 15.0
//    a * b = -50.0
//    a / b = -2.0
//    Метод поверне найбільший результат: 15.0
    public static double getResult(double a, double b) {
        double number1 = a + b;
        double number2 = a - b;
        double number3 = a * b;
        double number4 = a / b;

        if (number1 < number2 ){
            number1 = number2;
        }
        if (number1 < number3) {
            number1 = number3;
        }
        if (number1 < number4) {
            number1 = number4;
        }
        System.out.println(number1);
        return number1;
    }
}