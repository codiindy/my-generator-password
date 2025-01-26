package com.example.mygeneratepassword;

import java.util.Scanner;

public class PasswordGenerator {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			// 1. Récupérer deux mots séparément
			System.out.println("Entre ton premier mot :");
			String word1 = mixCase(scanner.nextLine());
			
			System.out.println("Entre ton deuxième mot :");
			String word2 = mixCase(scanner.nextLine());
			
			// 2. Demander la longueur totale du mdp
			System.out.print("Entre la longueur totale de ton mot de passe (min 12) : ");
			int totalLength = scanner.nextInt();
			
			if (totalLength < 12) {
				System.out.println("La longueut doit être d'au moins 12 caractères. Relance le programme.");
				return;
			}
			
			// 3. Ajouter un chiffre et un caractère spécial par mot
			String enhanceWord1 = addNumberAndSpecialChar(word1);
			String enhanceWord2 = addNumberAndSpecialChar(word2);
			
			// 4. Combiner les mots améliorés
			String password = combineWords(enhanceWord1, enhanceWord2, totalLength);
			
			// Afficher le mot de passe généré
			System.out.println("Ton mot de passe est : " + password);
		}

	}
	
	// Mélanger majuscules et minuscules
	public static String mixCase(String word) {
		StringBuilder mixed = new StringBuilder();
		for (char c : word.toCharArray()) {
			mixed.append(Math.random() > 0.5 ? Character.toUpperCase(c) : Character.toLowerCase(c));
		}
		return mixed.toString();
	}
	
	// Ajouter un chiffre et un caractère spécial dans le mot
	public static String addNumberAndSpecialChar(String word) {
		String digits = "0123456789";
		String specialChars = "!@#$%^&*()";
		
		char randomDigit = digits.charAt((int) (Math.random() * digits.length()));
		char randomSpecial = specialChars.charAt((int) (Math.random() * specialChars.length()));
		
		int specialPosition = (int) (Math.random() * word.length());
		int digitPosition = (int) (Math.random() * (word.length() + 1));
		
		StringBuilder enhancedWord = new StringBuilder(word);
		enhancedWord.insert(specialPosition, randomSpecial);
		enhancedWord.insert(digitPosition, randomDigit);
		return enhancedWord.toString();
	}
	
	// Combiner les mots pour atteindre la longueur totale
	public static String combineWords(String word1, String word2, int totalLength) {
		StringBuilder password = new StringBuilder();
		
		String specialChars = "!@#$%^&*()";
		char special1 = specialChars.charAt((int) (Math.random() * specialChars.length()));
		char special2 = specialChars.charAt((int) (Math.random() * specialChars.length()));
		char special3 = specialChars.charAt((int) (Math.random() * specialChars.length()));
		
		password.append(special1).append(word1).append(special2).append(word2).append(special3);
		
		// Compléter avec des caractères aléatoires si nécessaire
        String allPossibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        while (password.length() < totalLength) {
            int randomIndex = (int) (Math.random() * allPossibleChars.length());
            password.append(allPossibleChars.charAt(randomIndex));
        }
        
        return password.substring(0, totalLength); // s'assurer de respecter la longueur totale
	}

}

