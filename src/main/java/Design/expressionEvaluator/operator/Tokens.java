package expressionEvaluator.operator;

/**
 * Created by rahul.ka on 04/05/16.
 */
public enum Tokens {
    PLUS("+", "Plus"), MINUS("-", "Minus"), DIVIDE("/", "Divide"), MULTILY("*", "Multiply"),
    START_BRACE("(", "StartBrace"), END_BRACE(")", "EndBrace");
    private String token;
    private String className;
    private Tokens(String token, String className) {
        this.token = token;
        this.className = className;
    }
    public String getToken() {
        return token;
    }
    public static Tokens getToken(String str) {
        for (Tokens tokens : Tokens.values()) {
            if (tokens.getToken().equals(str)) {
                return tokens;
            }
        }
        return null;

    }
    public Operator getOperatorClass() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (Operator)Class.forName("expressionEvaluator.operator."+className).newInstance();
    }

}
