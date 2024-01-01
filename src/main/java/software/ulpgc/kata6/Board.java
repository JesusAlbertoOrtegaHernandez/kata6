package software.ulpgc.kata6;

import java.util.Arrays;
import java.util.List;

import static software.ulpgc.kata6.Point.at;

public class Board {
    private static final char Alive = 'X';
    private static final char Dead = '.';
    private final String[] states;

    public Board(String states) {
        this.states = states.split("\n");
    }

    private Cell cell(Point point) {
        return new Cell() {
            @Override
            public int neighbors() {
                return (int) offsets.stream()
                        .map(point::add)
                        .filter(this::isInBounds)
                        .filter(p -> cell(p).isAlive())
                        .count();
            }

            private boolean isInBounds(Point point) {
                return point.x() >= 0 && point.y() >= 0 && point.x() < colums() && point.y() < rows();
            }

            @Override
            public boolean isAlive() {
                return states[point.x()].charAt(point.y()) == Alive;
            }
        };
    }

    public Board next(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < colums(); i++){
            for (int j = 0; j < rows(); j++)
                stringBuilder.append(shouldBeAlive(cell(at(i, j)))? Alive: Dead);
                stringBuilder.append("\n");
        }
        return new Board(stringBuilder.toString());
    }

    private boolean shouldBeAlive(Cell cell) {
        return cell.isAlive()?
                is(cell.neighbors(), 2, 3):
                is(cell.neighbors(), 3);
    }

    private static boolean is(int value, int... options) {
        return Arrays.stream(options).anyMatch(o -> o == value);
    }


    private static final List<Point> offsets = List.of(
            at(-1, -1), at(-1, 0), at(-1, 1),
            at(0, -1), at(0, 1),
            at(1, -1), at(1, 0), at(1, 1)
    );



    private int rows() {
        return states.length;
    }

    private int colums() {
        return states[0].length();
    }

    public interface Cell{
        int neighbors();
        boolean isAlive();
    }
    @Override
    public String toString() {
        return String.join("\n", states) + "\n";
    }
}
