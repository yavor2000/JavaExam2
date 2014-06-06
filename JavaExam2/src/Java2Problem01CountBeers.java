import java.util.Locale;
import java.util.Scanner;


public class Java2Problem01CountBeers {

	public static void main(String[] args) {
		Locale.setDefault(new Locale("US", "US")); // set localization to us which is like c# Cultureinfo.InvariantCulture

		try (Scanner input = new Scanner(System.in)) {
			int singles = 0;
			String inStr="";
			while (true) {
				inStr = input.nextLine();
				if (inStr.equals("End"))
					break;
				String[] data =inStr.split(" ");
				int number = Integer.parseInt(data[0]);
				String variable = data[1];
				if (variable.equals("stacks"))
					singles += number*20;
				else
					singles += number;
				if (!input.hasNextLine())
					break;
			}
			System.out.printf(""+(singles/20)+" stacks + " + (singles%20) + " beers");
		}
	}

}
