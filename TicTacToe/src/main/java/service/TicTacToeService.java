package service;

import enumeration.USER_ROUND;

public class TicTacToeService {

    private String [][] ticTacToeMatrix = null;

    private UserRoundService userRoundService;
    private WinningConditionService winningConditionService;

    private Boolean gameFinished;

    private TicTacToeService()
    {
        ticTacToeMatrix = new String[3][3];
        this.userRoundService = UserRoundService.getInstance();
        this.winningConditionService = WinningConditionService.getInstance();
        this.gameFinished = false;
        this.userRoundService.startGame();
    }

    public static TicTacToeService getInstance()
    {
        return new TicTacToeService();
    }

    public String [][] setCharacterOnPosition(int x, int y) throws RuntimeException
    {
        if(x >= 3 || x < 0) throw new RuntimeException("X axis cannot be bigger than 3 or less than 0");
        if(y >= 3 || y < 0) throw new RuntimeException("Y axis cannot be bigger than 3 or less than 0");
        if(this.ticTacToeMatrix[x][y] != null) throw new RuntimeException("Character cannot be placed on non empty space");
        this.ticTacToeMatrix[x][y] = this.userRoundService.currentRound().toString();
        checkFinishCondition();
        this.userRoundService.nextRound();        
        return this.ticTacToeMatrix;
    }

    public USER_ROUND getCurrentUser()
    {
        return this.userRoundService.currentRound();
    }

    public Boolean isGameFinished()
    {
        return this.gameFinished;
    }

    private void checkFinishCondition()
    {
        if(this.winningConditionService.checkWinningCondition(this.ticTacToeMatrix) == USER_ROUND.DEAD_HEAT)
        {
            System.out.println("DEAD-HEAT!");
            this.gameFinished = true;
        }
        if(this.winningConditionService.checkWinningCondition(this.ticTacToeMatrix) != null)
        {
            System.out.println("Player: "+userRoundService.currentRound()+" win! Congratulation");
            this.gameFinished = true;
        }
    }
}
