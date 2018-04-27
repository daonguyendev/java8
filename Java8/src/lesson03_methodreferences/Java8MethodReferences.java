package lesson03_methodreferences;

import java.util.ArrayList;
import java.util.List;

public class Java8MethodReferences {

	public static void main(String[] args) {
		List names = new ArrayList<>();
		
		names.add("Ty");
		names.add("Teo");
		names.add("Tin");
		names.add("Ton");
		names.add("Tun");
		
		names.forEach(System.out::println);
	}

}
