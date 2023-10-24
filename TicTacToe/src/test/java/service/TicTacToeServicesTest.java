package service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeServicesTest {

    private TicTacToeService ticTacToeService;

    @BeforeEach
    public void init()
    {
        ticTacToeService = TicTacToeService.getInstance();
    }

    @Test
    public void outOfRangeXAxis()
    {
        Assertions.assertThatThrownBy( () ->{
            ticTacToeService.setCharacterOnPosition(5,0);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void outOfRangeYAxis()
    {
        Assertions.assertThatThrownBy(() ->{
            ticTacToeService.setCharacterOnPosition(0,5);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void fillOnNonEmptySpace()
    {
        ticTacToeService.setCharacterOnPosition(2,2);
        Assertions.assertThatThrownBy(() ->{
            ticTacToeService.setCharacterOnPosition(2,2);
        }).isInstanceOf(RuntimeException.class);
    }
}
