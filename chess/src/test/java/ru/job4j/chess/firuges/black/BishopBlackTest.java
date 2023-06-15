package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

class BishopBlackTest {

    @Test
    void whenSamePosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Cell result = bishopBlack.position();
        Cell expected = Cell.A1;
        assertThat(result).isEqualTo(expected);

    }

    @Test
    void whenTheCopyIsSuccessful() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        BishopBlack newBishopPos = (BishopBlack) bishopBlack.copy(Cell.B2);
        Cell result = newBishopPos.position();
        Cell expected = Cell.B2;
        assertThat(result).isEqualTo(expected);

    }

    @Test
    void whenMoveFromC1ToG5() {
        Cell[] result = new BishopBlack(Cell.C1).way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result).containsExactly(expected);
    }

    @Test
    void whenNotDiagonal() {
        Cell pos = Cell.A1;
        Cell dest = Cell.D2;
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    new BishopBlack(pos).way(dest);
                });
        assertThat(exception.getMessage()).isEqualTo(String.format(
                "Could not way by diagonal from %s to %s", pos, dest));
    }

}