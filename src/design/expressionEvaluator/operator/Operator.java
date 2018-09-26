package design.expressionEvaluator.operator;

public interface Operator {
    public int operate(int val1, int val2);
    public boolean isHigherPreference(Operator op);
    public Action getAction();
    public Tokens getToken();
    public default int getPreference() {
        return -1;
    }

}
