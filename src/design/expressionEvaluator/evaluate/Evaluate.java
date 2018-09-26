package design.expressionEvaluator.evaluate;

import design.expressionEvaluator.operator.Action;
import design.expressionEvaluator.operator.Operator;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Evaluate {
    private Map<String, Integer> variables;
    public Evaluate(Map<String, Integer> variables) {
        this.variables = variables;
    }

    public int evaluate(List<Object> tokens) {
        Stack<Integer> values = new Stack<Integer>();
        Stack<Operator> ops = new Stack<Operator>();
        for (int i = 0; i < tokens.size(); ++i) {
            Object object = tokens.get(i);
            if (isVariable(object)) {
                Integer value = variables.get(object.toString());
                if (value == null) {
                    throw new NullPointerException("Invalid value");
                }
                values.add(value);
            } else if(isValue(object)) {
                values.add(Integer.parseInt(object.toString()));
            } else if (isOperator(object)) {
                Operator operator =  (Operator)object;
                String name = operator.getClass().getName();
                if (operator.getAction().equals(Action.PUSH)) {
                    ops.add(operator);
                } else if (operator.getAction().equals(Action.POP)){
                    while (ops.peek().getAction() != Action.PUSH) {
                        values.add(ops.pop().operate(values.pop(), values.pop()));
                    }
                    ops.pop();
                } else {
                    while (!ops.empty() && ops.peek().isHigherPreference(operator)) {
                        values.push(ops.pop().operate(values.pop(), values.pop()));
                    }
                    ops.push(operator);
                }
            }
        }
        while (!ops.empty()) {
            values.push(ops.pop().operate(values.pop(), values.pop()));
        }
        return values.pop();
    }

    private boolean isVariable(Object object) {

        if (object instanceof String) {
            return true;
        }
        return false;
    }

    private boolean isValue(Object object) {
        if (object instanceof Integer) {
            return true;
        }
        return false;
    }

    private boolean isOperator(Object object) {
        if (object instanceof Operator) {
            return true;
        }
        return false;
    }

}
