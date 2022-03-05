package com.nyu.oa.csico;

/**
 *     In the game of chess, the queen can attack an opponent if the piece is located in the same row,same column, or same diagonal.
 *
 *     Write a program that takes the position of the queen and position of the opponent plece on an empty chessboard and determine if the queen may attack the piece.
 *
 *     Input
 *     The first line of the input consists of an integer cord_x1, representing the x coordinate of the queen;
 *     The second line of the input consists of an integer cord_y1, representing the x coordinate of the queen;
 *     The third line of the input consists of an integer cord_x2, representing the x coordinate of the opponent piece;
 *     The fourth line of the input consists of an integer cord_y2, representing the y coordinate of the opponent piece.
 *
 *     Output
 *     Print a sting "Yes" if the queen can attack the opponent piece. Otherwise, print "No"
 *
 *     Examples
 *
 *     Example1:
 *     Input:
 *     4
 *     5
 *     6
 *     7
 *     Output:
 *     Yes
 *     Explanation:
 *     When the queen is located at position (4 5) and the opponent piece is located at position (6 7), the queen may attack the piece in a diagonal attack.
 *
 *     Example 2:
 *     Input:
 *     1
 *     1
 *     3
 *     2
 *     output:
 *     No
*/
public class QueenAttack {
    static boolean canQueenAttack(int qR, int qC,
                                  int oR, int oC)
    {
        // If queen and the opponent
        // are in the same row
        if (qR == oR)
            return true;

        // If queen and the opponent
        // are in the same column
        if (qC == oC)
            return true;

        // If queen can attack diagonally
        if (Math.abs(qR - oR) == Math.abs(qC - oC))
            return true;

        // Opponent is safe
        return false;
    }

    // Driver code
    public static void main(String[] args)
    {
        int qR = 4, qC = 5;
        int oR = 6, oC = 7;
        if (canQueenAttack(qR, qC, oR, oC))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
