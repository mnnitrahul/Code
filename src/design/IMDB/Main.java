package IMDB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		String[] inputs = {"TYPE movie ACTOR Amitabh ACTOR Shahrukh ACTRESS Aishwarya RATING 5",
				           "TYPE movie ACTOR Amitabh ACTOR Salman ACTRESS Aishwarya RATING 5",
				           "GeT movie ACTOR Amitabh AND ACTOR Salman AND ACTRESS Aishwarya"};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(line);
		
		ArrayList<IMDB.TypeInterface> objects = new ArrayList<IMDB.TypeInterface>();
		for (String inputString : inputs) {
			System.out.println("Input is " + inputString);
			List<String> input = Arrays.asList(inputString.split(" "));
			if (IMDB.CommandLineKeys.GET.compare(input.get(0))) {
				for (IMDB.TypeInterface object : objects) {
					if(object.isMatch(input)) {
						System.out.print("Mating string is ");
						object.getDetails();
					}
				}
				continue;
			}
			for (int i = 0;i<input.size(); i++) {
				if (IMDB.CommandLineKeys.TYPE.compare(input.get(i))) {
					IMDB.TypeInterface type = getType(input.get(i+1));
					type.initialize(input);
					objects.add(type);
					break;
				}
			}
		}		
	}
	public static IMDB.TypeInterface getType(String name) {
		TypeEnum type = IMDB.TypeEnum.getClass(name);
		if (type == IMDB.TypeEnum.MOVIE) {
			return new IMDB.Movie();
		}
		return null;
	}
}
