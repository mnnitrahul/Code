package design.expressionEvaluator.operator;

public class Plus implements Operator {
    private static int preference = 2;
    private static Tokens token = Tokens.PLUS;
    @Override
    public int operate(int val1, int val2) {
        return val1+val2;
    }

    @Override
    public int getPreference() {
        return preference;
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
    public Tokens getToken() {
        return token;
    }


}
