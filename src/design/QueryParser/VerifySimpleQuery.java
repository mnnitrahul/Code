package QueryParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerifySimpleQuery implements VerifyInterface{
	
/*	public boolean varify(String clauseString) {
		ArrayList<String> clauseStrings = new ArrayList<String>(); 
		int endIndex = -1;
		System.out.println(clauseString);
		int startIndex = clauseString.indexOf("(", endIndex+1);
		while (startIndex >=0) {
			endIndex = clauseString.indexOf(")", endIndex+1);
			System.out.println("indexes are " + startIndex + " " + endIndex);
			System.out.println(clauseString.substring(startIndex+1, endIndex));
			clauseStrings.add(clauseString.substring(startIndex+1, endIndex));
			startIndex = clauseString.indexOf("(", endIndex+1);
		}
		clauseStrings.add(clauseString.substring(endIndex+1, clauseString.length()-2));
		
		System.out.println("clauses are " + Arrays.toString(clauseStrings.toArray()));
		return false;
	}*/
	
	public boolean varify(String clauseString) {
		List<SuperClause> superClauses = new ArrayList<SuperClause>();
		String[] keys = clauseString.split(Keyword.or.name());
		for (String key : keys) {
			String[] columns = key.split(Keyword.and.name());
			for (String column: columns) {
				String[] breakColumns = column.split("=");
				if (breakColumns.length == 1) {
					breakColumns = column.split("<");
				} if (breakColumns.length == 1) {
					breakColumns = column.split(">");
				} 
				boolean isFound = false;
				System.out.println("clauses are " + Arrays.toString(breakColumns));
				for (SuperClause superClause : superClauses) {
					if (superClause.IsContain(breakColumns)) {
						System.out.println("Not require");
						isFound = true;
						break;
					}
				}
				if (isFound == false) {
					SuperClause s = new SuperClause(breakColumns);
					superClauses.add(s);
				}
			}
		}
		
		return false;
	}
}
