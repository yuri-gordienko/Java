package yugo;

public class ExceptionsCheckTest {

    public void test() {

//        unhandledError(10, 0);
//        handledError(10, 0);
//        throwNewRuntimeException(10, 0);
//        throwException(10, 0);
//        tryCatch(10, 0);
        tryCatch2(10, 0);
    }

    private void unhandledError(int a, int b) {
// вискочить Exception in thread "main" java.lang.ArithmeticException: / by zero - переривання потоку в Маін методі
        int result = a / b;
        System.out.println("result - " + result);
    }

    private void handledError(int a, int b) {
// не правильна обробка! Exception не вилітає, потік не переривається, але метод не виконується і ми про це нічого не знаєм
        if (b != 0) {
            int result = a / b;
            System.out.println("result - " + result);
        }
    }

    private void throwNewRuntimeException(int a, int b) {
        if (b == 0) {
// умисно перериваю потік і пишу повідомлення, працівати з такими даними не можливо.
// тобто я упередженно прописую умови, планую варіанти розвитку подій, з якими програма не буде працювати
// я упевнений, що з такими даними програма працювати не буде (ділення на 0, мило без собачки ...)
// дозволено кидати тільки в многопоточній програмі, щоб не перервати Маін потік
            throw new RuntimeException("Thread was interrupted, invalid value - division by zero");
        }
        int result = a / b;
        System.out.println("result - " + result);
    }

    private void throwException(int a, int b) throws Exception {
// перекидую (повертаю throws Exception) виняток туди, хто викликав мій метод, тобто я прийняв дані (int a, int b)
// від конкретного методу, а вони не коректні, тобто аварійно я прогу не завершую, а кажу тому хто передав мені дані,
// подивись на них і виправ (наприклад, прийшли суми грошей або дати у неправильному форматі), метод, який викликав
// мій метод може перекинути вище цю помилку, якщо це не його відповідальність.
// я приймаю його дані, мій метод готовий їх відпрацювати, але перевірок я робити не буду, перевіряй сам
        int result = a / b;
        System.out.println("result - " + result);
    }

    private void tryCatch(int a, int b) {
// обробляю помилку, щоб програма завершилася (не обірвалася) але конкретно цей метод не відпрацює
// наприклад при створені студента зберігулься усі дані крім віку, але нам це не дуже важливо. Головне об'єкт збережеться
        try { // у трай засовуємо потенціально опасний блок коду
            int result = a / b;
            System.out.println("result - " + result);
        } catch (Exception e) {     // кеч його перехоплює і оброббляє
            System.out.println(e.getMessage());     // отримуємо повідомлення, що сталася помилка
        }
        System.out.println("Program was finished"); // але програма в цілому завершилася
    }

    private void tryCatch2(int a, int b) {
        try {
            int result = a / b;
            System.out.println("result - " + result);
        } catch (ArithmeticException e) {     // ідемо від чаялда до парента, якщо не маю пермішенов його виправляти
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {      // якщо ArithmeticException не відпрацював, перенаправляємо вище і т.д.
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally block"); // виконується завжди
        }
        System.out.println("Program was finished"); // виконується тому що не у блоку трай-кетч
    }
}


