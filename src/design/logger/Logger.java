package design.logger;

import java.util.ArrayList;
import java.util.List;

public class Logger implements ILogger{
    String name;
    LogLevel level;
    List<ILoggerAppender> loggerAppenders;

    protected Logger(String name, LogLevel level, List<ILoggerAppender> loggerAppenders) {
        this.name = name;
        this.level = level;
        this.loggerAppenders = loggerAppenders;
    }

    protected void addAppender(ILoggerAppender loggerAppender) {
        if (loggerAppenders == null) {
            loggerAppenders = new ArrayList<>();
        }
        loggerAppenders.add(loggerAppender);
    }

    @Override
    public void logInfo(Object message) {
        if (level.getLevel() <= LogLevel.INFO.getLevel() && loggerAppenders != null) {
            for (ILoggerAppender loggerAppender : loggerAppenders) {
                loggerAppender.log(LogLevel.INFO, message.toString());
            }
        }
    }

    @Override
    public void logWarn(Object message) {
        if (level.getLevel() <= LogLevel.WARNING.getLevel() && loggerAppenders != null) {
            for (ILoggerAppender loggerAppender : loggerAppenders) {
                loggerAppender.log(LogLevel.WARNING, message.toString());
            }
        }
    }

    @Override
    public void logError(Object message) {
        if (level.getLevel() <= LogLevel.ERROR.getLevel() && loggerAppenders != null) {
            for (ILoggerAppender loggerAppender : loggerAppenders) {
                loggerAppender.log(LogLevel.ERROR, message.toString());
            }
        }
    }
}
