import java.util.Scanner;

public class Java2Problem03LongestOddEvenSequence {

	public static void main(String[] args) {
		String[] strArr;
		try (Scanner input = new Scanner(System.in)) {
			strArr = input.nextLine()
					.trim()
					.replaceAll(" ", "")
					.replaceAll("\\)\\(", " ")
					.replaceAll("\\(", "")
					.replaceAll("\\)", "")
					.split(" ");
			int[] arr = new int[strArr.length];
			for (int i = 0; i < strArr.length; i++)
				arr[i]=Integer.parseInt(strArr[i]); //the array of integers is created
			int stIndex=0;
			int maxIndex=0;
			int maxLength=1;
			int curLength;
			int a1, a2;
			
			if (arr.length==1) {
				System.out.println(1);
				return;
			}
			maxIndex=stIndex;
			maxLength=1;
			for (int p = 0; p < arr.length; p++) {
				stIndex=p;
				curLength=1;
				a2=arr[p];
				if (a2==0)
					for (int i = p+1; i < arr.length; i++) {
						if (arr[i]!=0) {
							a2=arr[i]+i-p;
							break;
						}
					}
			for (int i = p+1; i < arr.length; i++) {
				a1=a2;
				if (arr[i]==0)
					a2=a1+1;
				else a2=arr[i];
				if ( (Math.abs(a1%2)!=Math.abs(a2%2)) ) {
					curLength++;
					if (i==arr.length-1 && curLength>maxLength) {
						maxLength=curLength;
						maxIndex=stIndex;
					}
					continue;
				}
				if (curLength>maxLength) {
					maxLength=curLength;
					curLength=1;
					maxIndex=stIndex;
					stIndex=i;
					continue;
				}
				break;
			}
			
			}
//			//print result
//			for (int i = maxIndex; i < maxIndex+maxLength; i++) {
//				System.out.print(" "+arr[i]);
//			}
//			System.out.println();
			System.out.println(maxLength+maxIndex-maxIndex);
		}
	}

}

/*
String splitter = "(-?\\d+)";
Pattern pattern = Pattern.compile(splitter);
Matcher matcher = pattern.matcher(input.nextLine());
while (matcher.find()) {
	System.out.println(matcher.group());
}*/