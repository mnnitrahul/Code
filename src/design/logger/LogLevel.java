package design.logger;

public enum LogLevel {
    INFO(1), WARNING(2), ERROR(3);
    private int level;
    LogLevel(int level) {
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }
}
