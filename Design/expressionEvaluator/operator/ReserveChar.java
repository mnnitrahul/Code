package expressionEvaluator.operator;

/**
 * Created by rahul.ka on 04/05/16.
 */
public enum ReserveChar {
    PLUS('+', false), MINUS('-', false), DIVIDE('/', false), MULTILY('*', false), START_BRACE('(', true),
    END_BRACE(')', true);
    private char resChar;
    private boolean isBraces;
    private ReserveChar(char resChar, boolean isBraces) {
        this.resChar = resChar;
        this.isBraces = isBraces;
    }
    public char getResChar() {
        return resChar;
    }
    public boolean isBraces() {
        return isBraces;
    }
    public static boolean isReserve(char chr) {
        for (ReserveChar reserveChar : ReserveChar.values()) {
            if (reserveChar.getResChar() == chr) {
                return true;
            }
        }
        return false;

    }

    public static ReserveChar getReserveChar(char chr) {
        for (ReserveChar reserveChar : ReserveChar.values()) {
            if (reserveChar.getResChar() == chr) {
                return reserveChar;
            }
        }
        return null;

    }
}
