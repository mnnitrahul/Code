package design.logger;


public class ConsoleAppender implements ILoggerAppender{
    private LogLevel level;
    protected ConsoleAppender(String level) {
        if (level != null) {
            this.level = LogLevel.valueOf(level);
        }
    }
    @Override
    public void log(LogLevel logLevel, String message) {
        if (level.getLevel() <= logLevel.getLevel()) {
            System.out.println(message);
        }
    }
}
