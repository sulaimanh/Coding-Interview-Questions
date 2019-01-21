// - Sulaiman Hamouda
// - fruits.java

/*
	You can see the question for this code here: 
	https://cop4516.ucfprogrammingteam.org/index.php?option=com_sparta&controller=problems&task=download&format=raw&problemID=8
*/
import java.util.*;

public class fruit{
	public static void main(String [] args){
		Scanner stdin = new Scanner(System.in);

		// - n represents the number of sets
		int n = stdin.nextInt();

		// - Here, we will go through each set
		for(int j = 0; j < n; j++){
			// - d represents the number of days
			int d = stdin.nextInt();

			// - in this array, we will store each number of fruits sold for that day
			int [] arr = new int[d];
			for(int i = 0; i < d; i++){
				arr[i] = stdin.nextInt();
			}
			// - This is where we will calculate the number of fruits needed and the remainder
			countMinAndMax(arr, d);
		}
	}

	// I need to see how I can figure out how to find the maximum number of fruits ever stored in a given day

	public static void countMinAndMax(int [] arr, int d){
		// - We will right away start off the minimum number of fruits needed with the first day
		int min = arr[0];

		// - This array will store the number of fruits left over, we want to find the max number of fruits 
		//		left over in a day
		int [] findMax = new int[d];
		// - We will set the first index to 0 because we have zero left overs so fat
		findMax[0] = 0;

		// - This is just a temporary variable
		int temp;

		// - In this for loop, we will determine the least amount of fruits needed for each day and we also 
		//		determine the max number of fruits left over.
		for(int i = 1; i < d; i++){
			// - In the first for loop, if the current number of fruits sold is greater than the current minimum(min)
			//		of fruits needed plus the left over fruits from the previous day, then we will need a new min
			//		value, that which is greater.
			if(arr[i] > (min + findMax[i - 1])){
				temp = min;
				// - In this while loop, we are going to increase min and the left over from the previous day until we
				//		are equal to or greater than the current day
				while(temp < arr[i]){
					min += 1;
					findMax[i - 1] += 1;
					temp = min + findMax[i - 1];
				}
				// - Here, we need to update the left over from the previous day.
				findMax[i - 1] = min - arr[i - 1];
				// - Here, we need to update the left over for the current day.
				findMax[i] = (min + findMax[i-1]) - arr[i];
			}
			// - If the current number of fruits sold is less than min, then we will just have to update the number
			//		of left overs for the current day
			else if(arr[i] < min){
				temp = (min + findMax[i - 1]) - arr[i];
				findMax[i] = temp;
			}
		}

		// - Here, we simply find the max number of left overs for a given day
		int max = findMax[0];
		for(int i = 1; i < d; i++){
			if(findMax[i] > max)
				max = findMax[i];
		}

		// - Here, we print the results.
		System.out.println(min+ " " + max);
	}
}


