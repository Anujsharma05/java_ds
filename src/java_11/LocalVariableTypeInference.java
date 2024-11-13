package java_11;


public class LocalVariableTypeInference {

  /**
   * Only works for local variable
   */
//  var a = 12;
  public static void main(String[] args) {
    /**
     * Must be initialized in the same line
     */
    var a = "hello";  //string
    var b = 12; //int
    var c = 12.2; //double

    /**
     * null cannot be directly assigned
     */
//    var d = null;
    var d = (String) null;

    var var = "this will work";
    helloWorld(a,b,c);
  }
/**
 * This wont work
 */
//  class var {}

  private static void helloWorld(String a, int b, double c) {
  }

}
