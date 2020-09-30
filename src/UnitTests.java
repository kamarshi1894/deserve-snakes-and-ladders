import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTests {
    private int boardSize = 100;
    private int numDiceFaces = 6;

    // private Game fairDiceGame = new Game(boardSize, "normal", numDiceFaces);
    // private Game crookedDiceGame = new Game(boardSize, "crooked", numDiceFaces);

    @Test
    void checkCrookedDiceValueIsEven() {
        Game crookedDiceGame = new Game(boardSize, "crooked", numDiceFaces);

        for (int i = 0; i < 20; i++) {
            int oldPosition = crookedDiceGame.getPosition();
            crookedDiceGame.makeMove();
            int newPosition = crookedDiceGame.getPosition();

            assertEquals(0, Math.abs(newPosition - oldPosition) % 2);
        }
    }

    @Test
    void checkAdditionOfValidSnake() {
        Game fairDiceGame = new Game(boardSize, "normal", numDiceFaces);

        int oldNumberOfSnakes = fairDiceGame.getBoard().getSnakesMap().size();
        fairDiceGame.addSnake(23, 15);
        int newNumberOfSnakes = fairDiceGame.getBoard().getSnakesMap().size();

        assertEquals(1, newNumberOfSnakes - oldNumberOfSnakes);
    }

    @Test
    void checkAdditionOfInvalidSnake() {
        Game fairDiceGame = new Game(boardSize, "normal", numDiceFaces);

        int oldNumberOfSnakes = fairDiceGame.getBoard().getSnakesMap().size();
        fairDiceGame.addSnake(15, 23);
        int newNumberOfSnakes = fairDiceGame.getBoard().getSnakesMap().size();

        assertEquals(0, newNumberOfSnakes - oldNumberOfSnakes);
    }

    @Test
    void checkAdditionOfSnakeAtSamePosition() {
        Game fairDiceGame = new Game(boardSize, "normal", numDiceFaces);

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
        Game fairDiceGame = new Game(boardSize, "normal", numDiceFaces);

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