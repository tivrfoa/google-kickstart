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
			TaskB solver = new TaskB();
			solver.solve(t, in, out);
		}
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
			String order = "";
			boolean isStable = true;
            int r = in.nextInt();
            int c = in.nextInt();
            char[][] grid = new char[r][c];
			boolean[][] up = new boolean[26][26];
			HashSet<Character> set = new HashSet<>();
			for (int i = 0; i < r; ++i) {
				grid[i] = in.next().toCharArray();
				if (i > 0) {
					for (int j = 0; j < c; ++j) {
						set.add(grid[i][j]);
						if (grid[i][j] == grid[i-1][j]) continue;
						up[grid[i][j] - 'A'][grid[i-1][j] - 'A'] = true;
						if (up[grid[i-1][j] - 'A'][grid[i][j] - 'A']) {
							isStable = false;
						}
					}
				}
			}

			if (!isStable) {
				out.printf("Case #%d: -1\n", testNumber);
				return;
			}

			char rootChar = 0;
			// find root
			for (char l : set) {
				int i = l - 'A';
				boolean isRoot = true;
				for (int j = 0; j < 26; ++j) {
					if (i == j) continue;
					if (up[j][i]) {
						isRoot = false;
						break;
					}
				}
				if (isRoot) {
					rootChar = (char) (i + 'A');
					break;
				}
			}
			// System.err.println("Root char: " + rootChar);

			order = findOrder(up, rootChar - 'A', "", set.size());

	    	out.printf("Case #%d: %s\n", testNumber, order);
        }

		private String findOrder(boolean[][] up, int root, String order, int size) {
			order += (char) (root + 'A');
			if (order.length() == size) return order;

			String tmp = order;
			for (int j = 0; j < 26; ++j) {
				if (up[root][j]) {
					tmp = findOrder(up, j, tmp, size);
					if (tmp != null && tmp.length() == size) return tmp;
				}
			}
			return order;
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


