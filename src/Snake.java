public class Snake {
    private final int start;
    private final int end;

    public Snake(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public static boolean isValid(int start, int end) {
        return start >= 1 && start > end;
    }
}
