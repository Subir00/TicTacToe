package TicTac;

import java.util.Arrays;

public class Board
{
    char[][] board;
    private char p1Symbol;
    private char p2Symbol;
    int boardSize = 3;
    int count;
    public static final int PLAYER1WINS = 1;
    public static final int PLAYER2WINS = 2;
    public static final int DRAW = 3;
    public static final int INCOMPLETE = 4;
    public static final int INVALIDMOVE = 5;

    public Board(char symbol1,char symbol2)
    {
        count = 0;
        board = new char[boardSize][boardSize];
        for(char[] arr: board)
        {
            Arrays.fill(arr,' ');
        }
        p1Symbol = symbol1;
        p2Symbol = symbol2;
    }

    public int move(char symbol, int i, int j)
    {
        if(i<0 || i>=boardSize || j<0 || j>=boardSize || board[i][j]!=' ')
            return INVALIDMOVE;
        board[i][j] = symbol;
        count++;

        //row
        if(board[i][0]==symbol && board[i][1]==symbol && board[i][2]==symbol)
            return symbol==p1Symbol?PLAYER1WINS:PLAYER2WINS;
        //column
        if(board[0][j]==symbol && board[1][j]==symbol && board[2][j]==symbol)
            return symbol==p1Symbol?PLAYER1WINS:PLAYER2WINS;

        //Diagonals
//        if(board[0][0]!=' ' || board[0][2]!=' ')
//        {
        if(board[0][0]==symbol && board[1][1]==symbol && board[2][2]==symbol)
            return symbol==p1Symbol?PLAYER1WINS:PLAYER2WINS;

        if(board[0][2]==symbol && board[1][1]==symbol && board[2][0]==symbol)
            return symbol==p1Symbol?PLAYER1WINS:PLAYER2WINS;
//        }

        if(count == boardSize*boardSize)
            return DRAW;
        return INCOMPLETE;
    }

    public void print()
    {
        System.out.println("_______________________");
        for (int i=0;i<boardSize;i++)
        {
            System.out.print("|");
            for (int j=0;j<boardSize;j++)
            {
                System.out.print("|"+board[i][j]+"|");
            }
            System.out.println("|");
        }
    }
}
