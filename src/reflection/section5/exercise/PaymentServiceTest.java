package reflection.section5.exercise;

public class PaymentServiceTest {
    public static void beforeClass() {
        // Called in the beginning of the test suite only once
        // Used for all tests need to share computationally expensive setup
        System.out.println("before class");
    }

    public static void beforeClass(int one) {
        System.out.println("before class with parameters");
    }

    public void setupTest() {
        // Called before every test
        // Used for setting up resource before every test
        System.out.println("setup test");
    }

    public void testCreditCardPayment() {
        System.out.println("testCreditCardPayment");
    }

    public void testWireTransfer() {
        System.out.println("testWireTransfer");
    }

    public void testInsufficientFunds() {
        System.out.println("testInsufficientFunds");
    }

    public static void afterClass() {
        // Called once in the end of the entire test suite
        // Used for closing and cleaning up common resources
        System.out.println("after class");
    }
}



