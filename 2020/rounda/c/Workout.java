
import java.util.*;

import static java.lang.System.out;

/*
 * 
4
3 1
100 200 230
5 2
10 13 15 16 17
5 6
9 10 20 26 30
8 3
1 2 3 4 5 6 7 10

*/
class Solution {
	
	private static Scanner sc;
	
	private static int[] min = new int[100_000];
	

	public static void main(String[] args) throws Exception {
		sc = new Scanner(System.in);		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; ++t) {
			solve(t);
		}
		
		sc.close();
	}
	
	private static void solve(int t) {
		int N = ni();
		int K = ni();
		
		for (int i = 0; i < N; i++) {
			min[i] = ni();
		}
		
		int ans = 0;
		
		while (true) {
		
			break;
		}
		
		out.printf("Case #%d: %d\n", t, ans);
	}
	
	private static int ni() {
		return sc.nextInt();
	}

}
