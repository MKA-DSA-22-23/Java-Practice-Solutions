import java.util.*;

public class Practice {
	// only positive input
	public static int sumIntegers(int n) {
		if (n <= 1) { return n; }
		return n + sumIntegers(n-1);
	}
	// only positive input 
	// 0! = 1
	public static int factorial(int n) {
		if (n <= 1) { return 1; }
		return n * factorial(n-1);
	}
	
	// non negative powers
	public static int exponent(int base, int pow) {
	//	if (pow == 1) return base; //not technically necessary
		if (pow <= 0) return 1;
		return base * exponent(base, pow - 1);
	}
	
	//negative and positive powers
	public static int exponentPosAndNeg(int base, int pow) {
		if (pow == 0) return 1;
		if (pow > 0) return base * exponentPosAndNeg(base, pow -1);
		return base / exponentPosAndNeg(base, pow + 1);
	}
	
	public static int fibonacci(int n) {
		if (n <= 1) { return n; };
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public static String decToBin(int dec) {
		if (dec < 2) { return dec + ""; }
		return decToBin(dec/2) + "" + dec%2;
	}
	
	public static int decToBinINT(int dec) {
		if (dec < 2) { return dec; }
		return decToBinINT(dec/2) * 10 + dec %2;
	}
	
	public static int binToDec(int bin) {
		if (bin < 2) return bin;
		return 2 * binToDec(bin/10) + bin % 10;
	}
	public static int binToDecSTRING(String bin) {
		if (bin.length() <= 1) { return Integer.valueOf(bin); }
		int val = Integer.valueOf(bin);
		return 2 * binToDecSTRING(Integer.toString(val / 10)) + val % 10;
	}
	
	private static ArrayList<String> substringHelper(String s, ArrayList<String> strs){
		if (s.length() == 1) {
			strs.add(s);
			return strs;
		}
		for (int i = 1; i < s.length()+1; i++) {
			strs.add(s.substring(0, i));
		}
		System.out.println(strs);
		return substringHelper(s.substring(1), strs);
	}
	public static ArrayList<String> allPossibleSubstring(String s){
		ArrayList<String> strs = new ArrayList<String>();
		if (s.length() == 0) return strs;
		return substringHelper(s, strs);
	}
	
	public static void main(String[] args) {
		System.out.println(allPossibleSubstring("abc"));
	}
	
}
