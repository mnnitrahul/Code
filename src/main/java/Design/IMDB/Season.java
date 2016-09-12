package IMDB;

public enum Season {
	ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);
	private final Integer season;
	private Season(int season) {
		this.season = season;
	}
	int getValue() {
		return season;
	}
	
	public static Season getSeason(int seasonInt) {
		for (Season season : Season.values()) {
			if (season.getValue() == seasonInt) {
				return season;
			}
		}
		return Season.ONE;
	}
}
