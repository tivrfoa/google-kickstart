
import java.util.*;

import static java.lang.System.out;

/*
 * tmwilliamlin168 
2
2 4 5
10 10 100 30
80 50 10 50
3 2 3
80 80
15 50
20 10

*/
class Solution {
	
	private static Scanner sc;
	
	private static int n, k, p;
	private static int[][] a = new int[50][30];
	private static int[][] dp = new int[51][1501];

	public static void main(String[] args) throws Exception {
		sc = new Scanner(System.in);		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; ++t) {
			solve(t);
		}
		
		sc.close();
	}
	
	private static void solve(int t) {
		n = sc.nextInt();
		k = sc.nextInt();
		p = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		dp[0][0] = 0;
		
		for (int i = 0; i < n; i++) {
			dp[i+1] = Arrays.copyOf(dp[i], dp[i].length);
			
			for (int j = 0, s = 0; j < k; j++) {
				a[i][j] = sc.nextInt();
				s += a[i][j];
				// use j+1 plates
				for (int l = 0; l+j+1 <= p; l++) {
					dp[i+1][l+j+1] = Math.max(dp[i][l]+s, dp[i+1][l+j+1]);
				}
			}
		}
		
		out.printf("Case #%d: %d\n", t, dp[n][p]);
	}

}
