package design.logger;

public class TestClass {
    public static void main(String[] args) throws InterruptedException {
        ILogger logger = LogFactory.getLogger("test");
        logger.logWarn("test warn");
        logger.logInfo("test info");
        for (int i = 0; i < 14; ++ i) {
            logger.logError("test error " + i);
        }
        Thread.sleep(100);
    }
}
