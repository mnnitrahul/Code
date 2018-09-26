package design.expressionEvaluator.operator;

public class EndBrace implements Operator {
    private static int preference = 4;
    private static Tokens token = Tokens.END_BRACE;
    @Override
    public int operate(int val1, int val2) {
        throw new RuntimeException();
    }
    @Override
    public boolean isHigherPreference(Operator op) {
        if(preference > op.getPreference()) {
            return true;
        }
        return false;
    }

    @Override
    public Action getAction() {
        return Action.POP;
    }


    @Override
    public int getPreference() {
        return preference;
    }

    @Override
    public Tokens getToken() {
        return token;
    }


}
