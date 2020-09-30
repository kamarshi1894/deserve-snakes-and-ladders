import dice.Dice;
import dice.EvenBiasedDice;
import dice.FairDice;

public class Game {
    private final Board board;
    private final Dice dice;

    private int position = 0;
    private int numberOfMoves = 0;

    public Game(int boardSize, String diceStrategy, int numDiceFaces) {
        this.board = new Board(boardSize);
        this.dice = getDice(diceStrategy, numDiceFaces);
    }

    private Dice getDice(String strategy, int numDiceFaces) {
        if (strategy.equals("crooked")) {
            return new EvenBiasedDice(numDiceFaces);
        } else {
            return new FairDice(numDiceFaces);
        }
    }

    public void makeMove() {
        int tmp = position;
        position = board.move(position, dice.roll());

        if (position == board.getSize()) {
            System.out.println("The end of the board has been reached. " +
                    "The game has concluded");
            return;
        }

        System.out.println(String.format("moved from %s to %s", tmp, position));

        numberOfMoves++;
    }

    public void addSnake(int start, int end) {
        board.addSnake(start, end);
    }

    public int getNumberOfMoves() {
        return this.numberOfMoves;
    }

    public int getPosition() {
        return this.position;
    }

    public Board getBoard() {
        return this.board;
    }
}
