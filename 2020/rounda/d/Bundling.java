
import java.util.*;

import static java.lang.System.out;

/*
 * Based on William Lin solution 
3
2 2
KICK
START
8 2
G
G
GO
GO
GOO
GOO
GOOO
GOOO
6 3
RAINBOW
FIREBALL
RANK
RANDOM
FIREWALL
FIREFIGHTER

*/
class Solution {
	
	private static int n, k;

	// frequency of each char in each position for all words
	private static int[][] c = new int[2_000_001][26];

	// number of words with i length
	private static int[] cnt = new int[2_000_001];
	private static long ans;
	
	private static void dfs(int u, int d) {
		for (int v = 0; v < 26; v++) {
			if (c[u][v] > 0) {
				dfs(c[u][v], d+1); // Use (char) (v+'A') to found out the letter
				cnt[u] += cnt[c[u][v]];
			}
		}
		
		while (cnt[u] >= k) {
			cnt[u] -= k;
			ans += d;
		}			
	}	
	
	private static void solve(int t) {
		n = ni();
		k = ni();
		int m = 1;
		
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			int u = 0;
			for (int j = 0; j < s.length(); j++) {
				char d = s.charAt(j);
				if (c[u][d-'A'] == 0)
					c[u][d-'A'] = m++;
				u = c[u][d-'A'];
			}
			++cnt[u];
		}

		ans = 0;
		dfs(0, 0);
		
		out.printf("Case #%d: %d\n", t, ans);

		for (int i = 0; i < c.length; i++) Arrays.fill(c[i], 0);
		Arrays.fill(cnt, 0);		
	}
	
	// --------------------------------------------------------
	
	private static int ni() {
		return sc.nextInt();
	}
	
	private static Scanner sc;
	
	public static void main(String[] args) throws Exception {
		sc = new Scanner(System.in);		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; ++t) {
			solve(t);
		}
		
		sc.close();
	}
}
