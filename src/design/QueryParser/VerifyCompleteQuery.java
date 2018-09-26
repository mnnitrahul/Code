package QueryParser;

public class VerifyCompleteQuery implements VerifyInterface {
	QueryBreaker queryBreaker;
	VerifyInterface verifyColumns;
	VerifyInterface verifySimpleQuery;
	public VerifyCompleteQuery(VerifyInterface verifyColumns, VerifyInterface verifySimpleQuery) {
		queryBreaker = new QueryBreaker("where");
		this.verifyColumns = verifyColumns;
		this.verifySimpleQuery = verifySimpleQuery;
	}
	public boolean varify(String key) {
		String clauseString = queryBreaker.getClauseString(key);
		String columnString = queryBreaker.getColumnString(key);
		boolean result = verifyColumns.varify(columnString);
		if (result == false) {
			return false;
		}
		result = verifySimpleQuery.varify(clauseString);
		return result;
	}
	
}
