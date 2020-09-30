import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnitTests {
    private final int boardSize = 100;
    private final int numDiceFaces = 6;
    private final int maxNumberOfMoves = 10;
    private final String NORMAL = "normal";

    @Test
    void checkCrookedDiceValueIsEven() {
        System.out.println("checkCrookedDiceValueIsEven");

        Game game = new Game(boardSize, "crooked", numDiceFaces, maxNumberOfMoves);

        while (!game.getGameOver()) {
            int oldPosition = game.getPosition();
            game.makeMove();
            int newPosition = game.getPosition();

            assertEquals(0, Math.abs(newPosition - oldPosition) % 2);
        }
    }

    @Test
    void checkAdditionOfValidSnake() {
        System.out.println("checkAdditionOfValidSnake");

        Game fairDiceGame = new Game(boardSize, NORMAL, numDiceFaces, maxNumberOfMoves);

        int oldNumberOfSnakes = fairDiceGame.getBoard().getSnakesMap().size();
        fairDiceGame.addSnake(23, 15);
        int newNumberOfSnakes = fairDiceGame.getBoard().getSnakesMap().size();

        assertEquals(1, newNumberOfSnakes - oldNumberOfSnakes);
    }

    @Test
    void checkAdditionOfInvalidSnake() {
        System.out.println("checkAdditionOfInvalidSnake");

        Game game = new Game(boardSize, NORMAL, numDiceFaces, maxNumberOfMoves);

        int oldNumberOfSnakes = game.getBoard().getSnakesMap().size();
        game.addSnake(15, 23);
        int newNumberOfSnakes = game.getBoard().getSnakesMap().size();

        assertEquals(0, newNumberOfSnakes - oldNumberOfSnakes);

        oldNumberOfSnakes = game.getBoard().getSnakesMap().size();
        game.addSnake(23, 0);
        newNumberOfSnakes = game.getBoard().getSnakesMap().size();

        assertEquals(0, newNumberOfSnakes - oldNumberOfSnakes);
    }

    @Test
    void checkAdditionOfSnakeAtSamePosition() {
        System.out.println("checkAdditionOfSnakeAtSamePosition");

        Game game = new Game(boardSize, NORMAL, numDiceFaces, maxNumberOfMoves);

        int oldNumberOfSnakes = game.getBoard().getSnakesMap().size();
        game.addSnake(23, 15);
        int newNumberOfSnakes = game.getBoard().getSnakesMap().size();

        assertEquals(1, newNumberOfSnakes - oldNumberOfSnakes);

        oldNumberOfSnakes = game.getBoard().getSnakesMap().size();
        game.addSnake(23, 15);
        newNumberOfSnakes = game.getBoard().getSnakesMap().size();

        assertEquals(0, newNumberOfSnakes - oldNumberOfSnakes);
    }

    @Test
    void checkSnakeWorks() {
        System.out.println("checkSnakeWorks");

        Game game = new Game(boardSize, NORMAL, numDiceFaces, maxNumberOfMoves);

        game.makeMove();

        int position = game.getPosition();

        game.addSnake(position+1, 1);
        game.addSnake(position+2, 1);
        game.addSnake(position+3, 1);
        game.addSnake(position+4, 1);
        game.addSnake(position+5, 1);
        game.addSnake(position+6, 1);

        game.makeMove();

        assertEquals(1, game.getPosition());
    }

    @Test
    void checkMovesCannotExceedMaxNumberOfMoves() {
        Game game = new Game(boardSize, NORMAL, numDiceFaces, maxNumberOfMoves);

        while (!game.getGameOver()) {
            game.makeMove();
        }

        game.makeMove();

        assertEquals(maxNumberOfMoves, game.getNumberOfMoves());
    }

    @Test
    void checkPositionCannotExceedBoardSize() {
        int smallBoardSize = 6;

        Game game = new Game(smallBoardSize, NORMAL, numDiceFaces, maxNumberOfMoves);

        while (!game.getGameOver()) {
            game.makeMove();
        }

        game.makeMove();

        assertTrue(game.getPosition() <= smallBoardSize);
    }
}