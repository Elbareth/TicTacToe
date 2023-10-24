package enumeration;

public enum USER_ROUND {

    PLAYER1("X"),
    PLAYER2("0"),

    DEAD_HEAT("-");

    String character;

    @Override
    public String toString()
    {
        return character;
    }

    private USER_ROUND(String character)
    {
        this.character = character;
    }
}
