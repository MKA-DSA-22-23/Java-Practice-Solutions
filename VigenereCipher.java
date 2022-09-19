import java.util.*;

public class VigenereCipher{
	
	public static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	
	public static int[] getKey(String key) {
		int[] intKeys = new int[key.length()];
		for (int i = 0; i < key.length(); i++) {
			String curr = key.substring(i, i+1);
			intKeys[i] = alpha.indexOf(curr);			
		}
		return intKeys;
	}
	
	public static String encrypt(int[] key, String m) {
		char[] message = m.toCharArray();
		String encrypted = "";
		int posKey = 0;
		for (char l: message) {
			int e = (l-65 + key[posKey] ) % 26;
			encrypted += alpha.substring(e, e+1);
			posKey = (posKey + 1) % key.length;
		}
		return encrypted;
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your key text: (All capital letters) ");
		String k = in.next().toUpperCase();
		int[] key = getKey(k);
		System.out.println("Enter your message to encrypt:(All capital letters) ");
		String m = in.next().toUpperCase();
		String e = encrypt(key, m);
		System.out.println("Encrypted message: " + e);
		System.out.println("Decrypted message: " + m);
	}
	
	
	

}
