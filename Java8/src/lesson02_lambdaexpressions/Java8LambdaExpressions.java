package lesson02_lambdaexpressions;

public class Java8LambdaExpressions {
	
	final static String salutation = "Hello! ";

	public static void main(String[] args) {
		Java8LambdaExpressions tester = new Java8LambdaExpressions();
		
		//with type declaration
		MathOperation addition = (int a, int b) -> a + b;
		
		//with out type declaration
		MathOperation subtraction = (a, b) -> a - b;
		
		//with return statement along with curly braces
		MathOperation multiplication = (int a, int b) -> {return a * b;};
		
		//without return statement and without curly braces
		MathOperation division = (int a, int b) -> a / b;
		
		System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
		System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + tester.operate(10, 5, division));
		
		//without parenthesis
		GreetingService greetingService1 = message ->
		System.out.println("Hello " + message);
		
		//with parenthesis
		GreetingService greetingService2 = (message) ->
		System.out.println("Hello " + message);
		
		greetingService1.sayMessage("Teo");
		greetingService2.sayMessage("Ty");		
		
		//sing lambda expression, you can refer to any final variable or effectively final variable 
		//(which is assigned only once). Lambda expression throws a compilation error, 
		//if a variable is assigned a value the second time.
		GreetingService greetingService3 = message ->
		System.out.println(salutation + message);
		greetingService3.sayMessage("Tun");
	}
	
	interface MathOperation {
		int operation(int a, int b);
	}
	
	interface GreetingService {
		void sayMessage(String message);
	}
	
	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

}
