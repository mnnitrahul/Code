package QueryParser;

public enum Comparator {
	EQUALS("="), LESSTHAN("<"), GREATERTHAN(">");
	String symbol;
	private Comparator(String symbol) {
		this.symbol = symbol;
	}
}
