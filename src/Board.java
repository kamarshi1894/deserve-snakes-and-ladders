import java.util.HashMap;
import java.util.Map;

public class Board {
    private final int size;
    private final Map<Integer, Snake> snakesMap = new HashMap<>();

    public Board(int size) {
        this.size = size;
    }

    public void addSnake(int start, int end) {
        if (snakesMap.containsKey(start)) {
            System.out.println("there is already a snake at position : " + start);
            return;
        }
        snakesMap.put(start, new Snake(start, end));
    }

    public int move(int currentPosition, int delta) {
        int newPosition = currentPosition + delta;

        if (newPosition > size) {
            System.out.println("dice roll causing new position to go beyond size of board " +
                    "so not moving");

            return currentPosition;
        }

        else if (snakesMap.containsKey(newPosition)) {
            System.out.println("snake encountered at " + newPosition);
            return snakesMap.get(newPosition).getEnd();
        }

        return newPosition;
    }
}
