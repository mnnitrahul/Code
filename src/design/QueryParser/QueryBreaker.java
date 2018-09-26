package QueryParser;

public class QueryBreaker {
	Keyword splitKeyword;
	public QueryBreaker(String keyword) {
		splitKeyword = Keyword.findKeyword(keyword);
		if (splitKeyword == null) {
			throw new NullPointerException("Keyword " + keyword + " is not a valid keyword");
		}
	}
	public String getColumnString(String query) {
		String[] queries = query.split(splitKeyword.name());
		if (queries.length > 2) {
			throw new NullPointerException("More than 1 where exist");
		}
		return queries[0];
	}
	public String getClauseString(String query) {
		String[] queries = query.split(splitKeyword.name());
		if (queries.length > 2) {
			throw new NullPointerException("More than 1 where exist");
		}
		return queries[1];
	}
}
