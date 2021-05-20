package ru.job4j.chess;

import org.junit.Test;
import org.junit.Assert;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;


public class BishopTest {
    @Test
    public void positionTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A6);
        Assert.assertEquals(bishopBlack.position(), Cell.A6);
    }

    @Test
    public void copyTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A6);
        bishopBlack = (BishopBlack) bishopBlack.copy(Cell.A5);
        Assert.assertEquals(bishopBlack.position(), Cell.A5);
    }

    @Test
    public void wayTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] actual = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void whenIsDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        boolean actual = bishopBlack.isDiagonal(Cell.C1, Cell.F4);
        Assert.assertTrue(actual);
    }

    @Test
    public void whenNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        boolean actual = bishopBlack.isDiagonal(Cell.C1, Cell.F5);
        Assert.assertFalse(actual);
    }
}
