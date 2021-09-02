import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		System.out.println("Bienvenue dans le detecteur de palindrome");
		System.out.println("Veuillez entrer un mot ou une phrase: ");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String clearedInput = nettoyerChaine(input);
		boolean isPalindrome = true;
		for(int i = 0 ; i < clearedInput.length() ; i++) {
			if(clearedInput.charAt(i) != clearedInput.charAt(clearedInput.length() - 1 - i)) {
				isPalindrome = false;
				break;
			}
		}
		if(isPalindrome) {
			System.out.println("\"" +  input  + "\" est un palindrome");
		}
		else {
			System.out.println("\"" +input + "\" n'est pas un palindrome");
		}
	}
	
	public static String nettoyerChaine(String input) {
		input = input.toLowerCase();
		input = input.replaceAll("\\s+","");
		input = supprimerAccent(input);
		input = supprimerPonctuation(input);
		return input;
	}
	
	public static String supprimerAccent(String input) {
		char[] accentE = {'é', 'è', 'ê', 'ë'};
		for(char c : accentE) {
			input = input.replace(c, 'e');
		}
		
		char[] accentA = {'à', 'â', 'ä'};
		for(char c : accentA) {
			input = input.replace(c, 'a');
		}
		
		char[] accentO = {'ö', 'ô'};
		for(char c : accentO) {
			input = input.replace(c, 'o');
		}
		
		char[] accentI = {'î', 'ï'};
		for(char c : accentI) {
			input = input.replace(c, 'i');
		}

		char[] accentU = {'ù', 'ü', 'û'};
		for(char c : accentU) {
			input = input.replace(c, 'u');
		}
		
		return input;
	}
	
	public static String supprimerPonctuation(String input) {
		input = input.replaceAll("'", "");
		input = input.replaceAll(",", "");
		input = input.replaceAll("\\.", "");
		input = input.replaceAll("\\?", "");
		input = input.replaceAll("!", "");
		input = input.replace('ç', 'c');
		return input;
	}
}
