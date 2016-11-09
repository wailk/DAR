package dar.tools;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gen {

	public static void address() {
		// (`adresse`,`loyer`,`meuble`,`superficie`,`type`,`id_user`)
		List<String> rest = new ArrayList<>();
		String type[] = {"F4", "F3", "F5", "F2"};
		String inser = "VALUES('3 bd voltaire 75010 paris',1000,true,'200','F4',1);";
		Random r = new Random();
		List<String> adrr = Gen.readFromFile("address.txt");
		adrr.forEach(s -> {
			rest.add("INSERT INTO `bd_immo`.`appartements`\n"
					+ "(`adresse`,`loyer`,`meuble`,`superficie`,`type`,`id_user`)\n"
					+ "VALUES('" + s + "',"
					+ r.nextInt(1000)+ ","
					+ (r.nextInt(2)==0?false : true) + ","
					+ r.nextInt(1000)+ ",'"
					+ type[r.nextInt(4)] + "',"
					+ (r.nextInt(4)+1)+ ");"
			);
		});
		
		rest.stream().distinct().forEach(System.out::println);

	}

	public static void saveToFile(String filename, List<String> result) {
		int index = 0;
		try {
			while (true) {
				BufferedReader input = new BufferedReader(
						new InputStreamReader(new FileInputStream(filename + ".points")));
				try {
					input.close();
				} catch (IOException e) {
					System.err.println(
							"I/O exception: unable to close " + filename + Integer.toString(index) + ".points");
				}
				index++;
			}
		} catch (FileNotFoundException e) {
			printToFile(filename + ".points", result);
		}
	}

	public static void printToFile(String filename, List<String> points) {
		try {
			PrintStream output = new PrintStream(new FileOutputStream(filename));
			int x, y;
			for (String p : points)
				output.println(p);
			output.close();
		} catch (FileNotFoundException e) {
			System.err.println("I/O exception: unable to create " + filename);
		}
	}

	public static List<String> readFromFile(String filename) {
		String line;
		ArrayList<String> result = new ArrayList<String>();
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			try {
				while ((line = input.readLine()) != null) {
					result.add(line);
				}
			} catch (IOException e) {
				System.err.println("Exception: interrupted I/O.");
			} finally {
				try {
					input.close();
				} catch (IOException e) {
					System.err.println("I/O exception: unable to close " + filename);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Input file not found.");
		}
		return result;
	}

}
