package software.ulpgc.kata6;

import org.junit.Test;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static software.ulpgc.kata6.BoardTest.Cases.*;

import software.ulpgc.kata6.Board;


public class BoardTest {

    @Test
    public void should_return_empty_board_given_3x3_empty(){
        assertThat(new Board(empty3x3).next().toString()).isEqualTo(empty3x3);
    }

    @Test
    public void should_return_empty_board_given3x3_with_one_alive(){
        assertThat(new Board(oneAliveCell3x3).next().toString()).isEqualTo(empty3x3);
    }

    @Test
    public void should_return_empty_board_given4x4_with_one_alive(){
        assertThat(new Board(oneAliveCell4x4).next().toString()).isEqualTo(empty4x4);
    }

    @Test
    public void should_return_empty_board_given3x3_square_with_square_live_cell3x3(){
        assertThat(new Board(squareLiveCell3x3).next().toString()).isEqualTo(squareLiveCell3x3);
    }

    @Test
    public void should_return_empty_board_given3x3_square_with_triangle_live_cell3x3(){
        assertThat(new Board(triangleLiveCell3x3).next().toString()).isEqualTo(squareLiveCell3x3);
    }

    public static class Cases {
        static final String empty3x3 = """
                ...
                ...
                ...
                """;

        static final String oneAliveCell3x3 = """
            ...
            ..X
            ...
            """;


        static final String oneAliveCell4x4 = """
            ....
            ..X.
            ....
            ....
            """;

        static final String empty4x4 ="""
                ....
                ....
                ....
                ....
                """;

        static final String squareLiveCell3x3 = """
            .XX
            .XX
            ...
            """;

        static final String triangleLiveCell3x3 = """
            .X.
            .XX
            ...
            """;
    }
}
