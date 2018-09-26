package design.expressionEvaluator.operator;

public class Minus implements Operator {
    private static int preference = 2;
    private static Tokens token = Tokens.MINUS;
    @Override
    public int operate(int val1, int val2) {
        return val2-val1;
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
        return Action.OPERATE;
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
