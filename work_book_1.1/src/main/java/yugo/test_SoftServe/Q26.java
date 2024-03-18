package yugo.test_SoftServe;

class Q26 {
//    void method1() { throw new MyException(); }
    void method2() { throw new MyRuntimeException(); }
}

class MyException extends Exception { }
class MyRuntimeException extends RuntimeException { }
