package IMDB;

public enum Rating {
	ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), ZERO(0);
	private final Integer rating;
	private Rating(int rating) {
		this.rating = rating;
	}
	int getValue() {
		return rating;
	}
	
	public static Rating getRating(int rate) {
		for (Rating rating : Rating.values()) {
			if (rating.getValue() == rate) {
				return rating;
			}
		}
		return Rating.ZERO;
	}
}
