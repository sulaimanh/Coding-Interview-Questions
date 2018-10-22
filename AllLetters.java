import java.util.*;


/*

	A pangram is a sentence that contains every single letter of the alphabet at least once. 
	For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z 
	at least once (case is irrelevant).

	Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.

*/

public class AllLetters{



	public static void main(String [] args){
		String sent = "HELLO";
		int x = 'z'-'a';
		
		String pangram1 = "m vtucz ds onkrg hblfx pyqa we";
		System.out.println(check(pangram1));
	}


	public static boolean check(String sentence){
		boolean [] arr = new boolean[26];

		int size = sentence.length();
		String x = sentence.toLowerCase();
		for(int i = 0; i < size; i ++){
			char letter = x.charAt(i);
			if(letter - 'a' <= 25 && letter - 'a' >= 0)
				if(arr[letter-'a'] == false)
					arr[letter-'a'] = true;
		}

		for(int s = 0; s < 26; s++){
			if(arr[s] == false)
				return false;
		}

		return true;
	}

}