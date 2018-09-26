package QueryParser;

import java.util.HashMap;
import java.util.Map;

public class VerifyColumns implements VerifyInterface{
	Map<String, Boolean> columns;
	public VerifyColumns(String key){
		columns = new HashMap<String, Boolean>();
		String[] columnStrings = key.split(",");
		for (String columnString: columnStrings) {
			columnString = columnString.trim();
			columns.put(columnString, true);
		}
	}
	public boolean varify(String keyString) {
		String[] keys = keyString.split(",");
		boolean result = true;
		for (String key : keys) {
			key = key.trim();
			Boolean isContain = columns.get(key);
			if (isContain == null) {
				System.out.println("Invalid Query Column " + key + " is not present");
				result = false;
				break;
			}
		}
		return result;
	}
	public boolean hasKey(String key) {
		Boolean value = columns.get(key);
		if (value != null) {
			return true;
		}
		return false;
	}
}
