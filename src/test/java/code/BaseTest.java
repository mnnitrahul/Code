package code;

import org.junit.Rule;
import org.junit.rules.TestName;

/**
 * Created by rahul.ka on 19/09/16.
 */
public abstract class BaseTest {
    @Rule
    public TestName name = new TestName();
}
