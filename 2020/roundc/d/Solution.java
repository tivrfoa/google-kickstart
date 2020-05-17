import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			TaskD solver = new TaskD();
			solver.solve(t, in, out);
		}
        out.close();
    }

    static class TaskD {

		private int query(int[] a, int l, int r) {
			int sum = 0;
			boolean isPlus = true;
			for (int i = l, t = 1; i <= r; ++i, ++t) {
				if (isPlus)	sum += a[i] * t;
				else sum -= a[i] * t;
				isPlus = !isPlus;
			}

			return sum;
		}

        public void solve(int testNumber, InputReader in, PrintWriter out) {
			int ans = 0;
            int n = in.nextInt();
            int q = in.nextInt();
            int[] a = new int[n];

			for (int i = 0; i < n; ++i) a[i] = in.nextInt();

			while (q-- > 0) {
				char c = in.next().charAt(0);
				int i = in.nextInt();
				int j = in.nextInt();

				if (c == 'Q') {
					ans += query(a, --i, --j);
				} else {
					a[--i] = j;
				}
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


