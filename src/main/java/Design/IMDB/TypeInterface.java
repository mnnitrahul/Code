package IMDB;

import java.util.List;

public interface TypeInterface {
	public void initialize(List<String> inputs);
	public void getDetails();
	public boolean isMatch(List<String> inputs);
}
