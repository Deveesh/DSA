package searching;

import java.util.*;

public class LinearSearch {
	
	public static void main(String[] args) {
		try {
		breakupApp();
		}catch(Exception e) {
			
		}
	}
	
	private static void breakupApp() throws NoSuchElementException{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] freq = new int[31];
		for(int i=0; i<freq.length; i++) {
			freq[i] = -1;
		}
		
		for(int i=0; i<n; i++) {
			String rec = scan.next();
			String msg = scan.nextLine();
			boolean msgIsFromG = rec.charAt(0) == 'G' ? true : false;
			
			for(String word : msg.split(" ")) {
				if(word.length() == 0) {
					continue;
				}
				
				if(word.length() <= 2) {
					if(isNumber(word)) {
						int number = Integer.parseInt(word);
						if(msgIsFromG) {
							freq[number] += 2;
						}else {
							freq[number] += 1;
						}
					}
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		for(int i=1; i<freq.length; i++) {
			if(max < freq[i]) {
				max = freq[i];
				maxIndex = i;
			}
		}
		
		if(maxIndex == 19 || maxIndex == 20) {
			System.out.println("Date");
			return;
		}
		
		if(max == -1) {
			System.out.println("No Date");
			return;
		}
		
		for(int i=1; i<freq.length; i++) {
			for(int j=i+1; j<freq.length; j++) {
				if(freq[i] == freq[j] && freq[i] != -1) {
					System.out.println("No Date");
					return;
				}
			}
		}
		System.out.println("Date");
	}
	
	private static boolean isNumber(String str) {	
		if(str.length() == 1) {
			char units = str.charAt(0);
			if(units >= 49 && units <= 57) {
				return true;
			}else {
				return false;
			}
		}else {
			char units = str.charAt(0);
			char tenths = str.charAt(1);
			
			if(units >= 49 && units <= 57 && tenths >= 49 && tenths <= 57) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	private static void easySumSetProblem() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int maxA = Integer.MIN_VALUE, minA = Integer.MAX_VALUE;
		HashSet<Integer> setA = new HashSet<Integer>();
		for(int i=0; i<n; i++) {
			int inp = scan.nextInt();
			if(inp > maxA) {
				maxA = inp;
			}
			if(inp < minA) {
				minA = inp;
			}
			setA.add(inp);
		}
		
		int m = scan.nextInt();
		
		int maxB = Integer.MIN_VALUE, minB = Integer.MAX_VALUE;
		HashSet<Integer> setB = new HashSet<Integer>();
		for(int i=0; i<m; i++) {
			int inp = scan.nextInt();
			if(inp > maxB) {
				maxB = inp;
			}
			if(inp < minB) {
				minB = inp;
			}
			setB.add(inp);
		}
		
		int lowerLimit = minB - minA;
		int upperLimit = maxB - maxA;
		
		for(int i=lowerLimit; i<=upperLimit; i++) {
			boolean isValid = true;
			for(Integer a : setA) {
				if(!setB.contains(i + a)) {
					isValid = false;
					break;
				}
			}
			if(isValid) {
				System.out.print(i + " ");
			}
		}
	}
	
	private static void monkTakesAWalk() {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		
		while(t-- > 0) {
			String str = scan.next();
			int ans = 0;
			for(int i=0; i<str.length(); i++) {
				if(isVowel(str.charAt(i))) {
					ans++;
				}
			}
			System.out.println(ans);
		}
	}
	
	private static boolean isVowel(char ch) {
		if(ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || 
				ch == 'u' || ch == 'U') {
			return true;
		}
		return false;
	}
	
	private static void wetClothes() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int g = scan.nextInt();
		
		int[] times = new int[n];
		for(int i=0; i<n; i++) {
			times[i] = scan.nextInt();
		}
		
		int[] dryTime = new int[m];
		for(int i=0; i<m; i++) {
			dryTime[i] = scan.nextInt();
		}
		
		int maxInterval = Integer.MIN_VALUE;
		for(int i=1; i<times.length; i++) {
			if(times[i] - times[i-1] > maxInterval) {
				maxInterval = times[i] - times[i-1];
			}
		}
		
		int ans = 0;
		for(int i=0; i<dryTime.length; i++) {
			if(dryTime[i] <= maxInterval) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}
