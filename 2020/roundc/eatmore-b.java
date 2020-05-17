import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class EatmoreB {

	// Discuss this round on Codeforces: https://codeforces.com/

	static void solve() throws Exception {
		int r = scanInt(), c = scanInt();
		char w[][] = new char[r][];
		boolean have[] = new boolean[26];
		for (int i = 0; i < r; i++) {
			w[i] = scanString().toCharArray();
			for (int j = 0; j < c; j++) {
				have[w[i][j] - 'A'] = true;
			}
		}
		int rem = 0;
		for (int i = 0; i < 26; i++) {
			if (have[i]) {
				++rem;
			}
		}
		char ans[] = new char[26];
		int ansLen = 0;
		rem: while (rem > 0) {
			i: for (int i = 0; i < 26; i++) {
				if (!have[i]) {
					continue;
				}
				for (int j = 0; j < r; j++) {
					for (int k = 0; k < c; k++) {
						if (w[j][k] != i + 'A') {
							continue;
						}
						if (j != r - 1 && w[j + 1][k] != i + 'A' && have[w[j + 1][k] - 'A']) {
							continue i;
						}
					}
				}
				ans[ansLen++] = (char) (i + 'A');
				have[i] = false;
				--rem;
				continue rem;
			}
			printCase();
			out.println(-1);
			return;
		}
		printCase();
		out.write(ans, 0, ansLen);
		out.println();
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
