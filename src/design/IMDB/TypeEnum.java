package IMDB;

public enum TypeEnum {
	MOVIE, TV, SONG;
	public static TypeEnum getClass(String name) {
		for (TypeEnum type : TypeEnum.values()) {
			if (type.name().equals(name.toUpperCase())) {
				return type; 
			}
		}
		return null;
	}
}
