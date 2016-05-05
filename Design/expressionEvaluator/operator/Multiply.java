package expressionEvaluator.operator;

public class Multiply implements Operator {
    private static int preference = 3;
    private static Tokens token = Tokens.MULTILY;
    @Override
    public int operate(int val1, int val2) {
        return val1*val2;
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
