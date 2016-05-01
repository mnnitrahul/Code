package IMDB;

public enum CommandLineKeys {
	ACTOR, ACTRESS, LANGUAGE, YEAR, RATING, SEASIONS, TYPE, OR, AND, GET;
	boolean compare(String input) {
		if (this.toString().equals(input.toUpperCase())) {
			return true;
		}
		return false;
	}
}
