package service;

import enumeration.USER_ROUND;

public class UserRoundService {

    private static USER_ROUND currentUser;

    private UserRoundService()
    {

    }

    public static UserRoundService getInstance()
    {
        return new UserRoundService();
    }

    public USER_ROUND currentRound()
    {
        return currentUser;
    }

    public void nextRound()
    {
        if(currentUser == USER_ROUND.PLAYER1) currentUser = USER_ROUND.PLAYER2;
        else if(currentUser == USER_ROUND.PLAYER2) currentUser = USER_ROUND.PLAYER1;
    }

    public void startGame()
    {
        currentUser = USER_ROUND.PLAYER1;
    }
}
