package IMDB;

public enum Language {
	HINDI, ENGLISH, NONE;
	private Language() {
		
	}
	public static Language getLanguage(String languageString) {
		for (Language language : Language.values()) {
			if (language.name() == languageString.toUpperCase()) {
				return language;
			}
		}
		return Language.NONE;
	}
	public String toString() {
		return this.name();
	}
}
