package com.nyu.oa.csico;

/**
 * There is a set of N jars. The jars contain differing numbers of chocolates. Some of the jars may be empty. Andrew may
 * pick multiple jars but he may not pick any jar that is adjacent to a jar that he has already picked.
 *
 * Write an algorithm to calculate the maximum number of chocolates that Andrew may collect by picking jars.
 *
 * Input
 * The first line of the input consists of an integer - choco_size, representing the number of jars of chocolates (N).
 * The second line of the input consists of N space-separated integers - choco, representing the number of chocolates in each jar.
 * Output
 * Print an integer representing the maximum number of chocolates that Andrew may collect.
 *
 * Constraints
 * 1 < choco_size < 103
 * -10^5 ≤ choco[i] ≤ 10^5; where is representing the index of the jars of chocolate.
 * 0 ≤ i ≤ choco_size
 *
 * Example
 * Input:
 * 6
 * 5 30 99 60 5 10
 * Output:
 * 114
 * Explanation
 * Andrew picks from the 1st(5), 3rd(99), and 6th jars(10).
 */
public class JarsofChocolates {
}
