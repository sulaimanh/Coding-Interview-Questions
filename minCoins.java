import java.util.*;

/**
 *
 * @author sulaimanhamouda
 *
 * Assignment Instructions:
 *	Find minimum number of coins that make a given value
 *  Input: coins[] = {25, 10, 5}, Change Needed = 30
 *  Output: Minimum coins required is 2
 *
 */


public class minCoins{

	public static void main(String []args){

		// - These are the coins we have
		int coins[] =  {9, 6, 5, 1}; 
		// - n represents the size of the array
        int n = coins.length; 
        // - change represents the change needed
        int change = (int) (Math.random() * 50);
        System.out.println("Minimum coins required is "+ minCoins(coins, n, change));
	}

    public static int minCoins(int coins[], int n, int change) 
    { 
       // - If change is zero, then we will return 0 
       	if(change == 0) 
       		return 0; 
       
       	int fin = Integer.MAX_VALUE; 
       	int x;
       	// - Here, we will try every coin
       	for(int i=0; i < n; i++){ 
         	if (coins[i] <= change){ 
            	x = minCoins(coins, n, change-coins[i]);

            	if (x != Integer.MAX_VALUE && x + 1 < fin) 
                	fin = x + 1; 
        	} 
       	} 
       	return fin; 
    }

}