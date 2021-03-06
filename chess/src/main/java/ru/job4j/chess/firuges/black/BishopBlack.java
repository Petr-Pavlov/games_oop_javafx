package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = calculateDelta(position().getX(), dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = (dest.getX() < position.getX()) ? -1 : 1;
        int deltaY = (dest.getY() < position.getY()) ? -1 : 1;
        for (int index = 0; index < size; index++) {
            int x = position.getX() + (index + 1) * deltaX;
            int y = position.getY() + (index + 1) * deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int deltaX = calculateDelta(source.getX(), dest.getX());
        int deltaY = calculateDelta(source.getY(), dest.getY());
        return (deltaX == deltaY);
    }

    public int calculateDelta(int source, int dest) {
        return Math.abs(source - dest);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
