package service;

import enumeration.USER_ROUND;

public class WinningConditionService {

    private WinningConditionService()
    {

    }

    public static WinningConditionService getInstance()
    {
        return new WinningConditionService();
    }

    public USER_ROUND checkWinningCondition(String [][] array)
    {
        if(checkDeadHeat(array)) return USER_ROUND.DEAD_HEAT;

        for(int y = 0; y < 3; y++)
        {
            if(calculateAxisConditionOrReturnFalseIfNull(array[0][y], USER_ROUND.PLAYER1.toString()) &&
                    calculateAxisConditionOrReturnFalseIfNull(array[1][y], USER_ROUND.PLAYER1.toString()) &&
                    calculateAxisConditionOrReturnFalseIfNull(array[2][y], USER_ROUND.PLAYER1.toString())) return USER_ROUND.PLAYER1;
            if(calculateAxisConditionOrReturnFalseIfNull(array[0][y], USER_ROUND.PLAYER2.toString()) &&
                    calculateAxisConditionOrReturnFalseIfNull(array[1][y], USER_ROUND.PLAYER2.toString()) &&
                    calculateAxisConditionOrReturnFalseIfNull(array[2][y], USER_ROUND.PLAYER2.toString())) return USER_ROUND.PLAYER2;
        }

        for(int x = 0; x < 3; x++)
        {
            if(calculateAxisConditionOrReturnFalseIfNull(array[x][0], USER_ROUND.PLAYER1.toString()) &&
                    calculateAxisConditionOrReturnFalseIfNull(array[x][1], USER_ROUND.PLAYER1.toString()) &&
                    calculateAxisConditionOrReturnFalseIfNull(array[x][2], USER_ROUND.PLAYER1.toString())) return USER_ROUND.PLAYER1;
            if(calculateAxisConditionOrReturnFalseIfNull(array[x][0], USER_ROUND.PLAYER2.toString()) &&
                    calculateAxisConditionOrReturnFalseIfNull(array[x][1], USER_ROUND.PLAYER2.toString()) &&
                    calculateAxisConditionOrReturnFalseIfNull(array[x][2], USER_ROUND.PLAYER2.toString())) return USER_ROUND.PLAYER2;
        }

        if(calculateAxisConditionOrReturnFalseIfNull(array[0][0], USER_ROUND.PLAYER1.toString()) &&
                calculateAxisConditionOrReturnFalseIfNull(array[1][1], USER_ROUND.PLAYER1.toString()) &&
                calculateAxisConditionOrReturnFalseIfNull(array[2][2], USER_ROUND.PLAYER1.toString())) return USER_ROUND.PLAYER1;
        if(calculateAxisConditionOrReturnFalseIfNull(array[0][0], USER_ROUND.PLAYER2.toString()) &&
                calculateAxisConditionOrReturnFalseIfNull(array[1][1], USER_ROUND.PLAYER2.toString()) &&
                calculateAxisConditionOrReturnFalseIfNull(array[2][2], USER_ROUND.PLAYER2.toString())) return USER_ROUND.PLAYER2;

        if(calculateAxisConditionOrReturnFalseIfNull(array[2][0], USER_ROUND.PLAYER1.toString()) &&
                calculateAxisConditionOrReturnFalseIfNull(array[1][1], USER_ROUND.PLAYER1.toString()) &&
                calculateAxisConditionOrReturnFalseIfNull(array[0][2], USER_ROUND.PLAYER1.toString())) return USER_ROUND.PLAYER1;
        if(calculateAxisConditionOrReturnFalseIfNull(array[2][0], USER_ROUND.PLAYER2.toString()) &&
                calculateAxisConditionOrReturnFalseIfNull(array[1][1], USER_ROUND.PLAYER2.toString()) &&
                calculateAxisConditionOrReturnFalseIfNull(array[0][2], USER_ROUND.PLAYER2.toString())) return USER_ROUND.PLAYER2;
        return null;
    }

    private Boolean checkDeadHeat(String [][] array)
    {
        for (int x = 0; x < 3; x++)
        {
            for(int y = 0; y < 3; y++)
            {
                if(array[x][y] == null) return false;
            }
        }
        return true;
    }

    private Boolean calculateAxisConditionOrReturnFalseIfNull(String calculated, String expected)
    {
        if(calculated == null) return false;
        return calculated.equals(expected);
    }
}
