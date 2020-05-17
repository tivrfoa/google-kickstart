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

public class Solution0 {
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

	private static HashSet<Integer> ps = new HashSet<>();
	static {
		for (int i = 0; i < 101; ++i) {
			ps.add(i * i);
		}
	}

    static class TaskC {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
			int ans = 0;
            int n = in.nextInt();
            int[] a = new int[n];
			for (int i = 0; i < n; ++i) a[i] = in.nextInt();

			for (int i = 0; i < n; ++i) {
				int sum = a[i];
				if (ps.contains(sum)) ++ans;
				for (int j = i+1; j < n; ++j) {
					sum += a[j];
					if (ps.contains(sum)) ++ans;
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


