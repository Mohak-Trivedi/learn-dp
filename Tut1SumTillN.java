// Tutorial: https://www.desiqna.in/dynamic-programming

// Problem: We are given an array of integers(a[n]) . We are given multiple queries of the form : (1, i) which means we need to output the sum of all numbers from index- ‘1’ to index ‘i’ of the array.

// Approach: TC: O(N), SC: O(N)
// Create dp[] such that dp[i] = sum[1, i]

public class Tut1SumTillN {
    public static void main(String[] args) {
        int n = 5;
        int a[] = new int[] { 6, 7, 3, 2, 2 };

        int[] dp = new int[n + 1];
        dp[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            dp[i] = dp[i - 1] + a[i];
        }

        int q = 4; // number of queries
        int[] w = new int[] { 0, 3, 4, 2 }; // query array
        for (int i = 0; i < q; i++) {
            int query = w[i];
            System.out.println(dp[query]); // answering each query in O(1)
        }

        return;
    }
}
