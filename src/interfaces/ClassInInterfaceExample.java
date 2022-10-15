package interfaces;

interface Abcd {
    class Mnop {
        public void testMethod(String caller) {
            System.out.println("test method: " + caller);
        }
    }
}

class Efgh implements Abcd {
    public void testInterfaceMethod() {
        Mnop op = new Mnop();
        op.testMethod("efgh");
    }
}

public class ClassInInterfaceExample {
    public static void main(String[] args) {
        Efgh ef = new Efgh();
        ef.testInterfaceMethod();

        Abcd.Mnop op = new Abcd.Mnop();
        op.testMethod("main");
    }
}
