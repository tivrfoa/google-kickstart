import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
        	TaskC solver = new TaskC();
	        solver.solve(t, in, out);
		}
        out.close();
    }


    static class TaskC {
		//                     sum      partialCounter
		private static HashMap<Long, Long>[] dp = new HashMap[10_000];
		private static HashSet<Long> ps = new HashSet<>();
		static {
			for (int i = 0; i < 101; ++i) {
				ps.add((long) i * i);
			}
		}

		private Long find(int[] a, int i, Long sum) {
			sum = sum + a[i];
			Long v = dp[i].get(sum);
			if (v != null) {
				return v;
			}

			long partialCounter = 0;
			if (ps.contains(sum)) partialCounter = 1;
			if (i == a.length - 1) {
				return partialCounter;
			}

			long res = find(a, i+1, sum) + partialCounter;
			dp[i].put(sum, res);

			return res;
		}

        public void solve(int testNumber, InputReader in, PrintWriter out) {
			long ans = 0;
            int n = in.nextInt();
            int[] a = new int[n];
			for (int i = 0; i < n; ++i) a[i] = in.nextInt();

			for (int i = 0; i < n; ++i) {
				dp[i] = new HashMap<>();
			}

			for (int i = 0; i < n; ++i) {
				ans += find(a, i, 0l);
			}

            out.printf("Case #%d: %d\n", testNumber, ans);
		}




    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}


