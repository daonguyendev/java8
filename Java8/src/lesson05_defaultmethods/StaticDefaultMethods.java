package lesson05_defaultmethods;

public class StaticDefaultMethods {
	
	public interface vehicle {
		default void print() {
			System.out.println("I am a vehicle!");
		}
		
		static void blowHorn() {
			System.out.println("Blowing horn!");
		}
	}
	
}
