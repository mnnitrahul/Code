package design.logger;

public interface ILogger {

    public void logInfo(Object message);
    public void logWarn(Object message);
    public void logError(Object message);
}
