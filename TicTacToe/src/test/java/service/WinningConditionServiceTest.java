package service;

import enumeration.USER_ROUND;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningConditionServiceTest {


    private WinningConditionService winningConditionService;

    @BeforeEach
    public void init()
    {
        this.winningConditionService = WinningConditionService.getInstance();
    }

    @Test
    public void winningOnXAxis()
    {
        String [][] arrayWithWinningOnXAxis = new String [][] {new String[] {"X","X","X"}, new String [] {null, null, null}, new String [] {null, null, null}};
        Assertions.assertThat(this.winningConditionService.checkWinningCondition(arrayWithWinningOnXAxis)).isEqualTo(USER_ROUND.PLAYER1);
    }

    @Test
    public void winningOnYAxis()
    {
        String [][] arrayWithWinningOnXAxis = new String [][] {new String[] {"X",null,null}, new String [] {"X", null, null}, new String [] {"X", null, null}};
        Assertions.assertThat(this.winningConditionService.checkWinningCondition(arrayWithWinningOnXAxis)).isEqualTo(USER_ROUND.PLAYER1);
    }

    @Test
    void winningOnDiagonal()
    {
        String [][] arrayWithWinningOnXAxis = new String [][] {new String[] {"X",null,null}, new String [] {null, "X", null}, new String [] {null, null, "X"}};
        Assertions.assertThat(this.winningConditionService.checkWinningCondition(arrayWithWinningOnXAxis)).isEqualTo(USER_ROUND.PLAYER1);
    }
    @Test
    void winningOnDiagonal2()
    {
        String [][] arrayWithWinningOnXAxis = new String [][] {new String[] {null,null,"X"}, new String [] {null, "X", null}, new String [] {"X", null, null}};
        Assertions.assertThat(this.winningConditionService.checkWinningCondition(arrayWithWinningOnXAxis)).isEqualTo(USER_ROUND.PLAYER1);
    }
    @Test
    void withoutWinner()
    {
        String [][] arrayWithWinningOnXAxis = new String [][] {new String[] {null,null,"X"}, new String [] {null, null, "X"}, new String [] {"X", null, null}};
        Assertions.assertThat(this.winningConditionService.checkWinningCondition(arrayWithWinningOnXAxis)).isEqualTo(null);
    }

    @Test
    void checkDeadHeatConditions()
    {
        String [][] arrayWithWinningOnXAxis = new String [][] {new String[] {"X","O","X"}, new String [] {"O", "X", "0"}, new String [] {"X", "X", "O"}};
        Assertions.assertThat(this.winningConditionService.checkWinningCondition(arrayWithWinningOnXAxis)).isEqualTo(USER_ROUND.DEAD_HEAT);
    }
}
