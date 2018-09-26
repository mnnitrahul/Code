package java8.lambdas.functionalinterface;

import java8.lambdas.functionalinterface.interfaces.SimpleInterface;

public class UseSimpleInterface {

    public static void main(String[] args) {

        SimpleInterface obj = () -> System.out.println("Say something");
        obj.doSomething();

    }

}
