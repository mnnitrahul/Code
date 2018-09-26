package design.logger;

public interface ILoggerAppender {

    public void log(LogLevel logLevel, String message);
}
