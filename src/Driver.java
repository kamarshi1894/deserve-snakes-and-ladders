import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("Enter board size");
        int boardSize = sc.nextInt();

        System.out.println("Enter dice strategy : normal or crooked");
        String diceStrategy = sc.next();

        System.out.println("Enter number of dice faces");
        int numDiceFaces = sc.nextInt();

        System.out.println("Enter number of max moves");
        int maxNumMoves = sc.nextInt();

        Game game = new Game(boardSize, diceStrategy, numDiceFaces);

        while (game.getNumberOfMoves() <= 10 && game.getPosition() < boardSize) {
            System.out.println("Enter action :\n" +
                               "1 to add a snake\n" +
                               "2 to make a move");

            String action = sc.next();

            if(action.equals("1")) {
                System.out.println("Enter start position of snake");
                int start = sc.nextInt();
                System.out.println("Enter end position of snake");
                int end = sc.nextInt();

                game.addSnake(start, end);
            } else {
                game.makeMove();
            }
        }
    }
}
