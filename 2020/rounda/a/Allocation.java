
import java.util.*;

import static java.lang.System.out;

/*
3
4 100
20 90 40 90
4 50
30 30 10 10
3 300
999 999 999

*/
class Solution {
	
	private static Scanner sc;
	
	private static int[] costs = new int[100000];
	
	public static void main(String[] args) throws Exception {
		sc = new Scanner(System.in);		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; ++t) {
			solve(t);
		}
		
		sc.close();
	}
	
	private static int ni() {
		return sc.nextInt();
	}
	
	private static void solve(int t) {
		int N = sc.nextInt();
		int B = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			costs[i] = ni();
		}
		
		Arrays.parallelSort(costs, 0, N);
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (B < costs[i]) break;
			
			B -= costs[i];
			++ans;
		}
		
		out.printf("Case #%d: %d\n", t, ans);
	}

}
