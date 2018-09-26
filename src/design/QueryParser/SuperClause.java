package QueryParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuperClause {
	Map<String, Boolean> columns;
	public SuperClause(String[] columns) {
		this.columns= new HashMap<String, Boolean>();
		for(String column : columns) {
			this.columns.put(column, true);
		}
	}
	public boolean IsContain(String[] inputs) {
		boolean result = true;
		for (String input : inputs) {
			Boolean isContain = columns.get(input);
			if (isContain == null) {
				result = false;
				break;
			}
		}
		return result;
	}
	
}
