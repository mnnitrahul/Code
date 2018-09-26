package design.logger;

import java.util.HashMap;
import java.util.Map;

public class LogFactory {
    private static Map<String , String> configMap;
    private static Map<String, ILogger> loggerMap;


    public static ILogger getLogger(String name) {

        if (loggerMap == null) {
            configMap = new HashMap<>();
            configMap.put("testlogLevel", "INFO");
            configMap.put("testlogAppenders", "console");
            configMap.put("consolelogAppenderType", "CONSOLE");
            configMap.put("consolelogLevel", "WARNING");
            loggerMap = new HashMap<>();
        }
        if (loggerMap.get(name) != null) {
            return loggerMap.get(name);
        }
        Logger logger = new Logger(name, LogLevel.valueOf(configMap.get(name+"logLevel")), null);
        String[] appenders = configMap.get(name+"logAppenders").split(",");
        for (String appender : appenders) {
            String type =  configMap.get(appender + "logAppenderType");
            String level =  configMap.get(appender + "logLevel");
            if (type.equals("CONSOLE")) {
                ILoggerAppender logAppender = new ConsoleCacheAppender(level);
                logger.addAppender(logAppender);
            }
        }
        loggerMap.put(name, logger);
        return logger;
    }
}
