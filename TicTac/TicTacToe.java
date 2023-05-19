package TicTac;

import java.util.Scanner;

public class TicTacToe
{
    Board board;
    Player player1,player2;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        t.start();
        System.out.println("\nDo you Want to play again");
        System.out.println("Y - yes || N - no");
        char ch = sc.next().charAt(0);
        while (ch == 'y' || ch =='Y')
        {
            t.start();
            System.out.println("\nDo you Want to play again");
            System.out.println("Y - yes || N - no");
            ch = sc.next().charAt(0);
        }
        if(ch!='n' && ch!='N') {
            System.out.println("You have entered a INVALID choice.....");
            System.out.println("I guess you don't want to play");
        }
    }

    private void start()
    {
        //Player 1
        System.out.println("Enter player1 name");
        String name = sc.nextLine();
        System.out.println("Enter player1 symbol");
        char symbol = sc.next().charAt(0);
        player1 = new Player(name,symbol);

        //Player 2
        sc.nextLine();
        System.out.println("Enter player2 name");
        name = sc.nextLine();
        System.out.println("Enter player2 symbol");
        symbol = sc.next().charAt(0);
        player2 = new Player(name,symbol);

        //Board
        board = new Board(player1.getSymbol(), player2.getSymbol());
        game();
    }

    private void game()
    {
        boolean flag = true;
        int resp = board.INCOMPLETE;
        while(resp==board.INCOMPLETE || resp==board.INVALIDMOVE)
        {
            if(flag)
            {
                System.out.println(player1.getName() + " - " + "(" + player1.getSymbol() + ")");
                System.out.println("Enter pos:-");
                System.out.println("Enter row number -");
                int i = sc.nextInt();
                System.out.println("Enter col number -");
                int j = sc.nextInt();
                resp = board.move(player1.getSymbol(),i,j);
                if(resp == board.INVALIDMOVE)
                {
                    System.out.println("Invalid move try again");
                    continue;
                }
            }
            else
            {
                System.out.println(player2.getName() + " - " + "(" + player2.getSymbol() + ")");
                System.out.println("Enter pos:-");
                System.out.println("Enter row number -");
                int i = sc.nextInt();
                System.out.println("Enter col number -");
                int j = sc.nextInt();
                resp = board.move(player2.getSymbol(),i,j);
                if(resp == board.INVALIDMOVE)
                {
                    System.out.println("Invalid move try again");
                    continue;
                }
            }
            flag = !flag;
            board.print();
        }
        if(resp==board.PLAYER1WINS || resp == board.PLAYER2WINS)
            System.out.println("Player"+resp+"wins!!!!!!!");
        if(resp==board.DRAW)
            System.out.println("Match Draw NO ONE WINS............");
    }
}
