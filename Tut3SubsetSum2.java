// Tutorial: https://www.desiqna.in/dp3

/*
Problem: 
We are given ‘2’ arrays . Select some elements from both of these arrays (select a subset) such that:-

--->1. Sum of those elements is maximum(Sum of the subset is maximum).

--->2. No 2 elements in the subset should be consecutive.(Note:-If you select, say the 5th element from Array-1, then you are not allowed to select 4th element from either Array-1 or Array-2 nor are you allowed to select the 5th element from Array -2 all of them are considered consecutive :-) )

Example:->

Array 1(a1) : {1,5,3,21234}

Array 2(a2) : {-4509,200,3,40}

Answer:- (200+21234=21434)
*/

//
// dp[i] = max sum for subset till index i considering 1-based indexing.
// At each index, we have 2 choices, choose the one that maximizes the subset sum:
// 1. Include current ith element: Need to remove previous consecutive element, and then add ith element either from array1 or array2 (whichever maximizes hte subset sum). dp[i - 2] + Math.max(a[i], b[i])
// 2. Exclude current ith element: dp[i - 1]

import java.util.*;

public class Tut3SubsetSum2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scn.nextInt();
        }

        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            b[i] = scn.nextInt();
        }

        int[] dp = new int[n];
        int low = 0; // least sum: consider empty subset
        dp[1] = Math.max(Math.max(a[1], b[1]), low);
        dp[2] = Math.max(Math.max(a[2], b[2]), dp[1]);
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(a[i], b[i]) + dp[i - 2], dp[i - 1]);
        }

        System.out.println(dp[n]);

        return;
    }
}
