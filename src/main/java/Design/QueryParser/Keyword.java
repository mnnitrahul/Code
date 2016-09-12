package QueryParser;

public enum Keyword {
	where, or , and;
	public static Keyword findKeyword(String keyword) {
		for (Keyword k : Keyword.values()) {
			if (keyword.equals(k.name())) {
				return k;
			}
		}
		return null;
	}
}
