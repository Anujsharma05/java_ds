/**
 * 
 */
package java_eight.lambda_expression.anonymous_innerclass;

/**
 * @author anuj.sharma
 *
 * @date 11-Jun-2022
 */

interface Interf {
	public void m1();
}
public class ThisKeyword {

	//instance var outer
	int x = 888;
	
	public void m2() {
		
		int localVarOfM2 = 33;
		//inside anonymous inner class, possible to declare instance variable
		Interf interf = new Interf() {
			//instance var inner
			int x = 999;
			@Override
			public void m1() {
				System.out.println(ThisKeyword.this.x); //outer
				System.out.println(this.x);	//inner
			}
		};
		
		interf.m1();
		
		
		//inside lambda func, not possible to declare instance variable
		Interf interfLambda = () -> {
			int x = 999; //local var not instance var
			System.out.println(this.x); //outer
			System.out.println(x); // inner because local var
			
//			localVarOfM2 = 11; won't work because var is implicitly final
//			System.out.println(localVarOfM2);
		};
		
//		localVarOfM2 = 131; //won't work if used inside lambda function otherwise its fine to use
		interfLambda.m1();
	}
	
	public static void main(String args[]) {
		ThisKeyword tk = new ThisKeyword();
		tk.m2();
	}
}
