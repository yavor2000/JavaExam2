import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;


public class Java2Problem04_Orders {
	
	static String[] data = new String[3];
	static int count;
	
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			int n = input.nextInt();
			HashMap<String, TreeMap<String, Integer>> vegetables = new LinkedHashMap<>();
			for (int i = 0; i < n; i++) {
				//data = input.nextLine().split(" ");
				data[0] = input.next(); //person's name
				data[1] = input.next(); //quantity
				data[2] = input.next(); //vegetable
				count=0;
				if (vegetables.containsKey(data[2])) {
					TreeMap<String, Integer> person = vegetables.get(data[2]);
					if (person.containsKey(data[0])) {
						count=person.get(data[0]); //if person is already present in vegetable HashMap add-up the quantity 
					}
					person.put(data[0], count+Integer.parseInt(data[1]));
					vegetables.put(data[2], person);
					continue;
				} //if the person is not existing in this vegetable HashMap create a new one and add it
				TreeMap<String, Integer> person = new TreeMap<>();
				person.put(data[0], Integer.parseInt(data[1]));
				vegetables.put(data[2], person);
			}
			for (String name : vegetables.keySet()) {
				String line="";
				System.out.print(name+":"); //print the name of the vegetable in the order added
				for (String vegName : vegetables.get(name).keySet()) {
					line += (" "+vegName+" "+vegetables.get(name).get(vegName)+","); //and add up the persons (alphabetically) and quantities
				}
				line = line.replaceAll(",$", ""); //remove the last comma
				System.out.print(line+"\n");
			}
		}

	}

}
