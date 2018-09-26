package IMDB;

import java.util.ArrayList;
import java.util.List;

public class Movie implements TypeInterface {
	List<Actor> actors;
	List<Actress> actresses;
	Language language;
	Integer year;
	Rating rating;
	public Movie() {
		actors = new ArrayList<Actor>();
		actresses = new ArrayList<Actress>();
		language = Language.NONE;
		rating = Rating.ZERO;
	}
	public void addActor(String name) {
		Actor actor = new Actor(name);
		actors.add(actor);
	}
	public void addActress(String name) {
		Actress actress = new Actress(name);
		actresses.add(actress);
	}
	public void setLanguage(String language)  {
		this.language = Language.getLanguage(language);
	}
	public void setYear(String year) {
		this.year = Integer.parseInt(year);
	}
	public void setRating(String rating) {
		this.rating = Rating.getRating(Integer.parseInt(rating));
	}
	public void initialize(List<String> inputs) {
			for (int i = 0;i<inputs.size(); ++i) {
				String key = inputs.get(i);i++;
				String value = inputs.get(i);
				if (CommandLineKeys.ACTOR.compare(key)) {
					addActor(value);
					continue;
				}
				if (CommandLineKeys.ACTRESS.compare(key)) {
					addActress(value);
					continue;
				}
				if (CommandLineKeys.LANGUAGE.compare(key)) {
					setLanguage(value);
					continue;
				}
				if (CommandLineKeys.RATING.compare(key)) {
					setRating(value);
					continue;
				}
				if (CommandLineKeys.YEAR.compare(key)) {
					setYear(value);
					continue;
				}
			}
	}
	public void getDetails() {
		for (Actor actor :actors) {
			System.out.println("Actor : " + actor.toString());
		}
		for (Actress actress :actresses) {
			System.out.println("Actress : " + actress.toString());
		}
		if (year != null) {
			System.out.println("Year : " + year);
		}
		System.out.println("Language : " + language.toString());
		System.out.println("Rating : " + rating.getValue());
	}
	
	public boolean isMatch(List<String> inputs) {
		boolean result = false;
		CommandLineKeys operation = CommandLineKeys.OR;
		for (int i = 0;i<inputs.size(); ++i) {
			String key = inputs.get(i);
			if (CommandLineKeys.OR.compare(key)) {
				operation = CommandLineKeys.OR;
				continue;
			}
			if (CommandLineKeys.AND.compare(key)) {
				operation = CommandLineKeys.AND;
				continue;
			}
			i++;
			String value = inputs.get(i);
			if (CommandLineKeys.ACTOR.compare(key)) {
				boolean satisfy = false;
				for (Actor actor : actors) {
					if (actor.getName().equals(value)) {
						satisfy = true;
						break;
					}
				}
				if (operation == CommandLineKeys.OR) {
					result = result || satisfy;
					operation = null;
				}
				if (operation == CommandLineKeys.AND) {
					result = result && satisfy;
					operation = null;
				}
				continue;
			}
			if (CommandLineKeys.ACTRESS.compare(key)) {
				boolean satisfy = false;
				for (Actress actress : actresses) {
					if (actress.getName().equals(value)) {
						satisfy = true;
						break;
					}
				}
				if (operation == CommandLineKeys.OR) {
					result = result || satisfy;
					operation = null;
				}
				if (operation == CommandLineKeys.AND) {
					result = result && satisfy;
					operation = null;
				}
				continue;
			}
			if (CommandLineKeys.LANGUAGE.compare(key)) {
				Language find = Language.getLanguage(value);
				boolean satisfy = false;
				if (find.equals(language)) {
					satisfy = true;
				}
				if (operation == CommandLineKeys.OR) {
					result = result || satisfy;
					operation = null;
				}
				if (operation == CommandLineKeys.AND) {
					result = result && satisfy;
					operation = null;
				}
				continue;
			}
			if (CommandLineKeys.RATING.compare(key)) {
				
				Rating find = Rating.getRating(Integer.parseInt(value));
				boolean satisfy = false;
				if (find.equals(rating)) {
					satisfy = true;
				}
				if (operation == CommandLineKeys.OR) {
					result = result || satisfy;
					operation = null;
				}
				if (operation == CommandLineKeys.AND) {
					result = result && satisfy;
					operation = null;
				}
				continue;
			}
			if (CommandLineKeys.YEAR.compare(key)) {
				boolean satisfy = false;
				if (year == Integer.parseInt(value)) {
					satisfy = true;
				}
				if (operation == CommandLineKeys.OR) {
					result = result || satisfy;
					operation = null;
				}
				if (operation == CommandLineKeys.AND) {
					result = result && satisfy;
					operation = null;
				}
				continue;
			}
		}

		return result;
	}
 }
