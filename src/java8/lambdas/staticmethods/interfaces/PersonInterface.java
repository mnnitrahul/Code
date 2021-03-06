package java8.lambdas.staticmethods.interfaces;

import java8.lambdas.staticmethods.model.Person;

public interface PersonInterface {

    String getName();

    void setName(String name);

    int getAge();

    void setAge(int age);

    static String getPersonInfo(Person p) {
        return p.getName() + " (" + p.getAge() + ")";
    }
}
