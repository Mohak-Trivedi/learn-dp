// Tutorial link: https://www.desiqna.in/dp2

/*
Problem:
 Given an array of integers(positive as well as negative) ,select some elements from this array(select a subset) such that:-

1. Sum of those elements is maximum(Sum of the subset is maximum) .

2. No two elements in the subset should be consecutive.

Example :- {2,4,6,7,8}

Answer:- {2+6+8=16}
*/

// Approach: TC: O(N),  SC: O(N)
// dp[i] -> Max Sum of Subset
// At each i: Max of:
// 1. dp[i - 1] i.e. including current element in subset
// 2. dp[i - 1] + a[i] i.e. excluding current element in subset

import java.util.*;

public class Tut2SubsetSum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n + 1]; // 1-based indexing
        for (int i = 1; i <= n; i++) {
            a[i] = scn.nextInt();
        }

        int[] dp = new int[n + 1];
        int low = 0; // empty subset sum (better to keep empty instead of -ve sum)
        dp[1] = Math.max(a[1], low);
        dp[2] = Math.max(dp[1], Math.max(a[2], 0));
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] + a[i]);
        }

        System.out.println(dp[n]);
        return;
    }
}
