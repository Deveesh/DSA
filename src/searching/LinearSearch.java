package searching;

import java.util.*;

public class LinearSearch {
	
	public static void main(String[] args) {
		wetClothes();
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
