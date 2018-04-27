package lession01_streams;

import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class Java8Streams_Part01 {
	public static void main(String[] args) throws IOException {
		
		System.out.println("--- Java Streams ---\n");
		
		//1. Integer Stream
		System.out.print("1. Integer Stream range from 1 to 10: ");
		IntStream
			.range(1, 10)
			.forEach(System.out::print);
		System.out.println("\n");
		
		//2. Integer Stream with skip
		System.out.print("2. Integer Stream with skip to 5 in range from 1 to 10: ");
		IntStream
			.range(1, 10)
			.skip(5)
			.forEach(x -> System.out.print(x));
		System.out.println("\n");
		
		//3. Integer Stream with sum
		System.out.print("3. Integer Stream with sum of range from 1 to 5: ");
		System.out.print(
		IntStream
			.range(1, 5)
			.sum());
		System.out.println("\n");
		
		//4. Stream.of, sorted and findFirst
		System.out.print("4. Stream.of, sorted and findFirst in array: ");
		Stream.of("Ava", "Aneri", "Alberto")
			.sorted()
			.findFirst()
			.ifPresent(System.out::println);	
		System.out.println();
			
		//5. Stream from Array, sort, filter and print
		String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sam"};
		System.out.println("5. Stream from Array, sort, filter and print the names start with 'S': ");
		Arrays.stream(names) //same as Stream.of(names)
			.filter(x -> x.startsWith("S"))
			.sorted()
			.forEach(System.out::println);
		System.out.println();
		
		//6. Average of squares of an int array
		System.out.print("6. Average of squares of an int array: ");
		Arrays.stream(new int[] {2, 4, 6, 8, 10})
			.map(x -> x * x)
			.average()
			.ifPresent(System.out::println);
		System.out.println();
		
		//7. Stream from List, filter and print
		List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "Amanda", "Hans", "Shivika");
		System.out.println("7. Stream from List, filter and print: ");
		people
			.stream()
			.map(String::toLowerCase)
			.filter(x -> x.startsWith("a"))
			.forEach(System.out::println);
		System.out.println();
		
		//8. Stream rows from text file, sort, filter, and print
		Stream<String> bands = Files.lines(Paths.get("D:\\self-research\\java8\\Java8\\resources\\bands.txt"));
		System.out.println("8. Stream rows from text file, sort, filter, and print:");
		bands
			.sorted()
			.filter(x -> x.length() > 13)
			.forEach(System.out::println);
		bands.close();
		System.out.println();
		
		//9. Stream rows from text file and save to List
		System.out.print("9. Stream rows from text file and save to List: ");
		List<String> bands2 = Files.lines(Paths.get("D:\\self-research\\java8\\Java8\\resources\\bands.txt"))
			.filter(x -> x.contains("jit"))
			.collect(Collectors.toList());
		bands2.forEach(x -> System.out.println(x));
		System.out.println();
		
		//10. Stream rows from CSV file and count
		Stream<String> rows1 = Files.lines(Paths.get("D:\\self-research\\java8\\Java8\\resources\\data.txt"));
		System.out.print("10. Stream rows from CSV file and count: ");
		int rowCount = (int)rows1
			.map(x -> x.split(","))
			.filter(x -> x.length == 3)
			.count();
		System.out.print(rowCount + " rows.");
		rows1.close();
		System.out.println("\n");
		
		//11. Stream rows from CSV file, parse data from rows
		Stream<String> rows2 = Files.lines(Paths.get("D:\\self-research\\java8\\Java8\\resources\\bands.txt"));
		System.out.println("11. Stream rows from CSV fils, parse data from rows: ");
		rows2
			.map(x -> x.split(","))
			.filter(x -> x.length == 3)
			.filter(x -> Integer.parseInt(x[1]) > 15)
			.forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
		rows2.close();
		System.out.println();
		
		//12. Stream rows from CSV file, store fields in HashMap
		System.out.println("12. Stream rows from CSV file, store fields in HashMap:");
		Stream<String> rows3 = Files.lines(Paths.get("D:\\self-research\\java8\\Java8\\resources\\bands.txt"));
		Map<String, Integer> map = new HashMap<>();
		map = rows3
			.map(x -> x.split(","))
			.filter(x -> x.length == 3)
			.filter(x -> Integer.parseInt(x[1]) > 15)
			.collect(Collectors.toMap(
				x -> x[0],
				x -> Integer.parseInt(x[1])));
		rows3.close();
		for (String key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}
		System.out.println();
		
		//13. Reduction - sum
		double total = Stream.of(7.3, 1.5, 4.8)
			.reduce(0.0, (Double a, Double b) -> a + b);
		System.out.println("13. Reduction - sum = " + total);
		System.out.println();
		
		//14. Reduction - summary statistics
		System.out.println("14. Reduction - summary statistics:");
		IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
			.summaryStatistics();
		System.out.println(summary);
		
	}
}