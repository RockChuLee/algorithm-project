package com.nyu.oa.twitter;

/**
 * There are n people standing in line to buy show tickets.Due to high demand, the venue sells
 * tickets according to the following rules:
 * <p>
 * The person at the head of the line can buy exactly one ticket and must then exit the line.
 * if a person needs to purchase additional tickets,they must re-enter the end of the line and
 * wait to be sold their next ticket(assume exit and re-entry takes zero seconds).
 * Each ticket sale takes exactly one second.
 * <p>
 * We express initial line of n people as an array, tickets = [tickets0, tickets1 ... ticketsN-1],
 * where ticketsi denotes the number of tickets person i wishes to buy. If Jesse is standing at a
 * position p in this line, find out how much time it would take for him to buy all tickets.
 * Complete the waiting time function in the editor below. It has two parameters:
 * <p>
 * An array, tickets, of n positive integers describing initial sequence of people standing in line.
 * Each ticketsi describes number of tickets that a person waiting at initial place.
 * An integer p, denoting Alex's position in tickets.
 * <p>
 * Sample Input 5 2 6 3 4 5
 * 2
 * Sample Output
 * 12
 * Sample Input 4 5 5 2 3
 * 3
 * Sample Output
 * 11
 */
//https://leetcode.com/discuss/interview-question/399445/twitter-oa-2019-intern-san-francisco
public class BuyingShowTickets {

    private int buy(int[] tickets, int p) {
        int count = tickets[p];
        for (int i = 0; i < p; i++) {
            if (tickets[i] > p) count += tickets[p];
            else count += tickets[i];
        }
        for (int i = p + 1; i < tickets.length; i++) {
            if (tickets[i] > p) count += tickets[p] - 1;
            else count += tickets[i] - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        BuyingShowTickets b1 = new BuyingShowTickets();
        int[] tickets1 = new int[]{2, 6, 3, 4, 5};
        System.out.println(b1.buy(tickets1, 2)); // return 12
        int[] tickets2 = new int[]{5, 5, 2, 3, 3};
        System.out.println(b1.buy(tickets2, 2)); // return 8
    }

//    public static void main(String[] args) {
//        System.out.println(wasteTime(new Integer[]{5, 2, 6, 3, 4, 5}, 2));
//    }
}
