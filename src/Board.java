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

        if (Snake.isValid(start, end)) {
            snakesMap.put(start, new Snake(start, end));
        } else {
            System.out.println("start position cannot be lesser than end position for snake");
        }

        System.out.println("Snake added at " + start);
    }

    private int goThroughSnake(int position) {
        if (snakesMap.containsKey(position)) {
            System.out.println("snake encountered at " + position);
            return snakesMap.get(position).getEnd();
        }
        return position;
    }

    public int move(int currentPosition, int delta) {
        int newPosition = currentPosition + delta;

        if (newPosition > size) {
            System.out.println("dice roll causing new position to go beyond size of board " +
                    "so not moving");

            return currentPosition;
        }

        newPosition = goThroughSnake(newPosition);

        return newPosition;
    }

    public int getSize() {
        return this.size;
    }

    public Map<Integer, Snake> getSnakesMap() {
        return this.snakesMap;
    }
}
