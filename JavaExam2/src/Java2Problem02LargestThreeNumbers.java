import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;


public class Java2Problem02LargestThreeNumbers {

	public static void main(String[] args) {
		Locale.setDefault(new Locale("US", "US"));
		int n=0;
		ArrayList<BigDecimal> nums = new ArrayList<>();
		
		try (Scanner input = new Scanner(System.in)) {
			n = input.nextInt();
			for (int i = 0; i < n; i++) {
				BigDecimal tmp = input.nextBigDecimal();
				//if (!nums.contains(tmp))
					nums.add(tmp);
			}
		}
		Collections.sort(nums, Collections.reverseOrder());
		for (int i = 0; ((i < nums.size()) && (i<3)); i++) {
			System.out.println(nums.get(i).toPlainString());
		}
	}
	

}
