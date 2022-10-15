package static_keyword;

public class B {
    static {
        System.out.println("static block called");
    }
     class Test {
        static String name;
        public Test(String name) {
            Test.name = name;
        }
        
        public void greeting() {
        	System.out.println("hello how are you");
        }
    }

    public static void main(String[] args) {
//        Test t = new B().new Test("Anuj");
//        Test p = new B().new Test("Chitku");
//        System.out.println(t.name);
//        System.out.println(p.name);
        System.out.println(Test.name);
//        System.out.println(Test.greeting());
    }
}
