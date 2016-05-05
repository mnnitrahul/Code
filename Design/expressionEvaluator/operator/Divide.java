package expressionEvaluator.operator;

public class Divide implements Operator {
    private static int preference = 3;
    private static Tokens token = Tokens.DIVIDE;

    @Override
    public int operate(int val1, int val2) {
        return val2/val1;
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
