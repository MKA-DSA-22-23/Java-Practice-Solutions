import java.util.*;
public class PowerSum {
	public static int power;
	public static int target;
		
	public static int powerSumHelper(ArrayList<ArrayList<Integer>> allSum, ArrayList<Integer> allNums, int mx, int count) {
		for (int i = allSum.size()-1; i>=0; i--) {
			int sm = 0;
			for (int j: allSum.get(i)) {
				sm += Math.pow(j, power);
			}
			if (sm == target) {
				count++;
				allSum.remove(i);
			}
		}
		if (allNums.size() == 0) return count;
		int startLen = allSum.size();
		for (int i = allNums.size()-1; i>=0; i--) {
			for (int j = 0; j < startLen; j++) {
				ArrayList<Integer> newCurr = new ArrayList<Integer>(allSum.get(j));
				newCurr.add(allNums.get(i));
				allSum.add(newCurr);
			}
			allNums.remove(allNums.size() - 1);
			return powerSumHelper(allSum, allNums, mx, count);
		}
		return count;
	}
			
	public static int powerSum() {
		int mx = (int) (Math.pow(target, 1.0/power));
		ArrayList<Integer> allNums = new ArrayList<Integer>();
		for (int i = 1; i <= mx; i++) allNums.add(i);
		ArrayList<ArrayList<Integer>> allSums = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> first = new ArrayList<Integer>();
		allSums.add(first);
		return powerSumHelper(allSums, allNums, mx, 0);
	}
		
		
		
	
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter target: ");
		target = in.nextInt();
		System.out.println();
		System.out.print("Enter power: ");
		power = in.nextInt();
		System.out.println();
		System.out.println(powerSum());
	}
}
