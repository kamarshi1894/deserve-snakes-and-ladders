import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTests {
    private final int boardSize = 100;
    private final int numDiceFaces = 6;
    private final int maxNumberOfMoves = 10;

    @Test
    void checkCrookedDiceValueIsEven() {
        System.out.println("checkCrookedDiceValueIsEven");

        Game crookedDiceGame = new Game(boardSize, "crooked", numDiceFaces, maxNumberOfMoves);

        while (!crookedDiceGame.getGameOver()) {
            int oldPosition = crookedDiceGame.getPosition();
            crookedDiceGame.makeMove();
            int newPosition = crookedDiceGame.getPosition();

            assertEquals(0, Math.abs(newPosition - oldPosition) % 2);
        }
    }

    @Test
    void checkAdditionOfValidSnake() {
        System.out.println("checkAdditionOfValidSnake");

        Game fairDiceGame = new Game(boardSize, "normal", numDiceFaces, maxNumberOfMoves);

        int oldNumberOfSnakes = fairDiceGame.getBoard().getSnakesMap().size();
        fairDiceGame.addSnake(23, 15);
        int newNumberOfSnakes = fairDiceGame.getBoard().getSnakesMap().size();

        assertEquals(1, newNumberOfSnakes - oldNumberOfSnakes);
    }

    @Test
    void checkAdditionOfInvalidSnake() {
        System.out.println("checkAdditionOfInvalidSnake");

        Game fairDiceGame = new Game(boardSize, "normal", numDiceFaces, maxNumberOfMoves);

        int oldNumberOfSnakes = fairDiceGame.getBoard().getSnakesMap().size();
        fairDiceGame.addSnake(15, 23);
        int newNumberOfSnakes = fairDiceGame.getBoard().getSnakesMap().size();

        assertEquals(0, newNumberOfSnakes - oldNumberOfSnakes);

        oldNumberOfSnakes = fairDiceGame.getBoard().getSnakesMap().size();
        fairDiceGame.addSnake(23, 0);
        newNumberOfSnakes = fairDiceGame.getBoard().getSnakesMap().size();

        assertEquals(0, newNumberOfSnakes - oldNumberOfSnakes);
    }

    @Test
    void checkAdditionOfSnakeAtSamePosition() {
        System.out.println("checkAdditionOfSnakeAtSamePosition");

        Game fairDiceGame = new Game(boardSize, "normal", numDiceFaces, maxNumberOfMoves);

        int oldNumberOfSnakes = fairDiceGame.getBoard().getSnakesMap().size();
        fairDiceGame.addSnake(23, 15);
        int newNumberOfSnakes = fairDiceGame.getBoard().getSnakesMap().size();

        assertEquals(1, newNumberOfSnakes - oldNumberOfSnakes);

        oldNumberOfSnakes = fairDiceGame.getBoard().getSnakesMap().size();
        fairDiceGame.addSnake(23, 15);
        newNumberOfSnakes = fairDiceGame.getBoard().getSnakesMap().size();

        assertEquals(0, newNumberOfSnakes - oldNumberOfSnakes);
    }

    @Test
    void checkSnakeWorks() {
        System.out.println("checkSnakeWorks");

        Game fairDiceGame = new Game(boardSize, "normal", numDiceFaces, maxNumberOfMoves);

        fairDiceGame.makeMove();

        int position = fairDiceGame.getPosition();

        fairDiceGame.addSnake(position+1, 1);
        fairDiceGame.addSnake(position+2, 1);
        fairDiceGame.addSnake(position+3, 1);
        fairDiceGame.addSnake(position+4, 1);
        fairDiceGame.addSnake(position+5, 1);
        fairDiceGame.addSnake(position+6, 1);

        fairDiceGame.makeMove();

        assertEquals(1, fairDiceGame.getPosition());
    }


}