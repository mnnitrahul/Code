package expressionEvaluator.main;

import expressionEvaluator.evaluate.Evaluate;
import expressionEvaluator.parse.Parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 2);
        map.put("b", 10);
        map.put("c", 3);
        Evaluate evaluate = new Evaluate(map);
        Parse parse = new Parse();
        List<Object> objects = new ArrayList();

        List<Object> objectList = parse.parse("(a+4 ) * b");
        System.out.println("ans is " + evaluate.evaluate(objectList));
        objectList = parse.parse("( a + 4 ) * b");
        System.out.println("ans is " + evaluate.evaluate(objectList));
        objectList = parse.parse("(a+4 *c ) * b");
        System.out.println("ans is " + evaluate.evaluate(objectList));

    }
}
