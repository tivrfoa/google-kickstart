import java.util.*;
import static java.lang.Math.abs;
import static java.lang.System.out;

/**
 *
 * Probability is the sum of probabilities of to enter
 * the rectangular that was removed.
 */
class Solution {

    // private static final int N = 100_000;
    private static final int N = 300;
    private static double[][] prob = new double[N][N];

    static {
        prob[0][0] = 1.0;
        for (int i = 1; i < N; ++i) {
            prob[i][0] = prob[i-1][0] / 2;
            prob[0][i] = prob[0][i-1] / 2;
        }
        for (int i = 1; i < N; ++i) {
            for (int j = 1; j < N; ++j) {
                prob[i][j] = (prob[i-1][j]/2) + (prob[i][j-1]/2);
            }
        }
    }

	private static void solve() {
	    int w = sc.nextInt();	
	    int h = sc.nextInt();	
	    int l = sc.nextInt() - 1;	
	    int u = sc.nextInt() - 1;	
	    int r = sc.nextInt() - 1;	
	    int d = sc.nextInt() - 1;

        if (u == 0 && l == 0) {
            out.println(0);
            return;
        }
        
        if (w == 1 || h == 1) {
            out.println(0);
            return;
        }

        double holeSum = 0;

        int i = u - 1;
        if (i < 0) i = 0;
        int j = l - 1;
        if (j < 0) j = 0;

        // try go down
        while (true) {
            int di = i + 1;
            if (di < h) {
                if (di >= u && di <= d && j >= l && j <= r) {
					if (j < w -1) {
						holeSum += prob[i][j] / 2;
					} else {
						holeSum += prob[i][j];
					}
                    break;
                } else {
                    if (di <= d) {
                        i = di;
                        holeSum += prob[i][j] / 2;
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }

        i = u - 1;
        if (i < 0) i = 0;
        j = l - 1;
        if (j < 0) j = 0;

        // try go right
        while (true) {
            int next = j + 1;
            if (next < w) {
                if (next >= l && next <= r && i >= u && i <= d) {
					if (i < h - 1)
						holeSum += prob[i][j] / 2;
					else
						holeSum += prob[i][j];
                    break;
                } else {
                    if (next <= r) {
                        j = next;
                        holeSum += prob[i][j] / 2;
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }


        System.out.println(1-holeSum);
	}
	
	
	private static Scanner sc;

	public static void main(String[] args) throws Exception {
		
		sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; ++t) {
            out.printf("Case #%d: ", t);
			solve();
		}
		sc.close();
	}
}



