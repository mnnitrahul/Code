package expressionEvaluator.parse;

import expressionEvaluator.operator.Operator;
import expressionEvaluator.operator.ReserveChar;
import expressionEvaluator.operator.Tokens;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul.ka on 04/05/16.
 */
public class Parse {

    public List<Object> parse(String expression) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        List<Object> objects = new ArrayList<>();
        int i = 0;
        while (i < expression.length()) {
            char chr = expression.charAt(i);
            if (chr == ' ') {
                i++;
                continue;
            }
            if (chr >= '0' && chr <= '9') {
                StringBuffer buffer = new StringBuffer();
                while (i < expression.length() && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                    buffer.append(expression.charAt(i++));
                }
                objects.add(Integer.parseInt(buffer.toString()));
            } else  if (ReserveChar.isReserve(chr)) {
                StringBuffer buffer = new StringBuffer();
                boolean breakLoop = false;
                while (i < expression.length() && ReserveChar.isReserve(chr) && !breakLoop) {
                    buffer.append(expression.charAt(i++));
                    breakLoop = ReserveChar.getReserveChar(chr).isBraces();
                    chr = expression.charAt(i);

                }
                Tokens tokens = Tokens.getToken(buffer.toString());
                Operator operator = tokens.getOperatorClass();
                objects.add(operator);
            } else {
                StringBuffer buffer = new StringBuffer();
                while (i < expression.length() && !ReserveChar.isReserve(chr) && chr != ' ') {
                    buffer.append(expression.charAt(i++));
                    if (i < expression.length()) {
                        chr = expression.charAt(i);
                    }
                }
                objects.add(buffer.toString());
            }
        }
        return objects;
    }

}
