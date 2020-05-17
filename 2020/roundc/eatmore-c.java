import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class EatmoreC {

	// Discuss this round on Codeforces: https://codeforces.com/

	static void solve() throws Exception {
		int n = scanInt();
		int as[] = new int[n + 1];
		int min = 0, max = 0;
		for (int i = 0; i < n; i++) {
			as[i + 1] = as[i] + scanInt();
			min = min(min, as[i + 1]);
			max = max(max, as[i + 1]);
		}
		int cl = max - min + 1;
		int cnt[] = new int[cl];
		long ans = 0;
		for (int i = n; i >= 0; i--) {
			for (int v = as[i] - min, d = 1; v < cl; v += d, d += 2) {
				ans += cnt[v];
			}
			++cnt[as[i] - min];
		}
		printCase();
		out.println(ans);
	}

	static int scanInt() throws IOException {
		return parseInt(scanString());
	}

	static long scanLong() throws IOException {
		return parseLong(scanString());
	}

	static String scanString() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}

	static void printCase() {
		out.print("Case #" + test + ": ");
	}

	static void printlnCase() {
		out.println("Case #" + test + ":");
	}

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer tok;
	static int test;

	public static void main(String[] args) {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			int tests = scanInt();
			for (test = 1; test <= tests; test++) {
				solve();
			}
			in.close();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
			exit(1);
		}
	}
}