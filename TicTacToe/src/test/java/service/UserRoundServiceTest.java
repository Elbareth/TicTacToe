package service;

import enumeration.USER_ROUND;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserRoundServiceTest {

    private UserRoundService userRoundService;

    @BeforeEach
    public void init()
    {
        this.userRoundService = UserRoundService.getInstance();
    }

    @Test
    public void startGame()
    {
        this.userRoundService.startGame();
        Assertions.assertThat(this.userRoundService.currentRound()).isEqualTo(USER_ROUND.PLAYER1);
    }

    @Test
    public void afterFirstPlayerSecondPlayerNeedToStart()
    {
        this.userRoundService.startGame();
        this.userRoundService.nextRound();
        Assertions.assertThat(this.userRoundService.currentRound()).isEqualTo(USER_ROUND.PLAYER2);
    }

    @Test
    public void afterSecondPlayerFirstPlayerNeedToStart()
    {
        //This text is unnecessary
        this.userRoundService.startGame();
        this.userRoundService.nextRound();
        this.userRoundService.nextRound();
        Assertions.assertThat(this.userRoundService.currentRound()).isEqualTo(USER_ROUND.PLAYER1);
    }
}
